package com.example.anafl.projetofirebase.Listas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anafl.projetofirebase.Entidades.Prato;
import com.example.anafl.projetofirebase.R;

import org.w3c.dom.Text;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolderPrato> {

    private List<Prato> dados;
    public static ClickRecyclerViewInterfacePrato clickRecyclerViewInterfacePrato;

    public PratoAdapter(List<Prato> dados, ClickRecyclerViewInterfacePrato clickRecyclerViewInterfacePrato){
        this.dados = dados;
        this.clickRecyclerViewInterfacePrato = clickRecyclerViewInterfacePrato;
    }

    @Override
    public PratoAdapter.ViewHolderPrato onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.lista_pratos, parent, false);
        ViewHolderPrato viewHolderPrato = new ViewHolderPrato(itemview);
        return viewHolderPrato;
    }

    @Override
    public void onBindViewHolder(PratoAdapter.ViewHolderPrato holder, int position) {
        Prato prato = dados.get(position);

        holder.txtNomePrato.setText(prato.getNome());
        holder.txtDescricaoPrato.setText(prato.getDescricao());
        holder.txtPrecoPrato.setText(prato.getPreco() + " R$");


    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderPrato extends RecyclerView.ViewHolder{

        public TextView txtNomePrato;
        public TextView txtDescricaoPrato;
        public TextView txtPrecoPrato;


        public ViewHolderPrato(View itemView) {
            super(itemView);


            txtNomePrato = (TextView) itemView.findViewById(R.id.txtNomePrato);
            txtDescricaoPrato = (TextView) itemView.findViewById(R.id.txtDescricaoPrato);
            txtPrecoPrato = (TextView) itemView.findViewById(R.id.txtPrecoPrato);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewInterfacePrato.onCustomClick(dados.get(getLayoutPosition()));
                }
            });
        }


    }
}
