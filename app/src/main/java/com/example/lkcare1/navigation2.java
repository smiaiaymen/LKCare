package com.example.lkcare1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class navigation2 extends AppCompatActivity {


        private RecyclerView recyclerView;
        private NurseAdapter nurseAdapter;
        private List<Nurse> nurseList;
        private FirebaseDatabase firebaseDatabase;
        private DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navigation2);
            setTitle("Liste des infirmières");

            recyclerView = findViewById(R.id.recyclerid);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            nurseList = new ArrayList<>();
            nurseAdapter = new NurseAdapter(nurseList);
            recyclerView.setAdapter(nurseAdapter);

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("inirmière");

            // Écoutez les données Firebase et mettez à jour la liste des infirmières
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    nurseList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Nurse nurse = snapshot.getValue(Nurse.class);
                        if (nurse != null) {
                            nurseList.add(nurse);
                        }
                    }
                    nurseAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(navigation2.this, "Erreur lors de la récupération des données.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
