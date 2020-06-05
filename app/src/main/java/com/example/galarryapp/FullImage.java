package com.example.galarryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        ImageView imageView=(ImageView)findViewById(R.id.fullImage);
        int id=getIntent().getExtras().getInt("ima_id");
        imageView.setImageResource(id);
    }
}
