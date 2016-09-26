package com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas;

/**
 * POJO para los cursos
 */
 public class Bicicleta {
    private String name;
    private String description;
    private String author;
    private float rating;
    private String students;
    private float price;
    private String idImage;

    public Bicicleta(String name,
                     String description,
                     String author,
                     float rating,
                     String students,
                     float price,
                     String idImage) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.rating = rating;
        this.students = students;
        this.price = price;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public float getRating() {
        return rating;
    }

    public String getStudents() {
        return students;
    }

    public float getPrice() {
        return price;
    }

    public String getIdImage() {
        return idImage;
    }
}
