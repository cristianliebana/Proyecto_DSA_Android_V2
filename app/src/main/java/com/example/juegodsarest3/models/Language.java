package com.example.juegodsarest3.models;

public class Language {

    String correo;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    String language;

    public Language() {}

    public Language(String correo, String language){
        this.correo=correo;
        this.language=language;

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
