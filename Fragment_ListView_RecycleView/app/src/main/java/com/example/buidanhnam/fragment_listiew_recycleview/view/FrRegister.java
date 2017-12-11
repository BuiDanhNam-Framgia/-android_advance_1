package com.example.buidanhnam.fragment_listiew_recycleview.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buidanhnam.fragment_listiew_recycleview.R;

import java.io.IOException;

/**
 * Created by Bui Danh Nam on 8/12/2017.
 */

public class FrRegister extends Fragment implements View.OnClickListener {
    private Button btnRegister;
    private EditText edtUseName, edtPass, edtPhoneNum, edtAddr, edtFullname;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_register, container, false);
    }

    private void initView(View view) {
        btnRegister = (Button) view.findViewById(R.id.btn_cf_register);
        edtAddr = (EditText) view.findViewById(R.id.edt_register_address);
        edtFullname = (EditText) view.findViewById(R.id.edt_register_fullname);
        edtUseName = (EditText) view.findViewById(R.id.edt_register_Usernam);
        edtPass = (EditText) view.findViewById(R.id.edt_register_Pass);
        edtPhoneNum = (EditText) view.findViewById(R.id.edt_register_phonenumber);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cf_register:
                String userName = edtUseName.getText().toString();
                String password = edtPass.getText().toString();
                if (userName.isEmpty() && password.isEmpty()) {
                    Toast.makeText(getActivity(), "Error !! ", Toast.LENGTH_SHORT).show();
                } else {
                    showConfiDialog(userName , password);
                }
                break;
        }
    }

    private void showConfiDialog(final String userName , final String password ) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Register complete !! ");
        builder.setCancelable(false);
        builder.setNegativeButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity mainActivity = (MainActivity) getActivity();

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FrLogin frLogin = (FrLogin) fragmentManager.findFragmentByTag("frlogin");
                    Bundle bundle = new Bundle();
                    bundle.putString(FrLogin.USERNAME, userName);
                    bundle.putString(FrLogin.PASSWORD, password);
                    frLogin.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fr_placeholder, frLogin).commit();
            }

            });
        builder.show();
        }
    }
