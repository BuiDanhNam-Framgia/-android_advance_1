package com.example.buidanhnam.networdconnect;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DowloadImageHttpUrlCon.CallBack {
    private Button btnDowload;
    private EditText edtLink;
    private ImageView imgShowResult;
    private ProgressBar progressBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btnDowload = (Button) findViewById(R.id.btn_dowload);
        edtLink = (EditText) findViewById(R.id.edt_link);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        imgShowResult = (ImageView) findViewById(R.id.img_show_result);
        edtLink.setText("https://raw.githubusercontent.com/wiki/square/okhttp/interceptors@2x.png");
        btnDowload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_dowload:
                DowloadImageHttpUrlCon dowloadImage = new DowloadImageHttpUrlCon(this);
                String link = "https://raw.githubusercontent.com/wiki/square/okhttp/interceptors@2x.png";
                dowloadImage.execute(link);
                break;

        }
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showImageInImageView(Bitmap bitmap) {
        imgShowResult.setImageBitmap(bitmap);
    }

    @Override
    public String getPathExternalFilesDir(String type) {
        return getExternalFilesDir(type).getAbsolutePath();
    }
}
