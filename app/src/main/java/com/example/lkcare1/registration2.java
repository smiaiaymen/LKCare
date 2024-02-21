package com.example.lkcare1;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration2 extends AppCompatActivity {
    private EditText name;
    private EditText c_i_n1;
    private EditText phone1;
    private Button rgstr1;
    private FirebaseDatabase firebaseDatabase1 ;


    private DatabaseReference databaseReference1 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        setTitle("ajouter une infirmière");
        firebaseDatabase1 = FirebaseDatabase.getInstance();
        databaseReference1  = firebaseDatabase1.getReference();
        name = findViewById(R.id.etNom1);
        c_i_n1 = findViewById(R.id.etcin1);
        phone1 = findViewById(R.id.etphone1);
        rgstr1 = findViewById(R.id.rgstrbtn1);




        rgstr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = name.getText().toString();
                String cIN = c_i_n1.getText().toString();
                String phoneNumber = phone1.getText().toString();
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",fullName);
                hashMap.put("CIN",cIN);
                hashMap.put("phone",phoneNumber);
                databaseReference1.child("inirmière")
                        .child(fullName)
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(registration2.this, "inscription validée", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(registration2.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });




            }
        });


    }
}
