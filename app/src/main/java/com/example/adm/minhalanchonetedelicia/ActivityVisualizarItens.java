package com.example.adm.minhalanchonetedelicia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityVisualizarItens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualisar_itens);

        Item item = (Item) getIntent().getSerializableExtra("Item");

        ImageView imagem = (ImageView)
                findViewById(R.id.imagemItem);
        TextView nomeItem = (TextView)
                findViewById(R.id.nomeItem);
        TextView valorItem = (TextView)
                findViewById(R.id.valorItem);
        TextView descricaoItem = (TextView)
                findViewById(R.id.descricaoItem);

        nomeItem.setText(item.getNome());
        valorItem.setText(item.getValor());
        descricaoItem.setText(item.getDescricao());
        Categoria categoria = item.getCategoria();
        if (categoria.equals(Categoria.SUCOONDATROPICAL)) {
            imagem.setImageResource(R.drawable.suco_tropical);
        } else if (categoria.equals(Categoria.VITAMINAPLANETARIA)) {
            imagem.setImageResource(R.drawable.vitamina_planetaria);
        } else if (categoria.equals(Categoria.HAMBURGUEREXAGERADO)) {
            imagem.setImageResource(R.drawable.hamburguer_exagerado);
        } else if (categoria.equals(Categoria.PASTELSUPER)) {
            imagem.setImageResource(R.drawable.pastel_super);
        } else if (categoria.equals(Categoria.EMPADAOLHOGRANDE)) {
            imagem.setImageResource(R.drawable.empada_grande);
        } else if (categoria.equals(Categoria.BOLIVIADOQUENTE)) {
            imagem.setImageResource(R.drawable.boliviano);
        }else if (categoria.equals(Categoria.QUIBEPOP)) {
            imagem.setImageResource(R.drawable.quibe);
        }else if (categoria.equals(Categoria.ESFIRRADOSABOR)) {
            imagem.setImageResource(R.drawable.esfirra);
        }else if (categoria.equals(Categoria.CREPIOCASABOROSA)) {
            imagem.setImageResource(R.drawable.crepioca);
        }else if (categoria.equals(Categoria.PAODENUVEM)) {
            imagem.setImageResource(R.drawable.pao_de_nuvem);
        }else if (categoria.equals(Categoria.BRUSCHETTAINTEGRAL)) {
            imagem.setImageResource(R.drawable.bruschetta);
        }
    }
}
