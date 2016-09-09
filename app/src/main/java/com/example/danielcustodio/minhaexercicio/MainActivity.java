package com.example.danielcustodio.minhaexercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBotao;
    private EditText mCampoTextoSenha;
    private EditText mCampoTextoLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoTextoSenha = (EditText) findViewById(R.id.textoSenha);

        mCampoTextoLogin = (EditText) findViewById(R.id.textoLogin);
        //mTexto = (TextView) findViewById(R.id.texto);
        mBotao = (Button) findViewById(R.id.botaoEntrar);
        //mTexto.setText(textoLogin);


        mBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCampoTextoLogin.getText().toString().equals("bunda")
                        && mCampoTextoSenha.getText().toString().equals("123") ) {
                    Toast.makeText(MainActivity.this, "Login Realizado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,TelaPesquisa.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Login Incorreto", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
