package com.asovel.bibicleta.Comunicacion_base_datos.Backendlesscumple;

/**
 * Created by emilio on 17/09/2016.
 */
public class Bicis {
        String nombre;
        private String telefono;
        private String cumple;

        public Bicis(String nombre, String telefono, String cumple) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.cumple = cumple;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCumple() {
            return cumple;
        }

        public void setCumple(String cumple) {
            this.cumple = cumple;
        }
}