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
public class CodeFragment extends Fragment {


    public CodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_code, container, false);
        TextView textView=(TextView) view.findViewById(R.id.codificacion);


        Bundle extras =getArguments();

        String texto1=extras.getString("texto");
        String contador=extras.getString("contador1");
        String texto="TEXTO: "+texto1+"\nContador: "+contador;
        textView.setText(texto);
        return view;
    }

}
