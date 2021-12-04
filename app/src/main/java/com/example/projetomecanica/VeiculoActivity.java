package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.DAO.CriaBanco;
import com.example.projetomecanica.objetos.Chamados;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

public class VeiculoActivity extends AppCompatActivity {

    ControlaBanco controlaBanco = new ControlaBanco(this);
    CriaBanco criaBanco = new CriaBanco(this);

    TextView veiculo_km;
    TextView veiculo_ano;
    TextView veiculo_placa;
    TextView veiculo_modelo;
    TextView veiculo_marca;
    TextView veiculo_apelido;

    EditText descricao_chamado;
    Button botao_abrir_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        Intent intent = getIntent();
        Usuario user = (Usuario) intent.getSerializableExtra("usuario");
        Veiculo veiculo = (Veiculo) intent.getSerializableExtra("motos");
        Log.d("testeacveiculos", veiculo.getApelido());


        veiculo_apelido = findViewById(R.id.veiculo_apelido);
        veiculo_marca = findViewById(R.id.veiculo_marca);
        veiculo_modelo = findViewById(R.id.veiculo_modelo);
        veiculo_placa = findViewById(R.id.veiculo_placa);
        veiculo_ano = findViewById(R.id.veiculo_ano);
        veiculo_km = findViewById(R.id.veiculo_km);
        descricao_chamado = findViewById(R.id.descricao_chamado);
        botao_abrir_ticket = findViewById(R.id.botao_abrir_ticket);


        veiculo_apelido.setText(veiculo.getApelido().toString());
        veiculo_marca.setText(veiculo.getMarca().toString());
        veiculo_modelo.setText(veiculo.getModelo().toString());
        veiculo_placa.setText(veiculo.getPlaca().toString());
        veiculo_ano.setText(veiculo.getAno().toString());
        veiculo_km.setText(veiculo.getQuilometragem().toString());



        botao_abrir_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  controlaBanco.insereDadoChamado(descricao_chamado.getText().toString(), veiculo, user);
                  finish();
            }
        });

    }

}