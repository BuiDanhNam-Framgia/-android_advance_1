package com.example.buidanhnam.thread_asytask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , Runnable , MyAsynctask.UpdateUI{
    public static final int COUNT_TIMER = 1;
    public static final int COUNT_DONE = 0;
    private Button btnCount;
    private TextView tvCount;
    int timer = 10;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case COUNT_TIMER :
                    tvCount.setText(msg.arg1+"");
                    btnCount.setEnabled(false);
                    break;
                case COUNT_DONE :
                    btnCount.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Finish !!!", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btnCount = (Button) findViewById(R.id.btn_Count);
        tvCount = (TextView) findViewById(R.id.tv_count);
        btnCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Count:
                doCount();
                break;
        }
    }

    private void doCount() {
        timer = 10;
//         c1 tao thread trong main thread
//        Thread thread = new Thread(this);
//        thread.start();

//         c2 custom thread
//        MyThread myThread = new MyThread(handler , timer);
//        Thread thread1 = new Thread(myThread);
//        thread1.start();

        // c3 dung asyntask
        MyAsynctask myAsynctask = new MyAsynctask(this);
        myAsynctask.setUpdateUI(this);
        myAsynctask.execute(timer);

    }
    @Override
    public void run() {
        while (timer >= 0){
            Message message = new Message();
            message.what = COUNT_TIMER;
            message.arg1 = timer;
            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer --;
        }
        handler.sendEmptyMessage(COUNT_DONE);

    }


    @Override
    public void updateTimer(int timeCurent) {
        tvCount.setText(timeCurent + "");
        btnCount.setEnabled(false);
    }

    @Override
    public void updateFinal() {
        btnCount.setEnabled(true);
        Toast.makeText(this, "Finish !! ", Toast.LENGTH_SHORT).show();
    }
}
