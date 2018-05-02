package com.example.anafl.projetofirebase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.anafl.projetofirebase.Entidades.Usuario;
import com.example.anafl.projetofirebase.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PaginaVendedor extends AppCompatActivity {


    private String idVendedor;

    private TextView txtNomeVendedor;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_vendedor);

        instanciarFirebase();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idVendedor = bundle.getString("idVendedor");

        txtNomeVendedor =  findViewById(R.id.txtNomeVendedorPagVend);

        lerDadosVendedor();



    }

    private void lerDadosVendedor() {

        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapShot:dataSnapshot.getChildren()){
                    Usuario usuario = objSnapShot.getValue(Usuario.class);

                    if(usuario.getId().equals(idVendedor)){
                        txtNomeVendedor.setText(usuario.getNome());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void instanciarFirebase() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
    }


}
