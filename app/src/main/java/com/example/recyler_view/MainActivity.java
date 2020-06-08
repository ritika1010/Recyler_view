package com.example.recyler_view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    //a list to store all the products
   public List<Product> productList;
    //Product_list p;
    DatabaseHelper db;
    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("pr", String.valueOf(R.drawable.ic_launcher_background));
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList=new ArrayList<>();

db=new DatabaseHelper(this);
//db.delete_db();

Product product[]=db.give_display();
        Log.e("length", String.valueOf(product.length));
        for(int i=0;i<product.length-1;i++)
        {
            if(product[i]==null)
            {
                break;
            }
            Product pr=product[i];
            Log.e("products",pr.getTitle());
           productList.add(pr);
        }

        //creating recyclerview adapter
        final ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ProductAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String temp=productList.get(position).ifClicked();
               clicked(temp);
                adapter.notifyItemChanged(position);
            }
        });
    }

    public void add_product(View view)
    {

        Intent i = new Intent(this, new_product.class);
        //i.putExtra("sampleObject", (Serializable) p);
        startActivity(i);

        finish();


    }

    public void clicked(String t)
    {
        Intent i = new Intent(this, ifClicked_page.class);
        i.putExtra("string", t);
        startActivity(i);
    }

    public void clear_db(View view)
    {
        Log.e("clear","done");
        db.delete_db();
        Intent i = new Intent(this, MainActivity.class);
        //i.putExtra("sampleObject", (Serializable) p);
        startActivity(i);

        finish();
    }
}