package com.example.aulasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //Criar o banco de dados
            SQLiteDatabase bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR," + " idade int(3))");

            //inserindo dados na tabela
            bancodedados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 17)");
            bancodedados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Thiaguin', 18)");

            //recuperar dados
            String consulta = "SELECT nome, idade FROM pessoas";
            Cursor cursor = bancodedados.rawQuery(consulta, null);
//        Cursor cursor = bancodedados.rawQuery("SELECT nome, idade FROM pessoas", null);

            //indices de tabelas
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            String nome;
            int idade;
            while (cursor != null){
                nome = cursor.getString(indiceNome);
                idade = cursor.getInt(indiceIdade);
                Log.i("Resultado - Nome: ", nome);
                Log.i("Resultado - Idade: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}