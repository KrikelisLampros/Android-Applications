package com.example.a1st_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class BurnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burner);
    }

    public void BackToMain(View view) {

        //What if the user did not insert data ?
        Intent intent = new Intent();

        EditText username = (EditText) findViewById(R.id.Username);
        intent.putExtra("returnUser", username.getText().toString() );

        EditText pass = (EditText) findViewById(R.id.Password);
        intent.putExtra("returnPass",pass.getText().toString());


        setResult(RESULT_OK, intent);
        finish();

    }

//Screen msg

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