package com.example.projetanimal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetanimal.ui.gallery.GalleryFragment;

import java.util.ArrayList;

public class Adapteritem extends RecyclerView.Adapter<Adapteritem.ItemViewHolder>{

    Context context ;
    ArrayList<User> arr;



    public Adapteritem(Context context, ArrayList<User> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return new ItemViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        User user=arr.get(position);
        holder.firstname.setText(user.getFirstname());
        holder.lastname.setText(user.getLastname());
        holder.age.setText(user.getAge());

    }

    @Override
    public int getItemCount() {
        return arr.size()  ;
    }

    class  ItemViewHolder extends RecyclerView.ViewHolder{
        TextView firstname,lastname,age;

        public  ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname=itemView.findViewById(R.id.tvfirstname);
            lastname=itemView.findViewById(R.id.tvlastname);
            age=itemView.findViewById(R.id.tvage);
        }
    }
}
