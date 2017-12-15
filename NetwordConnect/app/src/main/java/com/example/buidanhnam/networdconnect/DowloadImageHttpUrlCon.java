package com.example.buidanhnam.networdconnect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bui Danh Nam on 15/12/2017.
 */

class DowloadImageHttpUrlCon extends AsyncTask<String, Void, String>
        // link_image , void , link_save_file_in_local
{

    private InputStream inputStream;
    private HttpURLConnection httpURLConnection;
    BufferedOutputStream bufferedReader;
    private CallBack callBack;
    private File fileSaveImage;

    interface CallBack {
        void showProgressBar();

        void hideProgressBar();

        void showImageInImageView(Bitmap bitmap);

        String getPathExternalFilesDir(String type);
    }


    public DowloadImageHttpUrlCon(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        callBack.showProgressBar();

        String nameAbsolutePathFile = callBack.getPathExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //tạo một file mới tu duong dan thu muc External
        fileSaveImage = new File(nameAbsolutePathFile, "fileSaveImage");
    }

    @Override
    protected String doInBackground(String... params) {
        String linkDowload = params[0];

        try {
//            inputStream =  useHttpOk(linkDowload);
            inputStream =  userUrlHttpConnect(linkDowload);
            bufferedReader = new BufferedOutputStream(new FileOutputStream(fileSaveImage));
            byte[] bytes = new byte[1024];
            int data;
            while ((data = inputStream.read(bytes)) != -1) {
                Log.i("doInBackground", " read : " + data);
                bufferedReader.write(bytes, 0, data);
            }
            Log.i("", "doInBackground: size " + fileSaveImage.length() / 1024);
            Log.i("", "doInBackground: " + inputStream.available());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {

                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return fileSaveImage.getAbsolutePath();
    }
    @Override
    protected void onPostExecute(String AbsolutePathFile) {
        super.onPostExecute(AbsolutePathFile);

        callBack.hideProgressBar();
        File file = new File(AbsolutePathFile);
        try

        {
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInput);
            Bitmap bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            callBack.showImageInImageView(bitmap);

        } catch (
                FileNotFoundException e)

        {
            e.printStackTrace();
        }
    }

    private InputStream userUrlHttpConnect(String linkDowload) {
        URL url = null;
        try {
            url = new URL(linkDowload);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            // set Request
            httpURLConnection.setRequestMethod("GET");
//                httpURLConnection.setFixedLengthStreamingMode();
//                httpURLConnection.setDoOutput();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
             return httpURLConnection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return  null ;
    }

    private InputStream useHttpOk(String linkDowload) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(linkDowload).build();
        // c1
        try {
            Response response = okHttpClient.newCall(request).execute();
            return  response.body().byteStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        // c2 : callBack
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                // handl when occur error
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                // handl response
//
//            }
//        });

        return null ;
    }


}
