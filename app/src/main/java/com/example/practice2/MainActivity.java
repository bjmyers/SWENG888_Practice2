package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ItemListAdapter adapter;

    public final static String SELECTED_ITEM_KEY = "selectedItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview_items);

        final List<Item> items = generateItems();
        adapter = new ItemListAdapter(MainActivity.this, items);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item selectedItem = (Item) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(SELECTED_ITEM_KEY, selectedItem);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final boolean backPressed = getIntent().getBooleanExtra(SecondActivity.BACK_KEY, false);
        if (backPressed) {
            Snackbar.make(mListView, "Item Added To Cart", Snackbar.LENGTH_LONG).show();
        }
    }

    private List<Item> generateItems() {
        final List<String> possibleNames = new ArrayList<>();
        possibleNames.add("Toilet Paper");
        possibleNames.add("Paper Towels");
        possibleNames.add("Bananas");
        possibleNames.add("Ground Beef");
        possibleNames.add("Lettuce");
        possibleNames.add("American Cheese");
        possibleNames.add("Hummus");
        possibleNames.add("Chicken Breast");
        possibleNames.add("Crackers");
        possibleNames.add("Milk");
        possibleNames.add("Eggs");

        final Random rand = new Random();

        final List<Item> items = new ArrayList<>();
        // Generate 10 random items
        for (int i = 0; i < 10; i++) {
            final int id = rand.nextInt(10000);
            final String name = possibleNames.get(rand.nextInt(possibleNames.size()));
            final double price = rand.nextDouble() * 15.0;
            items.add(new Item(id, name, price));
        }
        return items;
    }
}