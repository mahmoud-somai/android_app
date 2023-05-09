package com.example.projetanimal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Posts  extends AppCompatActivity {
    private EditText name;
    private EditText age;
    private EditText type;
    private EditText address;
    private EditText phone;
    private Button addbtn;
    DatabaseReference AnimalDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        name=findViewById(R.id.animalname);
        age=findViewById(R.id.animalage);
        type=findViewById(R.id.animaltype);
        address=findViewById(R.id.animaladdress);
        phone=findViewById(R.id.animalphone);
        addbtn=findViewById(R.id.addanimalbtn);
        AnimalDbRef = FirebaseDatabase.getInstance().getReference().child("Animals");

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Posts.this,Profile.class);
                startActivity(intent);
                insertAnimal();
            }
        });
    }
    private void insertAnimal(){
        String animalname=name.getText().toString();
        String animaltype=type.getText().toString();
        String animalage=age.getText().toString();

        String animaladdress=address.getText().toString();
        String animalphoneString = phone.getText().toString();
        int animalphone = Integer.parseInt(animalphoneString);


        Post animals=new Post(animalname,animaltype,animalage,animaladdress,animalphone);
        AnimalDbRef.push().setValue(animals);
        Toast.makeText(Posts.this,"Data Inserted",Toast.LENGTH_SHORT).show();


    }
}
