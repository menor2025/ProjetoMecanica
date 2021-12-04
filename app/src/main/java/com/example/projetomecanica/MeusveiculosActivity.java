package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MeusveiculosActivity extends AppCompatActivity {

    Button botao_cadastrar_moto;
    ListView list_motos;
    ArrayList<Veiculo> lista_veiculo_moto = new ArrayList<Veiculo>();
    ControlaBanco controlaBanco = new ControlaBanco(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meusveiculos);

        Intent intent = getIntent();
        Usuario user = (Usuario) intent.getSerializableExtra("usuario");
        botao_cadastrar_moto = findViewById(R.id.botao_cadastrar_moto);
        list_motos = (ListView) findViewById(R.id.list_motos);

        lista_veiculo_moto = controlaBanco.retornaListaMoto(user);
        ArrayList<String> motos = new ArrayList<String>();


        for(Veiculo veicTemp : lista_veiculo_moto){
            motos.add(veicTemp.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,motos);
        list_motos.setAdapter(adapter);

        // criar ação para evento de click no veiculo
        list_motos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), VeiculoActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("motos", (Serializable)lista_veiculo_moto.get(position));
                Log.d("teste", lista_veiculo_moto.get(position).getApelido());
                startActivity(intent);
            }
        });


        botao_cadastrar_moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroVeiculoActivity.class);
                intent.putExtra("usuario", user);
                startActivity(intent);
            }
        });

    }
}