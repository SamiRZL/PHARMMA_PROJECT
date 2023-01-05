package com.example.pharmma;

public class Sales {

    private int id;
    private String name;
    private int unites;
    private int total;
    private String date;

    public Sales(){

    }

    public Sales(int id, String name, int unites, int total, String date) {
        this.id = id;
        this.name = name;
        this.unites = unites;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnites() {
        return unites;
    }

    public void setUnites(int unites) {
        this.unites = unites;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}