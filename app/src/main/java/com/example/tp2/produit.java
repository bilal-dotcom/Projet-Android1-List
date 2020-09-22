package com.example.tp2;

public class produit {
    private  String nom;
    private String type;
    private double prix;
    private int image;

    public produit(String nom, String type, double prix, int image) {
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.image = image;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getprix() {
        return prix;
    }

    public void setprix(int prix) {
        this.prix = prix;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
