package com.example.tbproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SavedNotes extends AppCompatActivity {

    protected static  final  int RESULT_SPEECH = 1 ;
    private Note selectedNote;

    ImageButton btSpeak;
    Button btSearch ;
    TextView  savedTxt , text ;
    String categ , details, surname, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_notes);

        initWigdets();
        checkForEdit();

        btSpeak = findViewById(R.id.speakButton);
        btSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { SpeechToTxt(); }
        });

        btSearch = findViewById(R.id.SearchBt);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { GoogleIt(); }
        });
    }

    public void initWigdets() {
        text= findViewById(R.id.textView2);
        savedTxt= findViewById(R.id.savedTxt);
    }
// When we create the SavedNote  getting the data form the list view and  also checks if we are in editing mode
    public void checkForEdit() {

        Intent receivedIntent = getIntent();

        surname = receivedIntent.getStringExtra("surname");
        lastname = receivedIntent.getStringExtra("lastname");
        categ = receivedIntent.getStringExtra("eidikotita");
        text = (TextView)findViewById(R.id.textView2);
        text.setText("Your details for: "+categ);

        int passedNoteID= receivedIntent.getIntExtra(Note.Note_edit, -1);

        selectedNote=Note.getNoteID(passedNoteID);

        if(selectedNote != null ){
            text.setText(selectedNote.getCateg());
            savedTxt.setText(selectedNote.getDetails());
        }
    }
//Saves the note when the user is done
    public void saveNote(View view) {

        DbManager dbManager = DbManager.instanceOfDataBase(this);

        categ = String.valueOf(text.getText());
        details = String.valueOf(savedTxt.getText());

//is null means that we are inserting first time with the same details and category aka doesn't exist in our db
        if(selectedNote == null) {
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, categ, details);
            Note.noteArrayList.add(newNote);
            dbManager.addRecordToDb(newNote);
//If exist it means we want to edit an already existing entity
        }else{
            selectedNote.setCateg(categ);
            selectedNote.setDetails(details);
            dbManager.onEdit(selectedNote);
        }
        finish();
    }

//Translate the words into text
    private void SpeechToTxt() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "En-Us");

        try{
            startActivityForResult(intent, RESULT_SPEECH);
//            savedTxt.setText("");
        }catch (Exception e ){
            Toast.makeText(getApplicationContext(),"You are not able to use 'speech to text' technology ",Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    String old = String.valueOf(savedTxt.getText());
                    ArrayList<String> txtList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if (old.equals("")){
                        savedTxt.setText(txtList.get(0));
                    }else {
                        savedTxt.setText( old +"\n\nEntry:\n~ "+ txtList.get(0));
                    }
                }
                break;
        }
    }
//Handles the Configuration Changes
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
//with a button click google's the category that the user want to make a note
    public void GoogleIt() {

        String url = "https://www.google.com/search?q="+categ;
        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }
}