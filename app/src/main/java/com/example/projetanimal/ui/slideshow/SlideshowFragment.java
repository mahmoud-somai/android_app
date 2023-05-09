package com.example.projetanimal.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetanimal.R;
import com.example.projetanimal.Register;
import com.example.projetanimal.User;
import com.example.projetanimal.databinding.FragmentSlideshowBinding;
import com.example.projetanimal.login;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SlideshowFragment extends Fragment {
    private EditText firstname;
    private EditText lastname;
    private EditText phone;
    private EditText email;
    private EditText password;
    private Button submitbtn;
    DatabaseReference AnimalDbRef;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        firstname= view.findViewById(R.id.firstnameuser);
        lastname= view.findViewById(R.id.lastnameuser);
        email= view.findViewById(R.id.emailuser);
        phone= view.findViewById(R.id.emailuser);
        password= view.findViewById(R.id.passworduser);
        submitbtn= view.findViewById(R.id.btnreg);
        AnimalDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), login.class);
                startActivity(intent);
                insertAnimalData();
            }
        });


        return root;
    }
    private void insertAnimalData(){
        String regifirstname=firstname.getText().toString();
        String regilastname=lastname.getText().toString();
        String regiemail=email.getText().toString();
        String regipassword=password.getText().toString();
        String regiphoneString = phone.getText().toString();
        int regiphone = Integer.parseInt(regiphoneString);


        User users= new User(regifirstname,regilastname,regiemail,regipassword,regiphone);
        AnimalDbRef.push().setValue(users);
        Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}