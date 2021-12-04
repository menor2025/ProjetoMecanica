package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.objetos.Mecanica;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaMecanicaActivity extends AppCompatActivity {

    ListView list_mecanica;
    ArrayList<Mecanica> lista_mecanica = new ArrayList<>();
    ControlaBanco controlaBanco = new ControlaBanco(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mecanica);

        list_mecanica = (ListView) findViewById(R.id.list_mecanica);

        lista_mecanica = controlaBanco.retornaListaMecanica();
        ArrayList<String> mecanica = new ArrayList<>();

        for(Mecanica mecanicaTemp : lista_mecanica){
            mecanica.add(mecanicaTemp.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mecanica);
        list_mecanica.setAdapter(adapter);


        list_mecanica.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(getApplicationContext(), MecanicaActivity.class);
              intent.putExtra("mecanica", (Serializable) lista_mecanica.get(position));
              //Log.d("testelista", lista_mecanica.get(position).getAtendimento());
              startActivity(intent);

            }
        });



    }
}