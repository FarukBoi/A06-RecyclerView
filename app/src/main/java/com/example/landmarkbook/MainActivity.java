package com.example.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<Landmark> landmarksArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the landmarksArrayList
        landmarksArrayList = new ArrayList<>();

        //Data
        Landmark pisa = new Landmark("Pisa Tower", "Italy", R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel Tower", "France", R.drawable.eifel);
        Landmark londonBridge = new Landmark("London Bridge", "United Kingdom", R.drawable.biridge);
        Landmark colesseum = new Landmark("Colesseum", "Italy", R.drawable.kolezyum);

        landmarksArrayList.add(pisa);
        landmarksArrayList.add(eiffel);
        landmarksArrayList.add(londonBridge);
        landmarksArrayList.add(colesseum);
/*
        //Adapter
          //ListView

        //mapping
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,
                landmarksArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landmarksArrayList.get(i).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DetalisActivity.class);
                intent.putExtra("landmark",landmarksArrayList.get(i));
                startActivity(intent);
            }
        });*/

        //recycler view
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarksArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
    }
}
