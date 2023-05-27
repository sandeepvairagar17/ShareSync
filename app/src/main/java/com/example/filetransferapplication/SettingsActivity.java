package com.example.filetransferapplication;


import android.content.SharedPreferences;
import android.support.*;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    Switch sCompress;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sCompress = (Switch) findViewById(R.id.sCompress);

        sharedPreferences = getSharedPreferences("compression", MODE_PRIVATE);

        sCompress.setChecked(sharedPreferences.getBoolean("compress_or_not", true));
        sCompress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("compress_or_not", b);
                editor.apply();
            }
        });
    }
}