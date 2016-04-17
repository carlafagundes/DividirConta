package com.example.gabriel.dividirconta;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.gabriel.dividirconta.R.id.numPessoas;
import static com.example.gabriel.dividirconta.R.id.valor;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragmento extends Fragment{

    EditText vTotal, qPessoas, vTaxaServico;
    Button botaoCalcular;

    public Menu1Fragmento() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.menu1_fragmento, container, false);

        vTotal = (EditText) getActivity().findViewById(R.id.valor);
        qPessoas = (EditText) getActivity().findViewById(R.id.numPessoas);
        vTaxaServico = (EditText) getActivity().findViewById(R.id.taxaServicos);

        botaoCalcular = (Button) view.findViewById(R.id.btnCalcular);

        //Operação para calcular
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTotal = vTotal.getText().toString();
                String qtdPessoas = qPessoas.getText().toString();
                String valorTaxaServicos = vTaxaServico.getText().toString();

                if (valorTotal.trim().isEmpty()||qtdPessoas.trim().isEmpty() || valorTaxaServicos.trim().isEmpty()) {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
                    dialogo.setTitle("AVISO");
                    dialogo.setMessage("Há dados em branco.");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }else {
                    double valorTotalConta = Double.parseDouble(vTotal.getText().toString());
                    double qtdPessoasConsumidores = Double.parseDouble(qPessoas.getText().toString());
                    double valorTaxaServicosBar = Double.parseDouble(vTaxaServico.getText().toString());

                    double resultado = ((valorTotalConta + valorTaxaServicosBar)/qtdPessoasConsumidores);

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

                    dialogo.setTitle("Valor para cada pessoa:");

                    dialogo.setMessage("R$ " + resultado);

                    dialogo.setNeutralButton("OK", null);

                    dialogo.show();
                }

            }
        });

        return view;

    }

}


