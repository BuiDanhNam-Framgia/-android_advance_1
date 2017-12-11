package com.example.buidanhnam.fragment_listiew_recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buidanhnam.fragment_listiew_recycleview.R;
import com.example.buidanhnam.fragment_listiew_recycleview.model.Contact;
import com.example.buidanhnam.fragment_listiew_recycleview.model.Student;

import java.util.ArrayList;

/**
 * Created by Bui Danh Nam on 8/12/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter {
    private static final int TYPE_CONTACT = 1;
    private static final int TYPE_STUDENT = 2 ;
    private ArrayList<Object> listData ;
    private Context context;

    public RecycleAdapter(ArrayList<Object> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        switch (viewType){
            case TYPE_STUDENT :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent ,false);
                return  new viewHolderStudent(view);

            case TYPE_CONTACT :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phonenumber,parent ,false);
                return  new viewHolderContact(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Object obj = listData.get(position);
        switch (holder.getItemViewType()){
            case TYPE_CONTACT :
//                viewHolderContact holderContact =
                break;
            case TYPE_STUDENT :
                break;
        }
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(listData.get(position) instanceof Contact)
            return TYPE_CONTACT;
        if(listData.get(position) instanceof Student)
            return TYPE_STUDENT ;

        return -1 ;
    }

    public class viewHolderStudent extends  RecyclerView.ViewHolder{

       public viewHolderStudent(View itemView) {
           super(itemView);
       }
   }
    public class viewHolderContact extends  RecyclerView.ViewHolder{

       
        public viewHolderContact(View itemView) {
            super(itemView);
        }
    }
}
