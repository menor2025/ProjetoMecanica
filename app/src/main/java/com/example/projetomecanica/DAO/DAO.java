//package com.example.projetomecanica.DAO;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.projetomecanica.objetos.Pessoa;
//
//public class DAO extends SQLiteOpenHelper {
//    public DAO(Context context){
//        super(context, "banco", null, 7);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql_pessoa = "CREATE TABLE tb_usuario(pessoa_id INTEGER PRIMARY KEY, pessoa_nome TEXT," +
//                "pessoa_usuario TEXT," +
//                "pessoa_senha TEXT);";
//
//        String sql_moto = "CREATE TABLE tb_moto(id INTEGER PRIMARY KEY AUTOINCREMENT, moto_modelo TEXT," +
//                "moto_marca TEXT," +
//                "moto_placa TEXT UNIQUE," +
//                "moto_ano TEXT);";
//
//        db.execSQL(sql_moto);
//        db.execSQL(sql_pessoa);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql_pessoa = "DROP TABLE IF EXISTS pessoa;";
//        String sql_moto = "DROP TABLE IF EXISTS moto;";
//
//        db.execSQL(sql_pessoa);
//        db.execSQL(sql_moto);
//        onCreate(db);
//    }
//
//
//
//    public void inserePessoa (Pessoa pessoa){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues dados_pessoa = new ContentValues(); // container de dados
//
//        dados_pessoa.put("pessoa_id", pessoa.getPessoa_id());
//        dados_pessoa.put("pessoa_nome", pessoa.getPessoa_nome());
//        dados_pessoa.put("pessoa_usuario", pessoa.getPessoa_usuario());
//        dados_pessoa.put("pessoa_senha", pessoa.getPessoa_senha());
//
//        db.insert("tb_usuario", null, dados_pessoa);
//        db.close();
//    }
//
//    public void autenticaPessoa(Pessoa pessoa){
//        SQLiteDatabase db = getReadableDatabase();
//        String sql_busca_pessoas = "SELECT * FROM tb_pessoa WHERE pessoa_usuario = " + "'" + pessoa.getPessoa_usuario() + "'";
//        Cursor c = db.rawQuery(sql_busca_pessoas, null);
//        if(c!=null){
//            c.moveToFirst();
//            pessoa.setPessoa_id(Integer.parseInt(c.getString(0)));
//            pessoa.setPessoa_nome(c.getString(1).toString());
//            pessoa.setPessoa_usuario(c.getString(2).toString());
//            pessoa.setPessoa_senha(c.getString(3).toString());
//        }else{
//
//        }
//
//        db.close();
//        c.close();
//    }
//}
