package com.example.projetanimal.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetanimal.Adapteritem;
import com.example.projetanimal.Animal;
import com.example.projetanimal.Post;
import com.example.projetanimal.R;
import com.example.projetanimal.User;
import com.example.projetanimal.databinding.FragmentGalleryBinding;
import com.example.projetanimal.databinding.FragmentSlideshowBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private ArrayList<Animal> arr;
    private Adapteritem adapteritem;
    private RecyclerView recyclerView;
    DatabaseReference database;




    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    private @NonNull FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gallery,container,false);

        recyclerView=view.findViewById(R.id.recyclerview);
        database = FirebaseDatabase.getInstance().getReference("Animals");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arr=new ArrayList<>();
        adapteritem=new Adapteritem(getContext(),arr);

        recyclerView.setAdapter(adapteritem);

        database.addValueEventListener(new ValueEventListener() {
            @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Animal animal=dataSnapshot.getValue(Animal.class);
                    arr.add(animal);
                }
                adapteritem.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }



        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}