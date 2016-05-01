package com.reconshot.dev.prefixerprototype;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPrefixer;
    private SharedPreferences settings;

    public static final String TURN_ON = "Turn on";
    public static final String TURN_OFF = "Turn off";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("settings", Context.MODE_PRIVATE);

        mBtnPrefixer = (Button) findViewById(R.id.btn_prefixer);

        String btnText = settings.getBoolean("active", false) ? TURN_OFF : TURN_ON;

        mBtnPrefixer.setText(btnText);

        mBtnPrefixer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = settings.edit();

                if(settings.getBoolean("active", false)) {
                    mBtnPrefixer.setText(TURN_ON);

                    editor.putBoolean("active", false);
                }else{
                    mBtnPrefixer.setText(TURN_OFF);

                    editor.putBoolean("active", true);
                }

                editor.commit();

            }
        });

    }
}
