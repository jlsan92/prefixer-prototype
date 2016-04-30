package com.reconshot.dev.prefixerprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch mPrefixSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefixSwitch = (Switch) findViewById(R.id.prefix_toggle);

        mPrefixSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
