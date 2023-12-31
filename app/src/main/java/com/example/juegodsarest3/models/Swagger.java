package com.example.juegodsarest3.models;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.*;

public interface Swagger {

    String URL = "http://147.83.7.203:80/dsaApp/";

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("game/login")
    Call<Usuario> Login(@Body CredencialTO ul);

    @POST("game/registrarUsuario2")
    Call<Usuario> registrarUsuario2(@Body Usuario ur);

    @POST("game/compraObjetos/{correo}/{nombreObjeto}")
    Call<TablaCompra> hacerCompra(@Path("correo") String correo, @Path("nombreObjeto") String nombreObjeto);

    @POST("game/question")
    Call<Consulta> añadirConsulta(@Body Consulta d);

    @GET("game/addObjeto")
    Call<List<Objeto>> Objetos();

    @GET("game/listaObjetos")
    Call<List<Objeto>> getlistaObjetos();

    @GET("game/posts")
    Call<List<Mensaje>> getlistaMensajes();

    @GET("game/badges/{correo}")
    Call<List<Insignia>> getInsignias(@Path("correo") String correo);

    @GET("game/datosUsuario/{correo}")
    Call<Usuario> getUsuario(@Path("correo") String correo);

    @GET("game/listaObjetosUsuario/{correo}")
    Call<List<TablaCompra>> getlistaObjetosUsuario(@Path("correo") String correo);

    @GET("game/getMapa/{nombremapa}")
    Call <Mapa> getMapa(@Path("nombremapa") String nombremapa);

    @PUT("game/putLanguage/{correo}/{language}")
    Call<Language> putLanguage(@Path("correo") String correo, @Path("language") String language);
}