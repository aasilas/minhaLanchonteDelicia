package com.example.adm.minhalanchonetedelicia;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = DetalheActivity.this.getIntent();
        String produtoNome = "";

        if (intent.hasExtra("produto_nome")) {
            produtoNome = intent.getStringExtra("produto_nome");
        }

        TextView textview = (TextView) this.findViewById(R.id.text_view_name);
        textview.setText(produtoNome);

        String produtoPreço= "";

        String url = "";
        if (intent.hasExtra("produto_url")) {
            url = intent.getStringExtra("produto_url");
            Log.d("Intent",url);
        }
        ImageView imageView = (ImageView) findViewById(R.id.image_view_candy);
        Picasso.with(this).load(url).into(imageView);
    }
}
