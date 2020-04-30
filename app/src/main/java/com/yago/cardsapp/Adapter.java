package com.yago.cardsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yago.cardsapp.model.DadosPersonagens;
import com.yago.cardsapp.view.ViewPersonagem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter {
    //funcao basica do adapter
    public Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull

    //retorna o objeto que é usado
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        //importo da classe view
        ViewPersonagem viewPersonagem;

        if (convertView == null){
            //traz o xml criado
            LayoutInflater inflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula,parent,false);

            //instancia uma view de personagem
            viewPersonagem = new ViewPersonagem();
            viewPersonagem.icone = (ImageView) minhaView.findViewById(R.id.imgIcone);
            ViewPersonagem.titulo = (TextView) minhaView.findViewById(R.id.txtTitulo);
            ViewPersonagem.descricao = (TextView) minhaView.findViewById(R.id.txtDescricao);

            minhaView.setTag(viewPersonagem);
        }else{
            viewPersonagem = (ViewPersonagem) minhaView.getTag();
        }

        DadosPersonagens dadosPersonagens;
        dadosPersonagens = (DadosPersonagens) this.getItem(position);

        //pega as informações do Model
        viewPersonagem.icone.setImageResource(dadosPersonagens.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagens.getTitulo());
        viewPersonagem.descricao.setText(dadosPersonagens.getDescricao());

        return minhaView;

    }
}
