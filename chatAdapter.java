package com.example.sunny;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.*;

//Creating a chatAdapter to adapt the data which cannot be read by the Viewholder directly.
public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatViewholder>{
    String[]data; String[]message;
    public chatAdapter(String[]data, String[] message) //Constructor to initialise the global variables
    {
        this.data=data;
        this.message=message;
    }
    @NonNull
    @Override
    public chatViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //Implementing methods
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.list_item, viewGroup, false);
        return new chatViewholder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull chatViewholder chatViewholder, int i) { //Binding the data with the view
    String name=data[i];
    chatViewholder.text1.setText(name);
    String mess=message[i];
    chatViewholder.text2.setText(mess);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class chatViewholder extends RecyclerView.ViewHolder{ //Prevents repetition of the initialisation process saving memory
        ImageView img;
        TextView text1;
        TextView text2;
        public chatViewholder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.image1);
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
        }
    }
}
