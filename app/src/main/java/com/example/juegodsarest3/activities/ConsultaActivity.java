package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Consulta;
import com.example.juegodsarest3.models.Swagger;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        configureDenunciaButton();
    }

    private void configureDenunciaButton() {
        Button BotonConsulta = (Button) findViewById(R.id.EnviarConsulta_button);
        EditText fecha = (EditText) findViewById(R.id.fecha);
        EditText title = (EditText) findViewById(R.id.title);
        EditText comentario = (EditText) findViewById(R.id.comentario);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String sender = sharedPreferences.getString("correo", "");

        BotonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Swagger swagger = Swagger.retrofit.create(Swagger.class);

                Consulta d = new Consulta(fecha.getText().toString(), title.getText().toString(), comentario.getText().toString(),sender);
                Call<Consulta> call = swagger.añadirConsulta(d);
                call.enqueue(new Callback<Consulta>() {
                    @Override
                    public void onResponse(Call<Consulta> call, Response<Consulta> response) {
                        Log.d("ERRORCRISTIAN",call.toString());
                        Log.d("ERRORCRISTIAN",response.toString());
                        if (response.isSuccessful()){
                            Snackbar mySnackbar = Snackbar.make(view, "Se ha registrado la consulta", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                        else {
                            Snackbar mySnackbar = Snackbar.make(view, "Esta consulta ya ha sido registrada", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Consulta> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "No se ha podido establecer la conexión para enviar la consulta", BaseTransientBottomBar.LENGTH_SHORT);
                        Log.d("ERRORCRISTIAN",t.toString());
                        mySnackbar.show();
                    }
                });
            }
        });
    }
}
