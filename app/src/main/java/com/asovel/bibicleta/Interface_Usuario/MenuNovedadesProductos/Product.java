package com.asovel.bibicleta.Interface_Usuario.MenuNovedadesProductos;

/**
 * POJO de un producto
 */
public class Product {
    /**
     * name del producto
     */
    private String name;

    /**
     * direccion http de la imagen producto
     */
    private String idImage;
    /**
     * Especificaciones del producto
     */
    private String descripcion;
    /**
     * Precio del producto
     */
    private String precio;
    /**
     * Valoraciones del producto
     */
    private float rating;
    /**
     * Identificador de la imagen para miniatura
     */
    private int idThumbnail;

    public Product(String name, String descripcion, String precio, float rating,String idImage) {
        this.name = name;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rating = rating;
        this.idImage = idImage;
        this.idThumbnail = idThumbnail;
    }

/*
    public Bicicleta(String name,String description,String author,float rating,String students,float price, String idImage) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.rating = rating;
        this.students = students;
        this.price = price;
        this.idImage = idImage;
    }
    
    */
    
    
    public Product() {
    }

    public String getName() {
        return name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIdImage() {
        return idImage;
    }

    public String getPrice() {
        return precio;
    }

    public float getRating() {
        return rating;
    }

    public int getIdThumbnail() {
        return idThumbnail;
    }
}
