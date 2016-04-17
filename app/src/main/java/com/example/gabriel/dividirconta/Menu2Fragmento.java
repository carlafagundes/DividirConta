package com.example.gabriel.dividirconta;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2Fragmento extends Fragment {

    EditText edvalor, ednumero, edgorjeta;
    Button btncalcular;

    public Menu2Fragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu2_fragmento, container, false);

        edvalor = (EditText) view.findViewById(R.id.edvalor);
        ednumero = (EditText) view.findViewById(R.id.ednumero);
        edgorjeta = (EditText) view.findViewById(R.id.edgorjeta);

        btncalcular = (Button) view.findViewById(R.id.btncalcular);

        //Operação para calcular
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = edvalor.getText().toString();
                String v2 = ednumero.getText().toString();
                String v3 = edgorjeta.getText().toString();

                if (v1.trim().isEmpty()||v2.trim().isEmpty() || v3.trim().isEmpty()) {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
                    dialogo.setTitle("AVISO");
                    dialogo.setMessage("Há dados em branco.");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }else {
                    double num1 = Double.parseDouble(edvalor.getText().toString());
                    double num2 = Double.parseDouble(ednumero.getText().toString());
                    double num3 = Double.parseDouble(edgorjeta.getText().toString());

                    double resultado = (num1 + num3)/num2;

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
