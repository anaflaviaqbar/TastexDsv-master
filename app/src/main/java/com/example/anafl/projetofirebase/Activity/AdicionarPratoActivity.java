package com.example.anafl.projetofirebase.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anafl.projetofirebase.Entidades.Prato;
//import com.example.anafl.projetofirebase.Manifest;
import com.example.anafl.projetofirebase.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class AdicionarPratoActivity extends AppCompatActivity {

    private Button btnAddPrato;
    private EditText nomePrato;
    private EditText descPrato;
    private EditText precoPrato;
    private Button mSelectImage;
    private ImageView imageView;
    private Uri filePath;
    private Button  openImage;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser firebaseUser;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_prato);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();

        nomePrato = (EditText) findViewById(R.id.edtNomePrato);
        descPrato = (EditText) findViewById(R.id.edtDescPrato);
        precoPrato = (EditText) findViewById(R.id.edtPrecoPrato);
        openImage = (Button) findViewById(R.id.openImage);


        btnAddPrato = (Button) findViewById(R.id.btnAddPrato);
        btnAddPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewPrato(firebaseUser.getUid());
                Toast.makeText(AdicionarPratoActivity.this, "Prato cadastrado!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        openImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrarImagemIntent = new Intent(AdicionarPratoActivity.this, AdicionarImagem.class);
                startActivity(cadastrarImagemIntent);
            }
        });

  /*  mSelectImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                if (ActivityCompat.checkSelfPermission(AdicionarPratoActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AdicionarPratoActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, GALLERY_INTENT);
                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, GALLERY_INTENT);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }
*/
    }
        public void writeNewPrato (String userId){

            Prato novoPrato = new Prato();

            novoPrato.setIdVendedor(userId);
            novoPrato.setNome(nomePrato.getText().toString());
            novoPrato.setDescricao(descPrato.getText().toString());
            novoPrato.setPreco(Float.parseFloat(precoPrato.getText().toString()));
            novoPrato.setUidPrato(UUID.randomUUID().toString());

            mDatabase.child("pratos").child(novoPrato.getUidPrato()).setValue(novoPrato);

        }
    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults)
    {
        switch (requestCode) {
            case GALLERY_INTENT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, GALLERY_INTENT);
                } else {
                    Toast.makeText(AdicionarPratoActivity.this, "Habilite permissão", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== GALLERY_INTENT && resultCode==RESULT_OK){

            filePath = data.getData();

            StorageReference filepath= mStorage.child("Imagens pratos").child(filePath.getLastPathSegment());
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }catch(IOException e){
                e.printStackTrace();
            }

            filepath.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(AdicionarPratoActivity.this, "Upload feito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }*/
       }