package com.example.a1st_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CitiesFormat extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_format);

        Intent responseintent = getIntent();
        String data = responseintent.getStringExtra("Choice");

        TextView welcome= (TextView) findViewById(R.id.WellComeTxt);
        welcome.setText("WellCome to "+data +"!!!");


        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);


        if(data.contains("makedonia")){

            button1.setText("Serres");
            button2.setText("Thessaloniki");
            button3.setText("Katerini");
            button4.setText("Kozani");

            View b1= findViewById(R.id.button1);
            View b2= findViewById(R.id.button2);
            View b3= findViewById(R.id.button3);
            View b4= findViewById(R.id.button4);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

        } else if (data.contains("ellada")) {

            button1.setText("Lamia");
            button2.setText("Athina");
            button3.setText("Pireas");
            //button4.setText("thiva");

            View b1= findViewById(R.id.button1);
            View b2= findViewById(R.id.button2);
            View b3= findViewById(R.id.button3);
            //View b4= findViewById(R.id.button4);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            //b4.setVisibility(View.VISIBLE);

        } else if (data.contains("thessaly")) {

            button1.setText("Volos");
            button2.setText("larisa");
            button3.setText("Trikala");
            button4.setText("Karditsa");

            View b1= findViewById(R.id.button1);
            View b2= findViewById(R.id.button2);
            View b3= findViewById(R.id.button3);
            View b4= findViewById(R.id.button4);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

        }else if(data.contains("crete")){

            button1.setText("Hrakleio");
            button2.setText("Xania");
            //button3.setText("Trikala");
            //button4.setText("Karditsa");

            View b1= findViewById(R.id.button1);
            View b2= findViewById(R.id.button2);
            View b3= findViewById(R.id.button3);
            View b4= findViewById(R.id.button4);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.INVISIBLE);
            b4.setVisibility(View.INVISIBLE);

        }
    }

    public void GoToLocationFormat(View view) {


        Button bt1 = (Button)findViewById(R.id.button1);
        Button bt2 = (Button)findViewById(R.id.button2);
        Button bt3 = (Button)findViewById(R.id.button3);
        Button bt4 = (Button)findViewById(R.id.button4);

// With less if we can do
// || data.contains("Serres") ||data.contains("Thessaloniki") ||data.contains("Katerini")|| data.contains("kozani") ...
// But we have to take as input the     button.getText.toString();

        if(view.getId() == R.id.button1) {
            Intent in = new Intent(this, LocationFormat.class);
            String returnplace = bt1.getText().toString();
            in.putExtra("place",returnplace);
            startActivity(in);
        } else if (view.getId() == R.id.button2) {
            Intent in = new Intent(this, LocationFormat.class);
            String returnplace = bt2.getText().toString();
            in.putExtra("place",returnplace);
            startActivity(in);

        } else if (view.getId() == R.id.button3) {
            Intent in = new Intent(this, LocationFormat.class);
            String returnplace = bt3.getText().toString();
            in.putExtra("place",returnplace);
            startActivity(in);
        }else {
            Intent in = new Intent(this, LocationFormat.class);
            String returnplace = bt4.getText().toString();
            in.putExtra("place",returnplace);
            startActivity(in);
        }
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

// ~~~~~~~~~~~~~~~~~~~~~~~~

// When it goes back the data from the MainActivity is missing.
// So to fix this we have to Use the  method onSaveInstanceState() in onCreate in the activity main?

//~~~~~~~~~~~~~~~~~~~~~~~~~

    //Goes back with an image button

    public void GoBack(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}