package com.example.consultor.exemplolistpdfslides.View;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.consultor.exemplolistpdfslides.Adapter.AdapterCliente;
import com.example.consultor.exemplolistpdfslides.Model.Cliente;
import com.example.consultor.exemplolistpdfslides.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listaDeClientes = (ListView) findViewById(R.id.lstCliente);

        List<Cliente> clientes = preecheClientes();

        AdapterCliente adapter =  new AdapterCliente(clientes, this);

        listaDeClientes.setAdapter(adapter);
        geraPDF(adapter);

    }

    private List <Cliente> preecheClientes()
    {
        return new ArrayList<>(Arrays.asList(
                new Cliente(1, "José da Silva", "Rua José Hernandes","Taquarivai"),
                new Cliente(2, "Silva Jose", "Rua José Hernandes","Bernardino de Campos"),
                new Cliente(3, "Maria José ", "Rua José Hernandes","Paulicéia"),
                new Cliente(4, "Josenildo Murie", "Rua José Hernandes","Piraí")
        )
      );
    }



    private void geraPDF(AdapterCliente ad)
    {
        int i=0;

        PdfDocument documento = new PdfDocument();


        PdfDocument.PageInfo pageInfo =
                new PdfDocument.PageInfo.Builder(595, 842, 1).create();

        PdfDocument.Page page = documento.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();

        while (i<ad.getCount()) {
            Cliente cliente =(Cliente)ad.getItem(i);
            canvas.drawText(cliente.getNome().toString() + " Endereço: " + cliente.getEndereco().toString()  , 0, ((i+10)*10), paint);
            i++;
        }

        documento.finishPage(page);

        pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 2).create();
        page = documento.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        i=0;
        while (i<ad.getCount()) {
            Cliente cliente =(Cliente)ad.getItem(i);
            canvas.drawText(cliente.getNome().toString() + " Endereço: " + cliente.getEndereco().toString()  , 0, ((i+10)*10), paint);
            i++;
        }

        documento.finishPage(page);

        File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            try {
            documento.writeTo(new FileOutputStream(filePath+"/SeuArquivo.pdf"));
            Toast.makeText(this, "Arquivo PDF Gerado", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao gravar arquivo: " + e.toString(),
                    Toast.LENGTH_LONG).show();
        }
        documento.close();

    }

}
