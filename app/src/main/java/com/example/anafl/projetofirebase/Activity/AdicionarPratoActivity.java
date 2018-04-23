package com.example.anafl.projetofirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anafl.projetofirebase.Entidades.Prato;
import com.example.anafl.projetofirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdicionarPratoActivity extends AppCompatActivity {

    private Button btnAddPrato;
    private EditText nomePrato;
    private EditText descPrato;
    private EditText precoPrato;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_prato);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseUser = mAuth.getCurrentUser();


        nomePrato = (EditText) findViewById(R.id.edtNomePrato);
        descPrato = (EditText) findViewById(R.id.edtDescPrato);
        precoPrato = (EditText) findViewById(R.id.edtPrecoPrato);

        btnAddPrato = (Button) findViewById(R.id.btnAddPrato) ;
        btnAddPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewPrato(firebaseUser.getUid());
                Toast.makeText(AdicionarPratoActivity.this, "Prato cadastrado!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }

    public void writeNewPrato(String userId){

        Prato novoPrato = new Prato();

        novoPrato.setIdVendedor(userId);
        novoPrato.setNome(nomePrato.getText().toString());
        novoPrato.setDescricao(nomePrato.getText().toString());
        novoPrato.setPreco(Float.parseFloat(precoPrato.getText().toString()));

        mDatabase.child("pratos").push().setValue(novoPrato);

    }
}
