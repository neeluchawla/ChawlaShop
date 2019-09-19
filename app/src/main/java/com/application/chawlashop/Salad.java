package com.application.chawlashop;


/*

Model class
 */
public class Salad {
    private int id;
    private String title;
    private double price;
    private int quantity;
    private final int thumbnail;
    private String description;
    private float subtotal;


    public Salad(int thumbnail){

        this.thumbnail = thumbnail;
    }

    public Salad(int id, String title, String description, int quantity, double price, int thumbnail) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.thumbnail=thumbnail;
        this.description=description;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
