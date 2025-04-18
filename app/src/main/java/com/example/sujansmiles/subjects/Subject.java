package com.example.sujansmiles.subjects;

public class Subject {
    private int id;
    private String name;
    private int color;

    public Subject() {
    }

    public Subject(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public Subject(int id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
