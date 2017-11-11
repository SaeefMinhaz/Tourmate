package com.example.kumu.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kumu.firebaseapp.activity.FirstLaunch;
import com.example.kumu.firebaseapp.activity.WeatherActivity;
import com.example.kumu.firebaseapp.preferences.Preferences;
import com.example.kumu.firebaseapp.preferences.Prefs;

public class GlobalActivity extends AppCompatActivity {

    public static Preferences cp;
    public static Prefs prefs;
    public static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        Log.i("Loaded" , "Global");
    }

    @Override
    protected void onResume() {
        cp = new Preferences(this);
        prefs = new Prefs(this);
        super.onResume();

        if (!cp.getPrefs().getBoolean("first" , true)) {
            prefs.setLaunched();
            prefs.setCity(cp.getCity());
            Log.i("Yeah" , "True");
        }
        else
            Log.i("No" , "False");

        super.onResume();

        if (prefs.getLaunched()) {
            Intent intent = new Intent(GlobalActivity.this, WeatherActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            Log.i("Loaded" , "Weather");
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(GlobalActivity.this, FirstLaunch.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            Log.i("Loaded" , "First");
            startActivity(intent);
        }
    }
}
