package com.example.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemCLickListener {


    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    List<ItemModel> itemModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycler_view);

        itemModelList = new ArrayList<>();

        ItemModel item1 = new ItemModel("Beverage","Cool and Chill Beverages",R.drawable.beverage);
        ItemModel item2 = new ItemModel("Bread","Fresh and Baked Bread",R.drawable.bread);
        ItemModel item3 = new ItemModel("Fruits","Fresh and Organic Fruits from tha Farm",R.drawable.fruit);
        ItemModel item4 = new ItemModel("Milk","Fresh Milk from Diary",R.drawable.milk);
        ItemModel item5 = new ItemModel("PopCorn","Hot and Cheesy popcorn from the Hut",R.drawable.popcorn);
        ItemModel item6 = new ItemModel("Vegetables","Organic and Seasonal Vegetables",R.drawable.vegitables);

        itemModelList.add(item1);
        itemModelList.add(item2);
        itemModelList.add(item3);
        itemModelList.add(item4);
        itemModelList.add(item5);
        itemModelList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(itemModelList);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.setCLickListener(this);


    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this, "You Choose "+itemModelList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }
}