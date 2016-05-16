package com.example.monica.retoandroid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String numero;
    String textoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i,caso1=0,caso2=0;
        float contadorfloat,numerofloat;
        setContentView(R.layout.activity_main2);
        Bundle extras =getIntent().getExtras();
        String texto=(extras.getString("texto"));
        String contador=(extras.getString("contador"));
        contadorfloat=Integer.parseInt(contador);
        numero="";
        textoin="";
        char[] tex= texto.toCharArray();
        for (i=0;i<texto.length();i++){
            if(Character.isDigit(texto.charAt(i)))
                numero=numero.concat( Character.toString(texto.charAt(i)));
            else
                textoin=textoin.concat(Character.toString(texto.charAt(i)));
        }
        Fragment fragment;

        if(numero.length()>0)
            caso1=1;
        if(textoin.length()>0)
            caso1=2;
        if(textoin.length()>0 && numero.length()>0)
            caso1=3;

        Bundle args=new Bundle();
        switch(caso1) {
            case 1:
                    fragment = new OperaFragment();
                    numerofloat = Float.parseFloat(numero);

                    args.putString("numero", Float.toString(numerofloat));
                    args.putString("contador", Float.toString(contadorfloat));
                    fragment.setArguments(args);
                    break;

            case 2:
                    fragment = new CodeFragment();
                    args.putString("texto", textoin);
                    args.putString("contador1", Float.toString(contadorfloat));
                    fragment.setArguments(args);
                    break;
            case 3:
                    fragment = new CodeOperaFragment();
                    numerofloat = Float.parseFloat(numero);
                    args.putString("texto", textoin);
                    args.putString("numero", Float.toString(numerofloat));
                    args.putString("contador1", Float.toString(contadorfloat));
                    fragment.setArguments(args);
                    break;
            default:
                    fragment=new CodeFragment();
                    break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

    }
/*
    @Override
    protected void onResume() {
        int i,caso1=0,caso2=0;
        float contadorfloat,numerofloat;
        Bundle extras =getIntent().getExtras();
        String texto=(extras.getString("texto"));
        String contador=(extras.getString("contador"));
        contadorfloat=Integer.parseInt(contador);
        numero="";
        textoin="";
        char[] tex= texto.toCharArray();
        for (i=0;i<texto.length();i++){
            if(Character.isDigit(texto.charAt(i)))
                numero=numero.concat( Character.toString(texto.charAt(i)));
            else
                textoin=textoin.concat(Character.toString(texto.charAt(i)));
        }
        Fragment fragment;

        if(numero.length()>0)
            caso1=1;
        if(textoin.length()>0)
            caso1=2;
        if(textoin.length()>0 && numero.length()>0)
            caso1=3;
        switch(caso1) {
            case 1:
                Bundle args=new Bundle();
                fragment = new OperaFragment();
                numerofloat = Float.parseFloat(numero);

                args.putString("numero", Float.toString(numerofloat));
                args.putString("contador", Float.toString(contadorfloat));
                fragment.setArguments(args);
                break;

            case 2:
                fragment=new CodeFragment();
                break;
            default:
                fragment=new CodeFragment();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        super.onResume();
    }*/

}
