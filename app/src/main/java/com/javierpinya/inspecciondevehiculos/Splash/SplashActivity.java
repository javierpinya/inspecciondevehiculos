package com.javierpinya.inspecciondevehiculos.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.activities.LoginActivity;
import com.javierpinya.inspecciondevehiculos.activities.MenuActivity;

import static com.javierpinya.inspecciondevehiculos.Utils.Util.getUserMailPrefs;
import static com.javierpinya.inspecciondevehiculos.Utils.Util.getUserPassPrefs;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentDashboard = new Intent(this, MenuActivity.class);

        if(!TextUtils.isEmpty(getUserMailPrefs(prefs)) && !TextUtils.isEmpty(getUserPassPrefs(prefs))){
            startActivity(intentDashboard);
        }else {
            startActivity(intentLogin);
        }
    }
}
