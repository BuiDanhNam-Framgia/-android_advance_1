package com.example.buidanhnam.fragment_listiew_recycleview.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.buidanhnam.fragment_listiew_recycleview.R;

public class MainActivity extends AppCompatActivity {
    private  FrRegister frRegister ;
    private  FrLogin frLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frLogin = new FrLogin();
        replaceFragment(frLogin , "frlogin");
    }



    public void addFragment(Fragment fr , boolean isAddToBackTack , String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fr_placeholder , fr , tag);
        if(isAddToBackTack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public void replaceFragment(Fragment fr , String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fr_placeholder , fr , tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
