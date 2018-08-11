package com.example.ramya.adkoin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;
import  android.view.ViewGroup.LayoutParams;

/**
 * Created by kavi on 4/8/18.
 */

public class PhoneStateReceiver extends BroadcastReceiver {




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(final Context context, Intent intent) {

        Log.d("flag1 ", "flag1");

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Log.d("flag2", state);
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
//                ) {|| state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)

            Log.d("Ringing", "Phone is ringing");

            final Intent i = new Intent(context, CustomPhoneStateListener.class);
            i.putExtras(intent);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    context.startActivity(i);
                }
            },1000);

        }


        // To remove the view once the dialer app is closed.


    }

}

