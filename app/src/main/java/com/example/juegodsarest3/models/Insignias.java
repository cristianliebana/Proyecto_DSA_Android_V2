package com.example.juegodsarest3.models;

public class Insignias {

    String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    String nombreinsignia;
    String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Insignias(){


    }

    public Insignias(String correo,String nombreinsignia, String avatar){
        setCorreo(correo);
        setNombreinsignia(nombreinsignia);
        setAvatar(avatar);
    }

    public String getNombreinsignia() {
        return nombreinsignia;
    }

    public void setNombreinsignia(String nombreinsignia) {
        this.nombreinsignia = nombreinsignia;
    }
}
