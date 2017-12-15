package com.example.buidanhnam.broadcastrieciever;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReciever myBroadcastReciever ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // register dynamic
         myBroadcastReciever  = new MyBroadcastReciever();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcastReciever , new IntentFilter("start_reciever") );
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver();
        unregisterReceiver(myBroadcastReciever);

    }
}
