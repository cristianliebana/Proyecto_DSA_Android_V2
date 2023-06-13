package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.CredencialTO;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();

        Locale.setDefault(new Locale("es"));
        Configuration config = new Configuration();
        config.locale = Locale.getDefault();
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        configureTiendaButton();
        configureDenunciaButton();
        configureFAQButton();
        configureRankingButton();
        configureImageButton();
        configureEmpezarButton();
        configureCerrarSesionbtn();

        TextView myTextview = findViewById(R.id.textMenuPrincipal);
        String textoMenu = getResources().getString(R.string.Main_menu);
        myTextview.setText(textoMenu);

    }

    private void configureTiendaButton() {
        Button tienda_button = (Button) findViewById(R.id.tienda);
        String textoTienda = getResources().getString(R.string.Boton_tienda);
        tienda_button.setText(textoTienda);
        tienda_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuPrincipal.this, TiendaActivity.class));
            }
        });
    }
        private void configureDenunciaButton() {
            Button denuncia_button = (Button) findViewById(R.id.denunciabtn);
            String textoDenuncia = getResources().getString(R.string.Boton_Denuncia);
            denuncia_button.setText(textoDenuncia);
            denuncia_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // startActivity(new Intent(MenuPrincipal.this, DenunciaActivity.class));
                }
            });
        }
    private void configureFAQButton() {
        Button faq_button = (Button) findViewById(R.id.FAQbtn);
        faq_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MenuPrincipal.this, FAQActivity.class));
            }
        });
    }
    private void configureRankingButton() {
        Button ranking_button = (Button) findViewById(R.id.btnRanking);
        ranking_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(MenuPrincipal.this, RankingActivity.class));
            }
        });
    }
    private void configureImageButton() {
        ImageButton image_button = (ImageButton) findViewById(R.id.imageButton);
        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguienteIntent = new Intent(MenuPrincipal.this, UsuarioActivity.class);
                startActivity(siguienteIntent);
            }
        });
    }
    private void configureEmpezarButton() {
        Button empezarbutton = findViewById(R.id.empezarJuegobtn); // Reemplaza "button" con el ID de tu botón
        empezarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.Gallery"); // Reemplaza "com.tu.paquete" con el nombre del paquete de la APK que deseas abrir

                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "No se pudo encontrar la aplicación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void configureCerrarSesionbtn() {

        ImageButton cerrarbutton = (ImageButton) findViewById(R.id.cerrarSesionBtn);
        cerrarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Borrar los datos guardados en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                // Cerrar la aplicación

                finish();
                Intent intent = new Intent(MenuPrincipal.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                }
            });

    }
    }
