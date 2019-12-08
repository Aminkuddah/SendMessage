package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText namaInput;
    private EditText alamatInput;
    private EditText hpInput;
    String nama, alamat, hp;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namaInput = findViewById(R.id.nama);
        alamatInput = findViewById(R.id.alamat);
        hpInput= findViewById(R.id.hp);
    }

    public void insertButton(View view) {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        nama= namaInput.getText().toString();
        alamat= alamatInput.getText().toString();
        hp = hpInput.getText().toString();

        DatabaseReference newData = mDatabase.child("data").push();
        newData.child("nama").setValue(nama);
        newData.child("alamat").setValue(alamat);
        newData.child("hp").setValue(hp);
    }

//    public void alertButton(View view) {
//        nama= namaInput.getText().toString();
//        alamat= alamatInput.getText().toString();
//        hp = hpInput.getText().toString();
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                this);
//
//        // set title dialog
//        alertDialogBuilder.setTitle("Data siswa");
//
//        // set pesan dari dialog
//        alertDialogBuilder
//                .setMessage("Nama : " + nama + "\nAlamat : "+ alamat +"\nhandphone : "+hp)
//                .setCancelable(false)
//                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        MainActivity.this.finish();
//                    }
//                })
//                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        // membuat alert dialog dari builder
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // menampilkan alert dialog
//        alertDialog.show();
//    }
}
