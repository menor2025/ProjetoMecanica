package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.objetos.Chamados;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

public class TicketMecanicaActivity extends AppCompatActivity {

    TextView apelido_chamado_set;
    TextView placa_chamado_set;
    TextView descricao_chamado_set;
    Button botao_seleciona_mecanica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_mecanica);

        Intent intent = getIntent();
        Chamados chamados = (Chamados) intent.getSerializableExtra("chamados");
        Veiculo veiculo = (Veiculo) intent.getSerializableExtra("motos");


        botao_seleciona_mecanica = findViewById(R.id.botao_seleciona_mecanica);
        apelido_chamado_set = findViewById(R.id.apelido_chamado_set);
        placa_chamado_set = findViewById(R.id.placa_chamado_set);
        descricao_chamado_set = findViewById(R.id.descricao_chamado_set);

        apelido_chamado_set.setText(veiculo.getApelido());
        placa_chamado_set.setText(veiculo.getPlaca());
        descricao_chamado_set.setText(chamados.getDescricao());


        botao_seleciona_mecanica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaMecanicaActivity.class);
                startActivity(intent);
            }
        });

    }

}