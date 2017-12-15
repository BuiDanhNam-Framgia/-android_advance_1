package com.example.buidanhnam.broadcastrieciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Bui Danh Nam on 13/12/2017.
 */

public class MyBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyBroadcastReciever", "onReceive: "+ intent.getAction()) ;
        setResult(1 , null , intent.getExtras());
    }

}
