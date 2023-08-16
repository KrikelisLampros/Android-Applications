package com.example.a1st_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LocationFormat extends AppCompatActivity {


// What if I had more than one intent coming in from different activities ?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_format);

        Intent receivedIntent = getIntent();
        String placedata = receivedIntent.getStringExtra("place");
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText("Find out about our city "+placedata);

    }

    public void GoToMap(View view) {


        Intent receivedIntent = getIntent();
        String placedata = receivedIntent.getStringExtra("place");
        Button locBut= (Button) findViewById(R.id.WebBut);
        locBut.setText("Do not forget to visit "+ placedata +"'s Uni site ");


        if(placedata.contains("Serres")){
           // Button testb =(Button)findViewById(R.id.button5);
           // testb.setText(placedata);
            serres();
        } else if (placedata.contains("Thessaloniki")) {

            Uri location = Uri.parse("40.64464807111206, 22.939798828805863");
            Intent mapIntent2 = new Intent(Intent.ACTION_VIEW, location);
            if (mapIntent2.
                    resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent2);
            }

        } else if (placedata.contains("katerini")) {
            Uri location = Uri.parse("40.27246109258172, 22.51206857832668");
            Intent mapIntent3 = new Intent(Intent.ACTION_VIEW, location);
            if (mapIntent3.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent3);
            }

        }else if (placedata.contains("kozani")) {
            Uri location = Uri.parse("40.30104705627458, 21.798087050625625");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
    }

    public void GoToWeb(View view) {

        Intent receivedIntent = getIntent();
        String placedata = receivedIntent.getStringExtra("place");
        Button locBut= (Button) findViewById(R.id.LocBut);
        locBut.setText("Find "+placedata+" in mpa  as well");

        if(placedata.equals("Serres")){

            String url = "https://cm.ihu.gr/";
            Uri webpage = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(webpage);
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }
        } else if (placedata.contains("Thessaloniki")) {
            String url = "https://www.auth.gr/en/";
            Uri webpage = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(webpage);
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }
        } else if (placedata.contains("Katerini")) {

            String url = "https://www.ihu.gr/en/enhome/";
            Uri webpage = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(webpage);
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }

        }else if (placedata.contains("Kozani")) {

            String url = "https://www.uowm.gr/en/";
            Uri webpage = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(webpage);
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }
        }
    }

    public void serres(){

        Uri location = Uri.parse("50.0907, 20.939798828805863");
        Intent mapIntent1 = new Intent(Intent.ACTION_VIEW,location);
        if(mapIntent1.resolveActivity(getPackageManager()) != null ){
            startActivity(mapIntent1);
        }
    }

    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

/*
    public void test(View view) {
        Uri location = Uri.parse("geo:38.89936266935903, 22.434535822867137?z=8");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
*/

}
