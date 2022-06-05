package com.example.projetointegrador_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {
    public Banco(@Nullable Context context) {
        super(context, "projeto", null, 1);
    }

    public long InsereUsuario(Usuario usuario) {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nome",usuario.getNome());
        registro.put("email", usuario.getEmail());
        registro.put("senha", usuario.getSenha());
        long id = banco.insert("usuario", null, registro);
        banco.close();
        return id;
    }

    public ArrayList<Usuario> VerificaUsuario(String email, String senha) {
        SQLiteDatabase banco = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario where email ="+"'"+email+"'"+" AND SENHA = "+"'"+senha+"'";
        ArrayList<Usuario> resultado = null;

        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            resultado = new ArrayList<Usuario>();
            do {
                Usuario u = new Usuario();
                u.setNome(c.getString(1));
                u.setEmail(c.getString(2));
                u.setSenha(c.getString(3));
                resultado.add(u);
            } while (c.moveToNext());
        }
        banco.close();
        return resultado;
    }

    public ArrayList<Usuario> VerificaRegistro(String nome, String email) {
        SQLiteDatabase banco = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario where nome ="+"'"+nome+"'"+" AND email = "+"'"+email+"'";
        ArrayList<Usuario> resultado = null;

        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            resultado = new ArrayList<Usuario>();
            do {
                Usuario u = new Usuario();
                u.setNome(c.getString(1));
                u.setEmail(c.getString(2));
                u.setSenha(c.getString(3));
                resultado.add(u);
            } while (c.moveToNext());
        }
        banco.close();
        return resultado;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        String sql = "CREATE TABLE USUARIO(" +
                     "CODIGO INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "NOME TEXT," +
                     "EMAIL TEXT,"+
                     "SENHA TEXT)";
        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
