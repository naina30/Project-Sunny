package com.example.sunny;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CustomViewholder> {

    List<ResponseMessage> responseMessageList;
    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewholder extends RecyclerView.ViewHolder{

        TextView textView;
        public CustomViewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textmessage);
        }
    }


    public MessageAdapter(List<ResponseMessage> responseMessageList)
    {
        this.responseMessageList=responseMessageList;
    }


}
