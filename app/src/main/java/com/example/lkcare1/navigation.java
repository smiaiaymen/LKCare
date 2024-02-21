package com.example.lkcare1;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class navigation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<Member> memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setTitle("Liste des membres");

        recyclerView = findViewById(R.id.recyclerid1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        memberList = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("membre");

        // Écoutez les données Firebase et mettez à jour la liste des membres
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memberList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Member member = snapshot.getValue(Member.class);
                    if (member != null) {
                        memberList.add(member);
                    }
                }
                recyclerView.setAdapter(new MemberAdapter(memberList, navigation.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(navigation.this, "Erreur lors de la récupération des données.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

