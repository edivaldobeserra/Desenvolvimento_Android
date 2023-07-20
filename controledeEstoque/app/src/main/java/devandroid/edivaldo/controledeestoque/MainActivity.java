package devandroid.edivaldo.controledeestoque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.tsuryo.swipeablerv.SwipeLeftRightCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterProduto.onClick {
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();
    private RecyclerView rvEstoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEstoque = findViewById(R.id.rvEstoque);

        carregaLista();
        configRecyclerView();
    }
    private void configRecyclerView(){
        rvEstoque.setLayoutManager(new LinearLayoutManager(this));
        rvEstoque.setHasFixedSize(true);
        adapterProduto = new AdapterProduto(produtoList,this);
        rvEstoque.setAdapter(adapterProduto);

        rvEstoque.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onSwipedRight(int position) {
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
    private void carregaLista(){

        Produto produto1 = new Produto();
        produto1.setNome("Ogro 40 ");
        produto1.setEstoque(12);
        produto1.setValor(1342.99);

        Produto produto2 = new Produto();
        produto2.setNome("Ogro 35 ");
        produto2.setEstoque(12);
        produto2.setValor(1342.99);

        Produto produto3 = new Produto();
        produto3.setNome("Ogro 60 ");
        produto3.setEstoque(8);
        produto3.setValor(1342.99);

        Produto produto4 = new Produto();
        produto4.setNome("Ignotante 5");
        produto4.setEstoque(4);
        produto4.setValor(1342.99);

        Produto produto5 = new Produto();
        produto5.setNome("Ogro 40 ");
        produto5.setEstoque(12);
        produto5.setValor(1342.99);

        Produto produto6 = new Produto();
        produto6.setNome("sem limitess ");
        produto6.setEstoque(2);
        produto6.setValor(1342.99);

        produtoList.add(produto1);
        produtoList.add(produto2);
        produtoList.add(produto3);
        produtoList.add(produto4);
        produtoList.add(produto5);
        produtoList.add(produto6);
        produtoList.add(produto1);
        produtoList.add(produto2);
        produtoList.add(produto3);
        produtoList.add(produto4);
        produtoList.add(produto5);
        produtoList.add(produto6);


    }

    @Override
    public void onClickListener(Produto produto) {
        Toast.makeText(this,produto.getNome(), Toast.LENGTH_SHORT).show();
        
    }
}