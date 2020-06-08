package com.example.recyler_view;


import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String title;
    private String shortdesc;
     private String image;

    public Product(int id, String title, String shortdesc, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
    }

    public String ifClicked()
    {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }


    public String getImage() {
        return image;
    }
}