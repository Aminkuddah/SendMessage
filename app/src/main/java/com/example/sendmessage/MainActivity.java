package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity{
    private EditText namaInput;
    private EditText alamatInput;
    private EditText hpInput;
    String nama, alamat, hp;
    String CHANNEL_ID = "my_channel_01";

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        namaInput = findViewById(R.id.nama);
        alamatInput = findViewById(R.id.alamat);
        hpInput= findViewById(R.id.hp);
    }

    public void insertButton(View view) {

        nama= namaInput.getText().toString();
        alamat= alamatInput.getText().toString();
        hp = hpInput.getText().toString();

        final Notification.Builder builder = new Notification.Builder(MainActivity.this)
                .setTicker("TickerTitle")
                .setContentTitle("Data siswa")
                .setContentText("Biodata siswa berhasil ditambahkan")
                .setSmallIcon(R.drawable.ic_launcher_background);

        DatabaseReference newData = mDatabase.child("data").push();
        newData.child("nama").setValue(nama);
        newData.child("alamat").setValue(alamat);
        newData.child("hp").setValue(hp).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
//                System.out.println("Data berhasil ditambahkan");

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, builder.build());

            }
        });
    }
}
