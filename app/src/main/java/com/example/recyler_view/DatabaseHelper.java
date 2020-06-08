package com.example.recyler_view;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;

public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {
    public static final String Database_name = "products.db";
    public static final String table_1 = "product_data";
    public static final String table_2 = "products";
    public static final String col_0 = "id";
    public static final String col_1 = "Title";
    public static final String col_2 = "ShortDescr";
    public static final String col_3 = "Image";

    //To store the images in db
    //Integer[] imageIDs = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};

    public DatabaseHelper(Context context) {
        super(context, Database_name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_1 + " (id INTEGER,Title VARCHAR(20), ShortDescr VARCHAR(30), Image VARCHAR(20))");
        db.execSQL("create table " + table_2 + " (id INTEGER ,Title VARCHAR(20), ShortDescr VARCHAR(30), Image VARCHAR(20))");
        db.execSQL("Insert into "+ table_1+" values (1,'famous five','kids novel','ic_launcher_background')");
        db.execSQL("Insert into "+ table_1+" values (2,'secret seven','kids novel','ic_launcher_background')");
        db.execSQL("Insert into "+ table_1+" values (3,'nancy drew','kids novel','ic_launcher_background')");
        db.execSQL("Insert into "+ table_1+" values (4,'wildlife','encyclopedia','ic_launcher_background')");
        db.execSQL("Insert into "+ table_1+" values (5,'wings of fire','autobiography','ic_launcher_background')");

        db.execSQL("Insert into "+ table_2+" values (2,'secret seven','kids novel','ic_launcher_background')");
        db.execSQL("Insert into "+ table_2+" values (3,'nancy drew','kids novel','ic_launcher_background')");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_1);
        db.execSQL("DROP TABLE IF EXISTS " + table_2);
        onCreate(db);

    }
    public void delete_db() {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + table_1);
        db.execSQL("DROP TABLE IF EXISTS " + table_2);
        onCreate(db);

    }

    public void add_product(int id,String Title,String ShortDescr,String Image)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("Insert into "+ table_2+" values ("+id + ",'"+Title+"','"+ShortDescr+"','"+Image+"')");
    }

    public boolean search(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor= (Cursor) db.rawQuery("SELECT * FROM "+ table_1 + " WHERE "
                + col_0 + " = " + id  ,null);
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String title = cursor.getString(cursor.getColumnIndex("Title"));
            String ShortDescr = cursor.getString(cursor.getColumnIndex("ShortDescr"));
            String img =cursor.getString(cursor.getColumnIndex("Image"));
            add_product(id,title,ShortDescr,img);
            return true;
        }
        else
            return false;
    }

    public Product[] give_display()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= (Cursor) db.rawQuery("SELECT * FROM "+ table_2 ,null);

        Product p[]=new Product[10];

        if(cursor.moveToFirst())
        {
            int i=0;
            do {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String title = cursor.getString(cursor.getColumnIndex("Title"));
                String ShortDescr = cursor.getString(cursor.getColumnIndex("ShortDescr"));
                String img =cursor.getString(cursor.getColumnIndex("Image"));
                p[i] = new Product(id, title, ShortDescr, img);
                Log.e(String.valueOf(p[i].getId()),p[i].getTitle());
                i++;
            }while(cursor.moveToNext());
        }


        return p;
    }
}