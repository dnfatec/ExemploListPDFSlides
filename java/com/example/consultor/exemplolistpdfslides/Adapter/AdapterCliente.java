package com.example.consultor.exemplolistpdfslides.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.consultor.exemplolistpdfslides.Model.Cliente;
import com.example.consultor.exemplolistpdfslides.R;

import java.util.List;

/**
 * Created by Consultor on 18/07/2018.
 */

public class AdapterCliente extends BaseAdapter {
    private final List<Cliente> clientes;
    private final Activity activity;

    public AdapterCliente(List<Cliente> clientes, Activity minhaActivity) {
        this.clientes = clientes;
        this.activity = minhaActivity;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viewLista = activity.getLayoutInflater().inflate(R.layout.listviewcliente, viewGroup, false);
        Cliente cliente = clientes.get(i);
        TextView id = (TextView)
                viewLista.findViewById(R.id.txtId);
        TextView nome = (TextView)
                viewLista.findViewById(R.id.txtNome);
        TextView endereco = (TextView)
                viewLista.findViewById(R.id.txtEndereco);
        TextView cidade = (TextView)
                viewLista.findViewById(R.id.txtCidade);

        id.setText(String.valueOf(cliente.getId()));
        nome.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
        cidade.setText(cliente.getCidade());
        return viewLista;


    }
}
