package com.example.buidanhnam.service;

import android.os.Binder;
import android.os.Message;
import android.os.Messenger;

/**
 * Created by Bui Danh Nam on 14/12/2017.
 */

public class MyBinder extends Binder {
    Messenger message = new Messenger();

    public Message getMessage() {
        message.getBinder();
        return message
    }
}
