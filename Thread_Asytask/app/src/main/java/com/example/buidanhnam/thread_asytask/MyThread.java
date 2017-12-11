package com.example.buidanhnam.thread_asytask;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Bui Danh Nam on 11/12/2017.
 */

public class MyThread implements Runnable {
    private Handler mhandler ;
    private int timer ;
    public MyThread(Handler handler , int timer ){
        this.mhandler = handler;
        this.timer = timer ;
    }
    @Override
    public void run() {
        do {
            Message message = mhandler.obtainMessage();
            message.arg1 = timer ;
            message.what = MainActivity.COUNT_TIMER ;
            mhandler.sendMessage(message);
            timer -- ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (timer>=0) ;
        mhandler.sendEmptyMessage(MainActivity.COUNT_DONE);
    }
}
