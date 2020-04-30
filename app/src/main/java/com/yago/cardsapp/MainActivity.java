package com.yago.cardsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yago.cardsapp.model.DadosPersonagens;

public class MainActivity extends AppCompatActivity {

    //cria a lista
    String[] listaNomes = {
            "Felpufo","Fofura","Lesmo","Bugado",
            "Uruca","Racing","IOS","Android","RealidadeAumentada",
            "Sound FX","3D Studio Max","Games"};

    int[] listaIcones = {R.drawable.felpudo, R.drawable.fofura, R.drawable.lesmo, R.drawable.bugado,
            R.drawable.uruca,R.drawable.carrinho, R.drawable.ios, R.drawable.android, R.drawable.realidade_aumentada,
            R.drawable.sound_fx, R.drawable.max, R.drawable.games};

    String[] listaDescricoes = {
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
            "Este são os personagens do curso de Android de reciclagem do Yago","Este são os personagens do curso de Android de reciclagem do Yago",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //criando o Objeto
        final Adapter adapter;
        adapter = new Adapter(getApplicationContext(),R.layout.minha_celula);
        ListView listCard = findViewById(R.id.listaCard);

        int i=0;
        for(String nome:listaNomes){
            DadosPersonagens dadosPersonagens;
            dadosPersonagens = new DadosPersonagens(listaIcones[i],nome,listaDescricoes[i]);
            adapter.add(dadosPersonagens);
            i++;
        }

        listCard.setAdapter(adapter);

        //evento de clique
        listCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                    DadosPersonagens dadosPersonagens;
                    //recebo o item clicado
                    dadosPersonagens = (DadosPersonagens) adapter.getItem(i);

                    //seto no alerta
                    criaAlerta(dadosPersonagens);
            }
        });

        }
        void criaAlerta(DadosPersonagens dadosPersonagens){

            AlertDialog.Builder meuAlerta;
            meuAlerta = new AlertDialog.Builder(MainActivity.this);

            meuAlerta.setTitle(dadosPersonagens.getTitulo());
            meuAlerta.setMessage(dadosPersonagens.getDescricao());
            //para fechar o dialog
            meuAlerta.setCancelable(true);
            meuAlerta.setIcon(dadosPersonagens.getIcone());

            meuAlerta.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Confirma!", Toast.LENGTH_SHORT).show();
                }
            });

            //para exibir o alerta
            meuAlerta.create();
            meuAlerta.show();

        }
    }

