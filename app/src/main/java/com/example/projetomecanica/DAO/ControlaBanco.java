package com.example.projetomecanica.DAO;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.CrossProfileApps;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetomecanica.objetos.Chamados;
import com.example.projetomecanica.objetos.Mecanica;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlaBanco {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ControlaBanco(Context context) {
        banco = new CriaBanco(context);
    }

    public void insereDadoVeiculo(Veiculo veiculo, Usuario usuario) {
        db = banco.getWritableDatabase();
        ContentValues valores;
        long resultado;
        valores = new ContentValues();

        valores.put(CriaBanco.APELIDO_VEICULO, veiculo.getApelido());
        valores.put(CriaBanco.MARCA_VEICULO, veiculo.getMarca());
        valores.put(CriaBanco.MODELO_VEICULO, veiculo.getModelo());
        valores.put(CriaBanco.PLACA_VEICULO, veiculo.getPlaca());
        valores.put(CriaBanco.ANO_VEICULO, veiculo.getAno());
        valores.put(CriaBanco.QUILOMETRAGEM_VEICULO, veiculo.getQuilometragem());
        valores.put(CriaBanco.ID_PESSOA, usuario.getId());

        resultado = db.insert(CriaBanco.TABELA_VEICULO, null, valores);

        if (resultado == -1) {
            Log.d("erro_ao_inserir_veiculo", "O dado do veículo não foi inserido, amigo." + resultado);
        } else {
            Log.d("sucesso_inserir_veiculo", "O dado do veículo foi inserido, amigo.");
        }
    }

    public void insereDadoMecanica(Mecanica mecanica) {
        db = banco.getWritableDatabase();
        ContentValues valores;
        long resultado;
        valores = new ContentValues();

        valores.put(CriaBanco.NOME_MECANICA, mecanica.getNome());
        valores.put(CriaBanco.ENDERECO_MECANICA, mecanica.getEndereco());
        valores.put(CriaBanco.ATENDIMENTO_MECANICA, mecanica.getAtendimento());


        resultado = db.insert(CriaBanco.TABELA_MECANICA, null, valores);

        if (resultado == -1) {
            Log.d("erro_inserir_mecanica", "O dado da mecanica não foi inserido, amigo." + resultado);
        } else {
            Log.d("suce_inserir_mecananica", "O dado da mecanica não foi inserido, amigo." + resultado);
        }
    }

    public String insereDadoUsuario(Usuario pessoa) {
        db = banco.getWritableDatabase();
        ContentValues valores;
        long resultado;
        valores = new ContentValues();

        valores.put(CriaBanco.NOME, pessoa.getNome());
        valores.put(CriaBanco.USUARIO, pessoa.getUser());
        valores.put(CriaBanco.SENHA, pessoa.getSenha());
        valores.put(CriaBanco.ISADMINISTRATOR, pessoa.isAdministrator());
        valores.put(CriaBanco.ISACTIVE, pessoa.isActive());

        resultado = db.insert(CriaBanco.TABELA, null, valores);


        if (resultado == -1) {
            Log.d("erro_ao_inserir", "O dado não foi inserido, amigo." + resultado);
            return "retorno teste";

        } else {
            Log.d("sucesso_ao_inserir", "O dado foi inserido, amigo.");
            return "retorno teste2";
        }
    }

    public String insereDadoChamado(String descricao, Veiculo veiculo, Usuario usuario){
        db = banco.getWritableDatabase();
        ContentValues valores;
        long resultado;
        valores = new ContentValues();

        valores.put(CriaBanco.DESCRICAO_CHAMADO, descricao);
        valores.put(CriaBanco.ID_PESSOA_CHAMADO, usuario.getId());
        valores.put(CriaBanco.ID_MOTO, veiculo.getId());

        resultado = db.insert(CriaBanco.TABELA_CHAMADOS, null, valores);


        if (resultado == -1) {
            Log.d("erro_ao_inserir", "O dado não foi inserido, amigo." + resultado);
            return "retorno teste";

        } else {
            Log.d("sucesso_ao_inserir", "O dado foi inserido, amigo.");
            return "retorno teste2";
        }
    }

    @SuppressLint("Range")
    public Usuario getUsuario(String nome_usuario) {
        db = banco.getReadableDatabase();
        String sql_retorna_usuario = "SELECT * FROM pessoa WHERE username = '" + nome_usuario + "'";
        Cursor cursor = db.rawQuery(sql_retorna_usuario,null);
        Usuario user_temp = new Usuario();
        while(cursor.moveToNext()){
            if(Objects.equals(nome_usuario, cursor.getString(2))){

                user_temp.setId(cursor.getInt(0)); // Setando ID
                user_temp.setNome(cursor.getString(1)); // Setando nome
                user_temp.setUser(cursor.getString(2)); // Setando username
                user_temp.setSenha(cursor.getString(3)); // Setando senha
                user_temp.setAdministrator((cursor.getInt(4) == 0 ? false : true)); // Setando se é adm ou não
            }
        }
        Log.d("getUsuario", "Nome do usuário: " + user_temp.getNome());
        return user_temp;
    }
    public Veiculo checaVeiculo(String placa_veiculo){
        db = banco.getReadableDatabase();
        String sql_retorna_veiculo = "SELECT * FROM veiculo WHERE " + CriaBanco.TABELA_VEICULO + "." + CriaBanco.PLACA_VEICULO + " LIKE " + " '%" + placa_veiculo + "%'";
        Cursor cursor = db.rawQuery(sql_retorna_veiculo,null);
        Veiculo veic_temp = new Veiculo();

        while(cursor.moveToNext()){
            if(Objects.equals(placa_veiculo,cursor.getString(4))){
                veic_temp.setId(cursor.getInt(0));
                veic_temp.setApelido(cursor.getString(1));
                veic_temp.setMarca(cursor.getString(2));
                veic_temp.setModelo(cursor.getString(3));
                veic_temp.setPlaca(cursor.getString(4));
                veic_temp.setAno(cursor.getString(5));
                veic_temp.setQuilometragem(cursor.getString(6));
            }
        }
        return veic_temp;
    }

    @SuppressLint("Range")
    public Veiculo getVeiculo(Integer id_veiculo) {
        db = banco.getReadableDatabase();
        String sql_retorna_veiculo = "SELECT * FROM veiculo WHERE _id = " + id_veiculo;
        Cursor cursor = db.rawQuery(sql_retorna_veiculo, null);
        Veiculo veiculo_temp = new Veiculo("", "", "","",""," ");
        while (cursor.moveToNext()) {
            if (id_veiculo == cursor.getInt(0)) {

                veiculo_temp.setId(cursor.getInt(0)); // Setando ID
                veiculo_temp.setApelido(cursor.getString(1)); // Setando apelido
                veiculo_temp.setMarca(cursor.getString(2)); // Setando Marca
                veiculo_temp.setModelo(cursor.getString(3)); // Setando MOdelo
                veiculo_temp.setPlaca(cursor.getString(4)); // Setando placa
                veiculo_temp.setAno(cursor.getString(5)); // Setando Ano
                veiculo_temp.setQuilometragem(cursor.getString(6)); // Setando KM
            }
        }
        Log.d("getVeiculo", "Apelido do veiculo: " + veiculo_temp.getApelido());

        return veiculo_temp;
    }

    public boolean autenticaPessoa(String usuario, String senha) {
        db = banco.getReadableDatabase();
        String sql_busca_pessoas = "SELECT * FROM pessoa WHERE username = " + "'" + usuario + "'";
        Cursor c = db.rawQuery(sql_busca_pessoas, null);
        while (c.moveToNext()) {
            Log.d("logwhile", c.getString(3));
            if (Objects.equals(senha, c.getString(3))) {
                Log.d("senha", "deucertoautenticar");
                return true;
            } else {
                Log.d("senha1", "naocertoautenticar");
                return false;
            }
        }
        c.close();
        return false;
    }


    public ArrayList<Veiculo> retornaListaMoto(Usuario usuario) {
        ArrayList<Veiculo> listaMotos = new ArrayList<>();
        db = banco.getReadableDatabase();
        String sql_busca_moto = " SELECT * FROM " + CriaBanco.TABELA_VEICULO + " WHERE " + CriaBanco.ID_PESSOA + " = " + usuario.getId();
        Cursor c = db.rawQuery(sql_busca_moto, null);
        while (c.moveToNext()) {
            Veiculo veiculo_temp = new Veiculo(c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6));

            veiculo_temp.setId(c.getInt(0));

            listaMotos.add(veiculo_temp);

        }

        return listaMotos;
    }


    public ArrayList<Chamados> retornaListaChamado(Usuario usuario) {
        ArrayList<Chamados> listaChamado = new ArrayList<>();
        db = banco.getReadableDatabase();
        String sql_busca_chamado = " SELECT * FROM " + CriaBanco.TABELA_CHAMADOS + " WHERE " + CriaBanco.ID_PESSOA_CHAMADO + " = " + usuario.getId();
        Cursor c = db.rawQuery(sql_busca_chamado, null);
        while (c.moveToNext()) {
            Chamados chamados = new Chamados(c.getString(1));

                    chamados.setId(c.getInt(0));
                    chamados.setId_moto(c.getInt(3));
            listaChamado.add(chamados);

        }

        return listaChamado;
    }

    public ArrayList<Mecanica> retornaListaMecanica() {
        ArrayList<Mecanica> listaMecanica = new ArrayList<>();
        db = banco.getReadableDatabase();
        String sql_busca_mecanica = " SELECT * FROM " + CriaBanco.TABELA_MECANICA;
        Cursor c = db.rawQuery(sql_busca_mecanica, null);
        while (c.moveToNext()) {
            Mecanica mecanica = new Mecanica(c.getString(1),
                    (c.getString(2)),
                    (c.getString(3)));

            mecanica.setId(c.getInt(0));
            listaMecanica.add(mecanica);

        }

        return listaMecanica;
    }


}


