package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.DAO.CriaBanco;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

import java.util.ArrayList;

public class CadastroVeiculoActivity extends AppCompatActivity {

    ControlaBanco controlaBanco = new ControlaBanco(this);
    CriaBanco criaBanco = new CriaBanco(this);

    ListView list_motos;
    EditText veiculo_cadastro_km;
    EditText veiculo_cadastro_ano;
    EditText veiculo_cadastro_placa;
    EditText veiculo_cadastro_modelo;
    EditText veiculo_cadastro_marca;
    EditText veiculo_cadastro_apelido;
    Button veiculo_botao_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_veiculo);

        Intent intent = getIntent();
        Usuario user = (Usuario) intent.getSerializableExtra("usuario");

        veiculo_botao_salvar = findViewById(R.id.veiculo_botao_salvar);
        list_motos = findViewById(R.id.list_motos);

        veiculo_botao_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                veiculo_cadastro_apelido = findViewById(R.id.veiculo_cadastro_apelido);
                veiculo_cadastro_marca = findViewById(R.id.veiculo_cadastro_marca);
                veiculo_cadastro_modelo = findViewById(R.id.veiculo_cadastro_modelo);
                veiculo_cadastro_placa = findViewById(R.id.veiculo_cadastro_placa);
                veiculo_cadastro_ano = findViewById(R.id.veiculo_cadastro_ano);
                veiculo_cadastro_km = findViewById(R.id.veiculo_cadastro_km);

                veiculo_cadastro_apelido.getText().toString();
                veiculo_cadastro_marca.getText().toString();
                veiculo_cadastro_modelo.getText().toString();
                veiculo_cadastro_placa.getText().toString();
                veiculo_cadastro_ano.getText().toString();
                veiculo_cadastro_km.getText().toString();

                controlaBanco.insereDadoVeiculo(new Veiculo(veiculo_cadastro_apelido.getText().toString(), veiculo_cadastro_marca.getText().toString(),
                        veiculo_cadastro_modelo.getText().toString(), veiculo_cadastro_placa.getText().toString(),
                        veiculo_cadastro_ano.getText().toString(), veiculo_cadastro_km.getText().toString()), user);

               finish();
            }
        });
    }

}