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
    ArrayList<Animal> arr;



    public Adapteritem(Context context, ArrayList<Animal> arr) {
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
        Animal animal=arr.get(position);
        holder.name.setText(animal.getName());
        holder.type.setText(animal.getType());
        holder.age.setText(animal.getAge());
        holder.address.setText(animal.getAddress());
        holder.phone.setText(Integer.toString(animal.getPhone()));

    }

    @Override
    public int getItemCount() {
        return arr.size()  ;
    }

    class  ItemViewHolder extends RecyclerView.ViewHolder{
        TextView name,type,age,address,phone;

        public  ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvname);
            type=itemView.findViewById(R.id.tvtype);
            age=itemView.findViewById(R.id.tvage);
            address=itemView.findViewById(R.id.tvaddress);
            phone=itemView.findViewById(R.id.tvphone);
        }
    }
}
