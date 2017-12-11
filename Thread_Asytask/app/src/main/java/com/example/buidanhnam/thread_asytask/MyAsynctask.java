package com.example.buidanhnam.thread_asytask;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Bui Danh Nam on 11/12/2017.
 */

public class MyAsynctask extends AsyncTask<Integer , Integer , Void> {
    private Context context ;
    private UpdateUI updateUI;

    public MyAsynctask (Context context ){
          this.context = context ;

    }

    public void setUpdateUI(UpdateUI updateUI) {
        if(context instanceof UpdateUI){
            this.updateUI = (UpdateUI) context;
        }
    }

    interface UpdateUI {
       void updateTimer(int timeCurent );
        void  updateFinal ();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        boolean check = true;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int value = params[0];

        while (value >= 0){
            value -- ;

//            updateUI.updateTimer(value); // se loi neu update UI trong day
            publishProgress(value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null ;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];

            updateUI.updateTimer(value);
//        }


    }

    @Override
    protected void onPostExecute(Void s) {
        updateUI.updateFinal();
    }

}
