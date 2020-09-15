package com.example.example_fin_model1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText E, S, HX, VH, P, SAL,ST;
    Button C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E = findViewById(R.id.empleado);
        S = findViewById(R.id.salario);
        HX = findViewById(R.id.horasextra);
        VH = findViewById(R.id.valorhora);
        P = findViewById(R.id.pension);
        SAL = findViewById(R.id.salud);
        ST=findViewById(R.id.salariototal);
        C = findViewById(R.id.btncalcular);


        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(E.getText().toString()) || TextUtils.isEmpty(S.getText().toString()) || TextUtils.isEmpty(HX.getText().toString()) || TextUtils.isEmpty(VH.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();


                } else {
                    String a= S.getText().toString();
                    double sa=Double.parseDouble(a);
                    String b= HX.getText().toString();
                    Double hx=Double.parseDouble(b);
                    String c=VH.getText().toString();
                    Double vh=Double.parseDouble(c);
                    double phx=hx*vh;
                    double salariobruto=sa+phx;
                    double pension=salariobruto*0.4;
                    double salud=salariobruto*0.4;
                    double ps=pension+salud;
                    double total=salariobruto-ps;

                    ST.setText(String.valueOf(total));
                    P.setText(String.valueOf(pension));
                    SAL.setText(String.valueOf(salud));


                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:

                String costS = "840.900";
                S.setText(costS);

                break;
            case R.id.item2:
                E.setText("");
                S.setText("");
                HX.setText("");
                VH.setText("");
                P.setText("");
                SAL.setText("");
                ST.setText("");
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onClick(View view) {

    }
}