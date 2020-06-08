package com.example.recyler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class new_product extends AppCompatActivity {
Product p;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        db=new DatabaseHelper(this);

    }

    public void p_1(View view)
    {
        Intent r = getIntent();
     // Product_list p = (Product_list) r.getSerializableExtra("sampleObject");
       // p.add_product(1,"abc","xyz",R.drawable.ic_launcher_background);
        if(db.search(1)) {
            Log.e("entered", "p1");
        }else
        {
            Log.e("false", "p1");
        }
       // Log.e("entered","p1");
        Intent i = new Intent(this, MainActivity.class);
       // i.putExtra("sampleObject", (Serializable) p);
        startActivity(i);
        finish();

    }
    public void p_2(View view)
    {
        Intent r = getIntent();
       // Product_list p = (Product_list) r.getSerializableExtra("sampleObject");
        //p.add_product(2,"def","xyz",R.drawable.ic_launcher_background);
if(db.search(2)) {
    Log.e("entered", "p2");
}else
{
    Log.e("false", "p2");
}
        Intent i = new Intent(this, MainActivity.class);
        //i.putExtra("sampleObject", (Serializable) p);
        startActivity(i);
        finish();
    }
    public void p_3(View view)
    {
        Intent r = getIntent();
        //Product_list p = (Product_list) r.getSerializableExtra("sampleObject");
        //p.add_product(3,"qwe","xyz",R.drawable.ic_launcher_background);

       // Log.e("entered","p1");
        if(db.search(3)) {
            Log.e("entered", "p3");
        }else
        {
            Log.e("false", "p3");
        }
       Intent i = new Intent(this, MainActivity.class);
       // i.putExtra("sampleObject", (Serializable) p);
        startActivity(i);
        finish();
    }

}
