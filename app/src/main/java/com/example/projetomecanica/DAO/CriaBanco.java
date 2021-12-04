package com.example.projetomecanica.DAO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    // Dados gerais da base de dados
    public static final String BANCO_MECANICA = "banco.db";

    // Versionamento banco de dados
    public static final int VERSAO = 19;

    // Dados tabela do usúario
    public static final String TABELA = "pessoa";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String USUARIO = "username";
    public static final String SENHA = "senha";
    public static final String ISADMINISTRATOR = "isAdministrator";
    public static final String ISACTIVE = "isActive";

    // Dados tabela do veiculo
    public static final String TABELA_VEICULO = "veiculo";
    public static final String ID_VEICULO = "_id";
    public static final String APELIDO_VEICULO = "apelido";
    public static final String MARCA_VEICULO = "marca";
    public static final String MODELO_VEICULO = "modelo";
    public static final String PLACA_VEICULO = "placa";
    public static final String ANO_VEICULO = "ano";
    public static final String QUILOMETRAGEM_VEICULO = "quilometragem";
    public static final String ID_PESSOA = "id_pessoa";

    // Dados tabela da mecanica
    public static final String TABELA_MECANICA = "mecanica";
    public static final String ID_MECANICA = "_id";
    public static final String NOME_MECANICA = "nome";
    public static final String ENDERECO_MECANICA = "endereco";
    public static final String ATENDIMENTO_MECANICA = "atendimento";

    // Dados tabela
    public static final String TABELA_CHAMADOS = "chamados";
    public static final String DESCRICAO_CHAMADO = "descricao";
    public static final String ID_CHAMADO = "_id";
    public static final String ID_PESSOA_CHAMADO = "id_pessoa_chamado";
    public static final String ID_MOTO = "id_moto";

    public CriaBanco(Context context){
        super(context, BANCO_MECANICA, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Criando tabela do usuário
        String QUERY_COLUNA = "CREATE TABLE " + TABELA +" ("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME + " TEXT,"
                + USUARIO + " TEXT UNIQUE,"
                + SENHA + " TEXT,"
                + ISADMINISTRATOR + " BOOLEAN, "
                + ISACTIVE + " BOOLEAN"
                +")";

        // Criando tabela do veículo
        String CRIAR_TABELA_VEICULOS = "CREATE TABLE " + TABELA_VEICULO + "("
                + ID_VEICULO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + APELIDO_VEICULO + " TEXT, "
                + MARCA_VEICULO + " TEXT, "
                + MODELO_VEICULO + " TEXT, "
                + PLACA_VEICULO + " TEXT UNIQUE,"
                + ANO_VEICULO + " TEXT, "
                + QUILOMETRAGEM_VEICULO + " TEXT, "
                + ID_PESSOA + " INTEGER,"
                + " FOREIGN KEY  (" + ID_PESSOA + ") REFERENCES " + TABELA + "(_id)"
                + ")";

        // Criando a tabela de mecanica
        String CRIAR_TABELA_MECANICA = "CREATE TABLE " + TABELA_MECANICA + "("
                + ID_MECANICA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_MECANICA + " TEXT, "
                + ENDERECO_MECANICA + " TEXT, "
                + ATENDIMENTO_MECANICA + " TEXT)";

        // Criando a tabela de chamado
        String CRIAR_TABELA_CHAMADO = "CREATE TABLE " + TABELA_CHAMADOS + "("
                + ID_CHAMADO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DESCRICAO_CHAMADO + " TEXT,"
                + ID_PESSOA_CHAMADO + " INTEGER, "
                + ID_MOTO + " INTEGER, "
                + " FOREIGN KEY (" + ID_MOTO + ") REFERENCES " + TABELA_VEICULO + "(" + ID_VEICULO + "),"
                + " FOREIGN KEY (" + ID_PESSOA_CHAMADO + ") REFERENCES " + TABELA + "(" + ID + ")"
                + ")";


        db.execSQL(CRIAR_TABELA_MECANICA);
        db.execSQL(QUERY_COLUNA);
        db.execSQL(CRIAR_TABELA_VEICULOS);
        db.execSQL(CRIAR_TABELA_CHAMADO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        String sql2 = "DROP TABLE IF EXISTS " + TABELA_VEICULO;
        String sql3 = "DROP TABLE IF EXISTS " + TABELA_MECANICA;
        String sql4 = "DROP TABLE IF EXISTS " + TABELA_CHAMADOS;
        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        onCreate(db);
    }

}
