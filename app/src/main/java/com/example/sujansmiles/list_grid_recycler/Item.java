package com.example.sujansmiles.list_grid_recycler;

public class Item {
    private int imageResource;
    private String title;

    public Item(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}
