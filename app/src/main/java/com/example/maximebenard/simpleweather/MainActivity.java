package com.example.maximebenard.simpleweather;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String cityname;

    Button b1;
    Button b2;
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.CityButton);
        //b1.setOnClickListener(myhandler1);
        b2.setOnClickListener(myhandler2);
        Intent intent = getIntent();
        String cityname = intent.getStringExtra("key");
        System.out.println("main activity " + cityname);





        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        RemoteData.placeIdTask asyncTask =new RemoteData.placeIdTask(new RemoteData.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);

                updatedField.setText("Mis à jour le "+ weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidité: "+weather_humidity);
                pressure_field.setText("Pression: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("25.180000", "89.530000"); //  asyncTask.execute("Latitude", "Longitude")


    }


    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {


            Intent myIntent = new Intent(MainActivity.this, City.class);
            //myIntent.putExtra("key", value); //Optional parameters
            System.exit(0);
            MainActivity.this.startActivity(myIntent);
        }
    };






}
