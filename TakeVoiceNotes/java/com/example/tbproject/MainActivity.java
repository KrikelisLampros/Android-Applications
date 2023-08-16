package com.example.tbproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void GotoListView(View view) {
        Intent intent = new Intent(this, listView.class);

        EditText username = (EditText) findViewById(R.id.surname);
        intent.putExtra("surname", username.getText().toString() );

        EditText lastname = (EditText) findViewById(R.id.lastname);
        intent.putExtra("lastname",lastname.getText().toString());

        EditText eidikotita = (EditText) findViewById(R.id.eidikotita);
        intent.putExtra("eidikotita",eidikotita.getText().toString());

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