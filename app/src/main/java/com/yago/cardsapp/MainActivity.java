package com.yago.cardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //cria a lista
    String[] listaNomes = {
            "Felpufo","Fofura","Lesmo","Bugado",
            "Uruca","Racing","IOS","Android","RealidadeAumentada",
            "Sound FX","3D Studio Max","Games"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //um adapter para converter os itens na lista de acordo com um layout
        ArrayAdapter<String> meuAdapter = new ArrayAdapter<String>
                (getApplicationContext(),android.R.layout.simple_list_item_1
                ,android.R.id.text1,listaNomes);

        ListView listCard = findViewById(R.id.listaCard);
        listCard.setAdapter(meuAdapter);


    }
}
