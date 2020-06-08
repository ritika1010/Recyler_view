package com.example.recyler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ifClicked_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if_clicked_page);
        Intent r = getIntent();
        String t =  r.getStringExtra("string");
        TextView tv=findViewById(R.id.textView);
        tv.setText(t);
    }
}
