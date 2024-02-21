package com.example.lkcare1;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class calendar extends AppCompatActivity {





        private EditText selectedDate;
        private EditText selectedEvent;
        private TextView date;
        private TextView event;
        private Button saveButton;
        private ListView listView;
        private List<String> dataList;
        private ArrayAdapter<String> adapter;

        private SharedPreferences sharedPreferences;


        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);
            setTitle("calendrier");

            selectedDate = findViewById(R.id.textViewDate);
            selectedEvent = findViewById(R.id.textViewEvent);
            date = findViewById(R.id.date);
            event = findViewById(R.id.event);
            saveButton = findViewById(R.id.savebtn);
            listView = findViewById(R.id.listView);

            dataList = new ArrayList<>();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
            listView.setAdapter(adapter);
            sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
            loadData();


            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String data1 = selectedDate.getText().toString();
                    String data2 = selectedEvent.getText().toString();

                    date.setText(data1);
                    event.setText(data2);

                    // Add the data to the list
                    String newData = data1 + ": " + data2;
                    dataList.add(newData);
                    adapter.notifyDataSetChanged();
                    saveData();
                }
            });

        }
    private void loadData() {
        Set<String> savedData = sharedPreferences.getStringSet("dataList", null);
        if (savedData != null) {
            dataList.addAll(savedData);
            adapter.notifyDataSetChanged();
        }
    }


    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("dataList", new HashSet<>(dataList));
        editor.apply();
    }
}
