package com.example.projetanimal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetanimal.ui.gallery.GalleryFragment;

public class Profile extends AppCompatActivity {
    private ImageView profileImage;
    private TextView profileName;
    private Button AddNewPost;
    private Button SeeNewPost;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileImage=findViewById(R.id.profileImage);
        profileName=findViewById(R.id.profileName);
        AddNewPost=findViewById(R.id.addNewPost);
        SeeNewPost=findViewById(R.id.seeNewPost);
        logout=findViewById(R.id.logout);

        AddNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,Posts.class);
                startActivity(intent);
            }
        });
        SeeNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this, GalleryFragment.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, login.class);
                startActivity(intent);

            }
        });
    }
}
