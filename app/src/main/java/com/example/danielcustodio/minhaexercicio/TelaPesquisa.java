package com.example.danielcustodio.minhaexercicio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaPesquisa extends AppCompatActivity {

    private GeneroItemRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisa);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        EditText editText = (EditText)findViewById(R.id.textoPesquisa);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    realizarPesquisa();
                    return true;
                }
                return false;
            }
        });

        mAdapter = new GeneroItemRecyclerAdapter(this, obterListaFilmes());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        onItemClicado(position);
                    }
                })
        );

    }

    private void realizarPesquisa(){
        Toast.makeText(this,"Pesquisar alguma coisa",Toast.LENGTH_SHORT).show();
    }

    private class FilmeItem{

        private String nome;
        private float duracao;
        private String urlDaImagemDoFilme;

        public float getDuracao() {
            return duracao;
        }

        public void setDuracao(float duracao) {
            this.duracao = duracao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getUrlDaImagemDoFilme() {
            return urlDaImagemDoFilme;
        }

        public void setUrlDaImagemDoFilme(String urlDaImagemDoFilme) {
            this.urlDaImagemDoFilme = urlDaImagemDoFilme;
        }
    }

    public class GeneroItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageGenero;
        public TextView textGenero;


        public GeneroItemViewHolder(View itemView) {
            super(itemView);
            imageGenero = (ImageView) itemView.findViewById(R.id.imagem_gen_aventura);
            textGenero = (TextView) itemView.findViewById(R.id.text_gen_aventura);
        }

    }

    public class GeneroItemRecyclerAdapter extends RecyclerView.Adapter<GeneroItemViewHolder> {

        private List<FilmeItem> mLista;
        private Context mContext;

        public GeneroItemRecyclerAdapter (Context mContext, List<FilmeItem> mLista){
            this.mLista = mLista;
            this.mContext = mContext;
        }


        public GeneroItemViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genero,parent,false);
            return new GeneroItemViewHolder(layoutView);
        }

        @Override
        public void onBindViewHolder(GeneroItemViewHolder holder, int position) {
            FilmeItem filme = mLista.get(position);
            holder.textGenero.setText(filme.getNome());


        }

        @Override
        public int getItemCount() {
            return mLista.size();
        }

        public FilmeItem getItem(int position){
            return mLista.get(position);
        }

    }


    private List<FilmeItem> obterListaFilmes(){
        List<FilmeItem> lista = new ArrayList<>();

        FilmeItem f = new FilmeItem();
        f.setNome("Açao");

        lista.add(f);

        f = new FilmeItem();
        f.setNome("Aventura");

        lista.add(f);

        f = new FilmeItem();
        f.setNome("Comédia");

        lista.add(f);

        f = new FilmeItem();
        f.setNome("Drama");

        lista.add(f);

        f = new FilmeItem();
        f.setNome("Terror");

        lista.add(f);

        return lista;

    }

    private void onItemClicado(int position){
        Toast.makeText(this,""+mAdapter.getItem(position).getNome(),Toast.LENGTH_SHORT).show();
    }


}