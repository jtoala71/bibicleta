package com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas;

import java.util.Arrays;
import java.util.List;
import com.asovel.bibicleta.R;

/**
 * Creado por staf.
 */
/*
new Bicicleta(
variables a añadir
 modelo bici            "Curso Online De Seo Para Principiantes",
 texto1                 "Aprende prácticas para optimizar tanto internos como externos de tu sitio " +
 texto2                 "web con el fin de recibir mas tráfico desde los motores de búsqueda\n" +
                        "\n" +
 texto3                 "Más de 30 clases \n" +
 texto4                 "12 horas de contenido",
 proveedor              "Carlos Villa",


        variables a añadir
        nº estrellasf, precio, cantidad en stock, R.drawable.fotobici), ...



        public class Bicicletas {
        private static Bicicleta[] Bicicletas = {
            new Bicicleta( modelo bici, texto1 + texto2 + "\n" + texto3 + texto4,  proveedor ,nº estrellasf, precio, cantidad en stock, foto) , ...
             , };




        */


public class Bicicletas {
    private static Bicicleta[] Bicicletas = {
            new Bicicleta("",
                    " " +
                            "\n" +
                            "\n" +
                            " \n" +
                            "", "Fabricante1",
                    3f, "modelo 2323", 22, "http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
            new Bicicleta("",
                    "" +
                            " .\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n", "Fabricante1",
                    5f,"modelo 2323", 24,"http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
            new Bicicleta("",
                    " " +
                            ".\n" +
                            "\n" +
                            "45 \n" +
                            "\n" +
                            "\n", "Fabricante1",
                    4.4f,"modelo 2323", 32, "http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
            new Bicicleta("",
                    " " +
                            "" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "", "Fabricante1",
                    3.4f,"modelo 2323", 35, "http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
            new Bicicleta("",
                    "" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "", "Fabricante1",
                    4.0f,"modelo 2323", 45, "http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
            new Bicicleta("",
                    "" +
                            " " +
                            "\n" +
                            "\n" +
                            "\n" +
                            "",
                    "Fabricante1", 3.2f, "modelo 2323", 34, "http://www.zonagravedad.com/images/Gravity_Bike/bicis_para_transformar/Scott_Jr.jpg"),
    };

    /**
     * Obtiene como lista todos los cursos de prueba
     *
     * @return Lista de cursos
     */
    public static List<Bicicleta> getBicicletas() {
        return Arrays.asList(Bicicletas);
    }

    /**
     * Obtiene un curso basado en la posición del array
     *
     * @param position Posición en el array
     * @return Curso seleccioando
     */
    public static Bicicleta getBicicletaByPosition(int position) {
        return Bicicletas[position];
    }

}
