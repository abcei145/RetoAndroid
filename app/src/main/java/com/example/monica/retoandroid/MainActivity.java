package com.example.monica.retoandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText texto;
    TextView numingresos;
    Button ingresar;
    int ingresos=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=(EditText) findViewById(R.id.texto);
        numingresos=(TextView) findViewById(R.id.numingresos);

        ingresar=(Button) findViewById(R.id.ingresar);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        int r=sharedPref.getInt("ingresos",-1);
        if(r==-1){
            editor.putInt("ingresos",1);
            editor.commit();
            numingresos.setText(Integer.toString(1));
            ingresos=1;
        }
        else{
            editor.putInt("ingresos",r+1);
            editor.commit();
            numingresos.setText(Integer.toString(r));
            ingresos=r;
        }
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(texto.getText().toString().isEmpty()){

                    CharSequence text = "No deje el espacio en blanco antes de ingresar...";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(MainActivity.this,text,duration).show();
                    
                }
                else {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("texto", texto.getText().toString());
                    i.putExtra("contador", Integer.toString(ingresos));
                    startActivity(i);
                }
            }
        });
    }

}
