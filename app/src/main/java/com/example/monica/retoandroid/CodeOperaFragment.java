package com.example.monica.retoandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CodeOperaFragment extends Fragment {
    private float contadorfloat;
    private float numerofloat;
    String multi,div,sum,rest,texto;

    public CodeOperaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_code_opera, container, false);
        TextView textView=(TextView) view.findViewById(R.id.codificacion);
        TextView textView1=(TextView) view.findViewById(R.id.operaciones);
        Bundle extras =getArguments();

        String texto1=extras.getString("texto");
        String numero=extras.getString("numero");
        String contador=extras.getString("contador1");

        String texto="TEXTO: "+texto1+"\nContador: "+contador;
        textView.setText(texto);

        numerofloat=Float.parseFloat(numero);
        contadorfloat=Float.parseFloat(contador);

        div=Float.toString(numerofloat / contadorfloat);
        sum=Float.toString(contadorfloat + numerofloat);
        rest=Float.toString(numerofloat - contadorfloat);
        multi=Float.toString(numerofloat * contadorfloat);

        texto="Numero = "+numero+"\n"
                +getString(R.string.suma)+" = "+sum+"\n"
                +getString(R.string.resta)+" = "+rest+"\n"
                +getString(R.string.multiplicacion)+" = "+multi+"\n"
                +getString(R.string.division)+" = "+div;
        textView1.setText(texto);
        return view;
    }

}
