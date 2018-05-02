package com.example.anafl.projetofirebase.Activity;

import android.content.Intent;
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

public class EditarPrato extends AppCompatActivity {


    private DatabaseReference mDatabaseReference;

    private String uid;


    private String nomePrato;
    private String descPrato;
    private float precoPrato;
    private String idVendedor;
    private String uidPrato;

    private EditText edtNomePrato;
    private EditText edtDescPrato;
    private EditText edtPrecoPrato;
    //private EditText edtIdVendedorPrato;

    private Button excluirPrato;
    private Button editarPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_prato);

        //instanciarFirebase();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        nomePrato = bundle.getString("nome");
        descPrato = bundle.getString("descricao");
        precoPrato = bundle.getFloat("preco");
        idVendedor = bundle.getString("idVendedor");
        uidPrato = bundle.getString("uidPrato");

        edtNomePrato = (EditText)findViewById(R.id.edtNomePratoEditAct);
        edtNomePrato.setText(nomePrato);
        edtDescPrato = (EditText)findViewById(R.id.edtDescPratoEditAct);
        edtDescPrato.setText(descPrato);
        edtPrecoPrato = (EditText)findViewById(R.id.edtPrecoPratoEditAct);
        edtPrecoPrato.setText(precoPrato + "");
        //edtIdVendedorPrato = (EditText)findViewById(R.id.edtIdVendedorEditAct);
        //edtIdVendedorPrato.setText(idVendedor);


        excluirPrato = (Button)findViewById(R.id.btnExcluirPrato);
        excluirPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference.child("pratos").child(uidPrato).removeValue();
                Toast.makeText(EditarPrato.this, "Prato foi excluído!", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        editarPrato = (Button)findViewById(R.id.btnEditarPrato);
        editarPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Prato pratoEditado = new Prato();

                pratoEditado.setUidPrato(uidPrato);
                pratoEditado.setNome(edtNomePrato.getText().toString());
                pratoEditado.setDescricao(edtDescPrato.getText().toString());
                pratoEditado.setPreco(Float.parseFloat(edtPrecoPrato.getText().toString()));
                //pratoEditado.setIdVendedor(edtIdVendedorPrato.getText().toString());

                mDatabaseReference.child("pratos").child(uidPrato).setValue(pratoEditado);

                Toast.makeText(EditarPrato.this, "Prato editado!", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void instanciarFirebase(){
        uid = null;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            uid = user.getUid();
        }
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }
}
