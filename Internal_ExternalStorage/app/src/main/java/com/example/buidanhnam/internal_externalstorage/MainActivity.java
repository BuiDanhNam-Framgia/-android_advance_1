package com.example.buidanhnam.internal_externalstorage;

import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
 
    public static final
    Realm myOtherRealm =
            Realm.getInstance(
                    new RealmConfiguration.Builder(context)
                            .name("myOtherRealm.realm")
                            .build()
            );
    private static final int    = 515;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    SharedPreferences sharedPreferences =  getSharedPreferences("a" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet();
        Environment.getExternalStoragePublicDirectory(),
                EgetExternalStoragePublicDirectory(),
        try {
            FileOutputStream fileOutputStream = openFileOutput("fileName" , MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        switch (){
            case :
                break;

        }
        for (int i = 0; i < ; i++) {
            
        }
         switch (){
                     case :
             break;

         }
        String a ;
        Button button = new Button();
        button.setVisibility(View.GONE);
        () findViewById(R.id.);
        con
        editor.commit();
        editor.apply();
        editor.clear();
        editor.clear();
        editor.remove("key");
        editor.getAll();
        sharedPreferences.getAll();

    }
}
