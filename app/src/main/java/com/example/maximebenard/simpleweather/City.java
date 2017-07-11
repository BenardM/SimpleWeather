package com.example.maximebenard.simpleweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class City extends AppCompatActivity {


    private static String nomVille;
    //public String nomVille;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        getSupportActionBar().hide();
        Button boutonville = (Button) findViewById(R.id.validCity);
        boutonville.setOnClickListener(myhandler3);

    }

    View.OnClickListener myhandler3 = new View.OnClickListener() {
        public void onClick(View v) {
            EditText villetext = (EditText)findViewById(R.id.cityText);
            Intent myIntent = new Intent(City.this, MainActivity.class);
            nomVille = villetext.getText().toString();
            myIntent.putExtra("key", villetext.getText().toString()); //Optional parameters
            City.this.startActivity(myIntent);
        }



    };

    public static String getVille(){
        return nomVille;
    }




}

