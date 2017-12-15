package com.example.buidanhnam.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Bui Danh Nam on 14/12/2017.
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopSelf();
        stopSelf();
        return START_NOT_STICKY ;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        stopSelf(1);
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true ;
    }
}
