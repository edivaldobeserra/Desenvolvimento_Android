package devandroid.edivaldo.controledeestoque;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.MyviewHolder> {
    private List<Produto> produtoList;
    private onClick onClick;


    public AdapterProduto(List<Produto> produtoList, onClick onClick) {
        this.produtoList = produtoList;
        this.onClick = onClick;
    }

    //PASSAR O LAYOUT NA CLASSE onCreateViewHolder.
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto,parent,false);
        return new MyviewHolder(itemView);
    }
    //PASSAR OS DADOS DOS PRODUTOS.
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Produto produto = produtoList.get(position);

        holder.textProduto.setText(produto.getNome());
        holder.textEstoque.setText("Estoque: " + produto.getEstoque());
        holder.textValor.setText("R$ "+ produto.getValor());

        holder.itemView.setOnClickListener(View ->onClick.onClickListener(produto));

    }
    //RETORNAR A QUANTIDADE DE PRODUTOS.
    @Override
    public int getItemCount() {

        return produtoList.size();
    }

    public interface onClick{
        void onClickListener(Produto produto);

    }

    static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView textEstoque, textValor, textProduto;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            textEstoque = itemView.findViewById(R.id.text_estoque);
            textProduto = itemView.findViewById(R.id.text_poduto);
            textValor = itemView.findViewById(R.id.text_valor);
        }
    }
}
