package com.shopee.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.viewHoder> {

    ArrayList<Chat> chats;
    Context context;
    int layout;

    public ChatAdapter(ArrayList<Chat> chats, Context context, int layout) {
        this.chats = chats;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(layout, parent, false);
        return new viewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        holder.tvName.setText(chats.get(position).getName());
        holder.tvDetail.setText(chats.get(position).getDetail());
        holder.tvTime.setText(chats.get(position).getTime());
        holder.img.setImageResource(chats.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, chats.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
    public void addItem(int position, Chat data) {
        chats.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        chats.remove(position);
        notifyItemRemoved(position);
    }


    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetail, tvTime;
        ImageView img;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            tvTime = itemView.findViewById(R.id.tv_time);
            img = itemView.findViewById(R.id.img_notifi);

        }
    }
}
