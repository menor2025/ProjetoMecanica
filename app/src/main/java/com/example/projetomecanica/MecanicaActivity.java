package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetomecanica.objetos.Mecanica;

public class MecanicaActivity extends AppCompatActivity {

    TextView nome_mecanica;
    TextView endereco_mecanica;
    TextView atendimento_mecanica;
    Button botao_busca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica);

        Intent intent = getIntent();
        Mecanica mecanica = (Mecanica) intent.getSerializableExtra("mecanica");

        nome_mecanica = findViewById(R.id.nome_mecanica);
        endereco_mecanica = findViewById(R.id.endereco_mecanica);
        atendimento_mecanica = findViewById(R.id.atendimento_mecanica);
        botao_busca = findViewById(R.id.botao_busca);

        nome_mecanica.setText(mecanica.getNome());
        endereco_mecanica.setText(mecanica.getEndereco());
        atendimento_mecanica.setText(mecanica.getAtendimento());


        botao_busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:?q= "+ endereco_mecanica.getText());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }

        });
    }
}

