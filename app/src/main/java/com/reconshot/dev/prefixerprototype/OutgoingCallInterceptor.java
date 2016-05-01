package com.reconshot.dev.prefixerprototype;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Juan on 30/4/2016.
 */
public class OutgoingCallInterceptor extends BroadcastReceiver {

    public static final String Prefix = "900123123";

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences settings = context.getSharedPreferences("settings", Context.MODE_PRIVATE);

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL) && settings.getBoolean("active", false)) {

            final String originalNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            this.setResultData(Prefix + originalNumber);

            String msg = "Intercepted outgoing call. Added prefix ->" + Prefix;

            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

        }
    }

}
