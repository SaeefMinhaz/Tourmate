package com.example.kumu.firebaseapp.preferences;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Deprecated starting version 3 of Simple Weather
 *
 * This Preferences class has no moved to a more robust Prefs class instead.
 * This class is being maintained for a stable user experience
 *
 * @deprecated use {@link com.example.kumu.firebaseapp.preferences.Prefs} class instead.
 */
@Deprecated
public class Preferences {
    private static SharedPreferences prefs;

    public Preferences(Activity activity) {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getCity() {
        return prefs.getString("city", "Sydney");
    }

    public boolean getLaunched() {
        return prefs.getBoolean("first" , true);
    }

    public SharedPreferences getPrefs() {
        return prefs;
    }

    public void setCity(String city) {
        prefs.edit().putString("city", city).apply();
    }

    public void setLaunched() {
        prefs.edit().putBoolean("first" , false).apply();
    }

    public void setLastCity(String city) {
        prefs.edit().putString("lcity" , city).apply();
    }

    public String getLastCity() {
        return prefs.getString("lcity" , "Sydney");
    }
}