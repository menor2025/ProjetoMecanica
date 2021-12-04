package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.objetos.Chamados;
import com.example.projetomecanica.objetos.MeusVeiculos;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {

    EditText nome_usuario_autenticado;
    Button botao_motos_ticket;
    ListView list_chamados;
    ArrayList<Chamados> lista_chamados_moto = new ArrayList<>();
    ControlaBanco controlaBanco = new ControlaBanco(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Intent intent = getIntent();
        Usuario user = (Usuario) intent.getSerializableExtra("usuario");
        TextView nome_usuario_autenticado = findViewById(R.id.nome_usuario_autenticado);
        nome_usuario_autenticado.setText(user.getNome());
        list_chamados = (ListView) findViewById(R.id.list_chamados);

        lista_chamados_moto = controlaBanco.retornaListaChamado(user);
        ArrayList<String> chamados = new ArrayList<>();

        for (Chamados chamadoTemp : lista_chamados_moto){
            chamados.add(chamadoTemp.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,chamados);
        list_chamados.setAdapter(adapter);


        botao_motos_ticket = findViewById(R.id.botao_motos_ticket);

        botao_motos_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeusveiculosActivity.class);
                intent.putExtra("usuario", user);
                startActivity(intent);
            }
        });

        list_chamados.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TicketMecanicaActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("chamados", (Serializable)lista_chamados_moto.get(position));
                Veiculo veiculo = controlaBanco.getVeiculo(lista_chamados_moto.get(position).getId_moto());
                intent.putExtra("motos", (Serializable) veiculo);
                Log.d("testelista", lista_chamados_moto.get(position).getDescricao());
                Log.d("testelista1", "testando ");
                startActivity(intent);
            }
        });

    }
}