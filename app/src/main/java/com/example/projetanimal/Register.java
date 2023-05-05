package com.example.projetanimal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText name;
    private EditText type;
    private EditText address;
    private EditText phone;
    private EditText age;
    private Button postbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        type=findViewById(R.id.type);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        postbtn=findViewById(R.id.postbtn);

        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, login.class);
                startActivity(intent);

            }
        });
    }
}
