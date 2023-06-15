package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Language;
import com.example.juegodsarest3.models.Swagger;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdiomaActivity extends AppCompatActivity {

    private Button btnespañol;
    private Button btningles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);

        btnespañol = findViewById(R.id.btnespañol);
        btningles = findViewById(R.id.btningles);

        btnespañol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale.setDefault(new Locale("es"));
                Configuration config = new Configuration();
                config.locale = Locale.getDefault();
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("idioma", "es");
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                Swagger swagger = Swagger.retrofit.create(Swagger.class);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String correo = sharedPreferences.getString("correo", "");
                String propiedad1 = correo;
                String propiedad2 = "es";
                Call<Language> call = swagger.putLanguage(propiedad1,propiedad2);

                call.enqueue(new Callback<Language>() {
                    @Override
                    public void onResponse(Call<Language> call, Response<Language> response) {
                        Log.d("ERRORIDIOMA", call.toString());
                        Log.d("ERRORIDIOMA", response.toString());
                        if (response.isSuccessful()) {
                            Snackbar mySnackbar = Snackbar.make(view, "Se ha enviado el idioma", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        } else {
                            Snackbar mySnackbar = Snackbar.make(view, "Esta idioma ya ha sido registrado", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Language> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "No se ha podido establecer la conexión para enviar tus preferencias de idioma", BaseTransientBottomBar.LENGTH_SHORT);
                        Log.d("ERRORIDIOMA", t.toString());
                        mySnackbar.show();
                    }
                });
            }
        });

        btningles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale.setDefault(new Locale("en"));
                Configuration config = new Configuration();
                config.locale = Locale.getDefault();
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("idioma", "en");
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                Swagger swagger = Swagger.retrofit.create(Swagger.class);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String correo = sharedPreferences.getString("correo", "");
                String propiedad1 = correo;
                String propiedad2 = "en";
                Call<Language> call = swagger.putLanguage(propiedad1,propiedad2);

                call.enqueue(new Callback<Language>() {
                    @Override
                    public void onResponse(Call<Language> call, Response<Language> response) {
                        Log.d("ERRORCRISTIAN", call.toString());
                        Log.d("ERRORCRISTIAN", response.toString());
                        if (response.isSuccessful()) {
                            Snackbar mySnackbar = Snackbar.make(view, "Se ha registrado la denuncia", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        } else {
                            Snackbar mySnackbar = Snackbar.make(view, "Esta denuncia ya ha sido registrada", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Language> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "No se ha podido establecer la conexión para enviar la denuncia", BaseTransientBottomBar.LENGTH_SHORT);
                        Log.d("ERRORCRISTIAN", t.toString());
                        mySnackbar.show();
                    }
                });
            }
        });
    }
}
