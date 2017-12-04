package com.example.adm.minhalanchonetedelicia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Produto[] produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        final ArrayList<String> produtoList = new ArrayList<String>();

        produtoList.add("Suco Onda Tropical");
        produtoList.add("Vitamina Planetaria");
        produtoList.add("Hamburguer Exagerado");
        produtoList.add("Pastel Super");
        produtoList.add("Empada Olho Grande");
        produtoList.add("Boliviano Quente");
        produtoList.add("Quibe POP");
        produtoList.add("Esfirra do Sabor");
        produtoList.add("Crepioca Saborosa");
        produtoList.add("Pao de Nuvem");
        produtoList.add("Bruschetta Integral");
        produtoList.add("Banana chips");
        produtoList.add("Sopa Funcional");
        produtoList.add("Sanduiche Natureba");
        produtoList.add("Salada  Surpresa");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.item_produto_lista,
                R.id.text_view_produto,
                produtoList
        );

        ListView listView = (ListView) this.findViewById(R.id.list_view_produtos);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalheActivity = new Intent(MainActivity.this, DetalheActivity.class);
                detalheActivity.putExtra("produto_nome", produtos[i].getNome());
                detalheActivity.putExtra("produto_preco", produtos[i].getPreco());
                detalheActivity.putExtra("produto_desc", produtos[i].getDescricao());
                detalheActivity.putExtra("produto_url", produtos[i].getImagem());

                startActivity(detalheActivity);
            }
        });
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://patra-backend.appspot.com/produtos",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "onFailure response = " + responseString);
                        Log.d("AsyncHttpClient", throwable.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "onSuccess response = " + responseString);
                        Gson gson = new GsonBuilder().create();
                        produtos = gson.fromJson(responseString, Produto[].class);
                        adapter.clear();
                        for (Produto produto : produtos) {
                            adapter.add(produto.getNome());
                        }
                    }
                });

    }
}
