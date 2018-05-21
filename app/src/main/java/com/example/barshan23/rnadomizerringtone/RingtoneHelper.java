package com.example.barshan23.rnadomizerringtone;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by barshan23 on 13/5/18.
 */

public class RingtoneHelper {
    public static List<Ringtone> fetchAvailableRingtones(Context context){

        List<Ringtone> ringtones = new ArrayList<>();
        RingtoneManager mgr = new RingtoneManager(context);
        mgr.setType(RingtoneManager.TYPE_RINGTONE);

        int n = mgr.getCursor().getCount();
        for(int i=0;i<n;i++){
            if(mgr.getRingtoneUri(i).toString().contains("external")) {
                ringtones.add(mgr.getRingtone(i));
            }
//            Log.d("Files", "Path: " + mgr.getRingtoneUri(i));
        }

        return  ringtones;
    }

    public static void changeRingtone(Context context){
        Log.d("RingTone", "change");
        SharedPreferences sp = context.getSharedPreferences("randomizer", Context.MODE_PRIVATE);
        if(!sp.getBoolean("active", false)) {
            Log.d("RingTone", "not active");
            return;
        }
        RingtoneManager mgr = new RingtoneManager(context);
        Random r = new Random(System.currentTimeMillis());

        int n = mgr.getCursor().getCount();
        List<Uri> ringtones = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mgr.getRingtoneUri(i).toString().contains("external")) {
                ringtones.add(mgr.getRingtoneUri(i));
            }
//            Log.d("Files", "Path: " + mgr.getRingtoneUri(i));
        }
        int ring = r.nextInt(ringtones.size());
        Log.d("URI: " , ringtones.get(ring).toString());

        RingtoneManager.setActualDefaultRingtoneUri(context, RingtoneManager.TYPE_RINGTONE, ringtones.get(ring));
    }
}
