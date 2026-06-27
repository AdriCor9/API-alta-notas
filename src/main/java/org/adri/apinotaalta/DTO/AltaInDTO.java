package org.adri.apinotaalta.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AltaInDTO implements Serializable {
    private String user;
    private String titulo;
    private String descripcion;
    private Color color;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AltaInDTO{" +
                "user='" + user + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color=" + color +
                '}';
    }
}
