package com.example.lkcare1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class med_fich extends AppCompatActivity {

    private TextView Name;
    private TextView Cin;
    private TextView tel;
    private TextView dobTextView;
    private TextView entryDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_fich);
        setTitle("Détails du membre");

        Name = findViewById(R.id.nom);
        Cin = findViewById(R.id.cin);
        tel = findViewById(R.id.tel);
        dobTextView = findViewById(R.id.date);
        entryDateTextView = findViewById(R.id.datee);

        // Récupérez toutes les données du membre depuis l'intent
        Member member = getIntent().getParcelableExtra("member");

        if (member != null) {
            Name.setText(member.getName());
            Cin.setText(member.getCin());
            tel.setText(member.getPhoneNumber());
            dobTextView.setText(member.getDateOfBirth());
            entryDateTextView.setText(member.getDateEntry());
        }
    }
}
