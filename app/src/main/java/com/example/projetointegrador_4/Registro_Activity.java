package com.example.projetointegrador_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        getSupportActionBar().hide();
    }

    public void Login(View view){
        EditText nome = findViewById(R.id.editTextTextPersonName2);
        EditText senha = findViewById(R.id.editTextTextPersonName3);
        EditText email = findViewById(R.id.editTextTextPersonName4);
        TextView mensagem = findViewById(R.id.textView10);

        String n = nome.getText().toString();
        String s = senha.getText().toString();
        String e = email.getText().toString();

        Usuario usu = new Usuario();
        usu.setEmail(email.getText().toString());
        usu.setSenha(senha.getText().toString());
        usu.setNome(nome.getText().toString());

        if (n.length() == 0){
            mensagem.setText("Digite seu Nome");
        }else if(s.length() == 0){
            mensagem.setText("Digite sua Senha");
        }else if(e.length() == 0){
            mensagem.setText("Digite seu E-mail");
        }else{
            Banco banco = new Banco(this);
            if (banco.VerificaRegistro(n,e) == null) {
                if (banco.InsereUsuario(usu) > 0) {
                    Toast.makeText(this, "Usuário Cadastrado", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, Login_Activity.class);
                    startActivity(i);
                } else {
//                mensagem.setText("Não foi possível inserir o Usuário. Tente novamente mais tarde");
                    Toast.makeText(this, "Não foi possível inserir o Usuário. Tente novamente mais tarde", Toast.LENGTH_LONG).show();
                }
            }else{
                mensagem.setText("Usuário já existe!");
            }
        }
    }
}