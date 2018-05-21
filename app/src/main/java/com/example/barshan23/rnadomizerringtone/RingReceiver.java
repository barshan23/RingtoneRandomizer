package com.example.barshan23.rnadomizerringtone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by barshan23 on 18/5/18.
 */

public class RingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            String cs = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            Log.d("RingTone", "change");
            if(cs.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Log.d("RingTone", "changed");
                RingtoneHelper.changeRingtone(context);
            }
        }
    }
}
