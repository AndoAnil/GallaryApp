package com.example.galarryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> images=new ArrayList<>(Arrays.asList(R.drawable.a1,R.drawable.a2,R.drawable.a3,
            R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.bf,R.drawable.bg,R.drawable.budha,R.drawable.china,R.drawable.cute,
            R.drawable.f,R.drawable.jaipur,R.drawable.s,R.drawable.tom,R.drawable.tomandjerry));

    TextView image_name;
    ImageView pic;
    Button close;
    Button open;

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);
        TextView image_name=(TextView)findViewById(R.id.imageName);
        ImageView pic=(ImageView)findViewById(R.id.images);
        Button close=(Button)findViewById(R.id.close);
        Button open=(Button)findViewById(R.id.open);
        gridView.setAdapter(new ImageAdapter(images,this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogBox1(position);

            }
        });
    }
    public void showDialogBox1(final int pos)
    {
        final Dialog dialog=new Dialog(getApplicationContext());
        dialog.setContentView(R.layout.image);
        String title=getResources().getResourceName(pos);
        final int index=title.indexOf("/");
        String name=title.substring(index+1,title.length());
        image_name.setText(name);

        pic.setImageResource(images.get(pos));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FullImage.class);
                intent.putExtra("img_id",pos);
                startActivity(intent);
            }
        });
        dialog.show();
    }

}
