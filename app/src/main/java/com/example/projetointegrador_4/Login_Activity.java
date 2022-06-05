package com.example.projetointegrador_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
    }

    public void Menu(View view){
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText senha = findViewById(R.id.editTextTextPersonName);
        TextView mensagem = findViewById(R.id.textView6);

        String e = email.getText().toString();
        String s = senha.getText().toString();

        String emailusu = "";
        String nomeusu = "";
        String senhausu = "";

        if (e.length() == 0){
            mensagem.setText("Digite seu E-mail.");
        }else if (s.length() == 0){
            mensagem.setText("Digite sua Senha");
        }else{
            Banco banco = new Banco(this);
            if (banco.VerificaUsuario(e,s) != null) {
                ArrayList<Usuario> listaProva = banco.VerificaUsuario(e,s);
                for (int i=0; i < listaProva.size(); i++) {
                    nomeusu  += listaProva.get(i).getNome() + "\t";
                    emailusu += listaProva.get(i).getEmail() + "\t";
                    senhausu += listaProva.get(i).getEmail() + "\n\n";
                }
                Toast.makeText(this, "Usuário Logado!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,Menu_Activity.class);
                i.putExtra("nome",nomeusu);
                i.putExtra("email",emailusu);
                startActivity(i);
            } else {
                mensagem.setText("Usuário Inválido");
//                Toast.makeText(this, "Usuário inválido!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void Registro(View view){
        Intent i = new Intent(this,Registro_Activity.class);
        startActivity(i);
    }
}