package com.example.a1st_project;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    androidx.activity.result.ActivityResultLauncher<Intent> ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            TextView name = (TextView) findViewById(R.id.Messege);
                            name.setText("Hello " + data.getStringExtra("returnUser") + " is nice to have you back! " + data.getStringExtra("returnPass"));
                            View gone = findViewById(R.id.button);
                            gone.setVisibility(View.GONE);
                            View sw1 = findViewById(R.id.switch1);
                            sw1.setVisibility(View.VISIBLE);
                            View sw2 = findViewById(R.id.switch2);
                            sw2.setVisibility(View.VISIBLE);
                            View sw3 = findViewById(R.id.switch3);
                            sw3.setVisibility(View.VISIBLE);
                            View sw4 = findViewById(R.id.switch4);
                            sw4.setVisibility(View.VISIBLE);
                        }/*else {
                            TextView empty =(TextView) findViewById(R.id.Messege);
                            empty.setText("Please Try again: :( ");
                            GoToBurner();
                        }*/
                    }
                }
            });

// startActivityForResult()  We are waiting for a response
    public void GoToBurner(View view) {
        Intent setResultsIntent = new Intent(this, BurnerActivity.class);
        ActivityResultLauncher.launch(setResultsIntent);
    }

    public void GoToCitiesFormat(View view) {

//Macedonia

        Switch sw1 = (Switch) findViewById(R.id.switch1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    makedonia();
                }
            }
        });

//Central Greece

        Switch sw2 = (Switch)findViewById(R.id.switch2);
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ellada();
                }
            }
        });

//Thessaly

        Switch sw3 = (Switch)findViewById(R.id.switch3);
        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    thessaly();
                }
            }
        });

//Crete

        Switch sw4 = (Switch)findViewById(R.id.switch4);
        sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    crete();
                }
            }
        });
    }

    public void makedonia(){
        String returnChoice="makedonia";
        Intent intent = new Intent(this, CitiesFormat.class);
        intent.putExtra("Choice",returnChoice);
        startActivity(intent);

    }

    public void ellada(){
        String returnChoice="ellada";
        Intent intent = new Intent(this, CitiesFormat.class);
        intent.putExtra("Choice",returnChoice);
        startActivity(intent);

    }

    public void thessaly(){
        String returnChoice="thessaly";
        Intent intent = new Intent(this, CitiesFormat.class);
        intent.putExtra("Choice",returnChoice);
        startActivity(intent);

    }

    public void crete(){
        String returnChoice="crete";
        Intent intent = new Intent(this, CitiesFormat.class);
        intent.putExtra("Choice",returnChoice);
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


