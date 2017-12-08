package com.example.buidanhnam.fragment_listiew_recycleview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buidanhnam.fragment_listiew_recycleview.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Bui Danh Nam on 8/12/2017.
 */

public class FrLogin extends Fragment implements View.OnClickListener {
    public static final  String USERNAME = "username";
    public static final  String PASSWORD = "password";
    private Button btnLogin , btnRegidter ;
    private EditText edtUserName , edtPass ;
    private TextView tvForgotPass ;
    public static final String TAG = "Frlogin" ;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        innitView(view);
    }
  
    private void innitView(View view) {
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegidter = (Button) view.findViewById(R.id.btnregister);
        tvForgotPass = (TextView) view.findViewById(R.id.tv_forgot_pass);
        edtPass = (EditText) view.findViewById(R.id.edtPass);
        edtUserName = (EditText) view.findViewById(R.id.edtUsernam);
        btnLogin.setOnClickListener(this);
        btnRegidter.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_login , container ,false);
        return  view ;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if(bundle != null){
            String username = bundle.getString(USERNAME);
            String password = bundle.getString(PASSWORD);
            setDataLogin(username, password);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin :
                Toast.makeText(getContext(), "Login complete !! ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnregister :
                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.setFrRegister();
                mainActivity.addFragment(new FrRegister() ,false ,"fr_register");
                break;
        }
    }
    public void setDataLogin(String username , String pass  ){
        edtPass.setText(pass);
        edtUserName.setText(username);
    }
}
