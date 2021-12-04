package com.example.projetomecanica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetomecanica.DAO.ControlaBanco;
import com.example.projetomecanica.objetos.Chamados;
import com.example.projetomecanica.objetos.Mecanica;
import com.example.projetomecanica.objetos.Usuario;
import com.example.projetomecanica.objetos.Veiculo;


public class MainActivity extends AppCompatActivity {

    EditText login_usuario;
    EditText senha_usuario;
    Button botao_login;

    ControlaBanco db = new ControlaBanco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_usuario = findViewById(R.id.login_usuario);
        senha_usuario = findViewById(R.id.senha_usuario);
        botao_login = findViewById(R.id.botao_login);


        Usuario menor = new Usuario("joao", "menor", "123", false);
        db.insereDadoUsuario(menor);

////
////
//        Mecanica mecanica = new Mecanica("Mecanica do marcos", "Avenida Itatiaia, 116", "Seg-Sab das 09:00 as 18:00");
//        db.insereDadoMecanica(mecanica);
//
//        Mecanica mecanica1 = new Mecanica("Mecanica do joao", "Rua Ramos de azevedo, 423", "Seg-Sex das 07:00 as 19:00");
//        db.insereDadoMecanica(mecanica1);
//
//        Mecanica mecanica2 = new Mecanica("Mecanica do Ze", "Avenida independencia, 1120", "Seg-Sex das 08:00 as 18:00");
//        db.insereDadoMecanica(mecanica2);




        botao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean resultado = db.autenticaPessoa(login_usuario.getText().toString(), senha_usuario.getText().toString());
                if (resultado == true) {
                    Usuario user = db.getUsuario(login_usuario.getText().toString());
                    Log.d("entrounoif", "entrou no IF");
                    Toast toast = Toast.makeText(getApplicationContext(), "ID usuário: " + user.getId() + " - Nome usuário: " + user.getNome(), Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(getApplicationContext(), TicketActivity.class);
                    intent.putExtra("usuario", user);
                    startActivity(intent);
                } else {
                    senha_usuario.setText("");
                    login_usuario.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });


    }
}
