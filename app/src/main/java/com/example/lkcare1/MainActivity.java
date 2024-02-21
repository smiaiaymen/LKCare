package com.example.lkcare1;

import static com.example.lkcare1.R.id.btn3;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private EditText selectedDate;
    private EditText selectedEvent;
    private TextView date;
    private TextView event;

    private String getFormattedDate(long dateInMillis) {
        // Implement the date formatting logic as per your needs
        // For example, you can use SimpleDateFormat to format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(new Date(dateInMillis));
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("page d'accueil");


        Button btn_nav = findViewById(R.id.nav_btn);
        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, navigation.class);
                startActivity(intent);
            }
        });

        Button btn_add = findViewById(R.id.Add_btn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }


        });
        Button btn_add2 = findViewById(R.id.Add_btn2);
        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registration2.class);
                startActivity(intent);
            }


        });
        Button btn_nav2 = findViewById(R.id.nav_btn2);
        btn_nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, navigation2.class);
                startActivity(intent);
            }


        });
        calendarView = findViewById(R.id.calendarView);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, calendar.class);
                startActivity(intent);


            }
        });

    }
}




