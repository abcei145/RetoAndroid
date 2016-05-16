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
public class OperaFragment extends Fragment {

    private float contadorfloat;
    private float numerofloat;
    String multi,div,sum,rest,texto;
    public OperaFragment() {
        numerofloat=1;
        contadorfloat=1;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_opera, container, false);
        TextView textView=(TextView) view.findViewById(R.id.operaciones);


        Bundle extras =getArguments();

        String numero=extras.getString("numero");
        String contador=extras.getString("contador");
        numerofloat=Float.parseFloat(numero);
        contadorfloat=Float.parseFloat(contador);

        div=Float.toString(numerofloat / contadorfloat);
        sum=Float.toString(contadorfloat + numerofloat);
        rest=Float.toString(numerofloat - contadorfloat);
        multi=Float.toString(numerofloat * contadorfloat);

        texto= "Numero = "+numero+"\n"
                +getString(R.string.suma)+" = "+sum+"\n"
                +getString(R.string.resta)+" = "+rest+"\n"
                +getString(R.string.multiplicacion)+" = "+multi+"\n"
                +getString(R.string.division)+" = "+div;
        textView.setText(texto);

        return view;
    }

}
