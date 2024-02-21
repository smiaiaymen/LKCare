package com.example.lkcare1;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import java.util.HashMap;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    private EditText name;
    private EditText c_i_n;
    private EditText phone;
    private EditText date;
    private EditText datee;
    private Button rgstr;
    private Button cancel;
    private FirebaseDatabase firebaseDatabase ;


    private DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("ajouter un membre");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference  = firebaseDatabase.getReference();
        name = findViewById(R.id.etNom);
        c_i_n = findViewById(R.id.etcin);
        phone = findViewById(R.id.etphone);
        date = findViewById(R.id.etbirth);
        rgstr = findViewById(R.id.rgstrbtn);
        datee = findViewById(R.id.etdate);




        rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName1 = name.getText().toString();
                String CIN = c_i_n.getText().toString();
                String phoneNumber = phone.getText().toString();
                String dateOfBirth = date.getText().toString();
                String dateentree = datee.getText().toString();

                HashMap<String,Object> hashmap = new HashMap<>();
                hashmap.put("name",fullName1);
                hashmap.put("CIN",CIN);
                hashmap.put("phone",phoneNumber);
                hashmap.put("date",dateOfBirth);
                hashmap.put("datee",dateentree);
                databaseReference.child("membre")
                        .child(fullName1)
                        .setValue(hashmap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Registration.this, "inscription validée", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Registration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}



