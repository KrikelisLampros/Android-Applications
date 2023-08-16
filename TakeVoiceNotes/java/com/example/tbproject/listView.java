package com.example.tbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listView extends AppCompatActivity {

    private ListView noteListView;
    String categ , surname, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent receivedIntent = getIntent();
        surname = receivedIntent.getStringExtra("surname");
        lastname = receivedIntent.getStringExtra("lastname");
        categ = receivedIntent.getStringExtra("eidikotita");
        TextView text = (TextView)findViewById(R.id.categButton);
        text.setText("About: "+categ);
        
        initWidgets();  
        loadDataBase();
        setNotes();
        setOnClick();
    }



    private void loadDataBase() {
        DbManager dbManager = DbManager.instanceOfDataBase(this);
        dbManager.allocNoteListArray();
    }



    private void initWidgets() {

        noteListView = findViewById(R.id.listview);
    }

    private void setNotes() {
        listViewDisplay listViewDisplay= new listViewDisplay(getApplicationContext(),Note.noteArrayList);
        noteListView.setAdapter(listViewDisplay);

    }
    private void setOnClick() {
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Note selectedNote =(Note) noteListView.getItemAtPosition(position);
                Intent editNote= new Intent(getApplicationContext(),SavedNotes.class);
                editNote.putExtra(Note.Note_edit,selectedNote.getId());
                startActivity(editNote);
            }
        });
    }

    public void addlist(View view) {

        Intent intent = new Intent(this, SavedNotes.class);
        intent.putExtra("surname",surname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("eidikotita",categ);
        startActivity(intent);


    }








    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

}