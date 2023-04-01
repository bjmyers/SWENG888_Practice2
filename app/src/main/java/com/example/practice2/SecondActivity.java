package com.example.practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    public static final String BACK_KEY = "backFromSecondActivity";

    private TextView mItemIdView;
    private TextView mItemNameView;
    private TextView mItemPriceView;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mItemIdView = findViewById(R.id.itemIdView);
        mItemNameView = findViewById(R.id.itemNameView);
        mItemPriceView = findViewById(R.id.itemPriceView);

        final Intent intent = getIntent();
        final Item selectedItem = (Item) intent.getSerializableExtra(MainActivity.SELECTED_ITEM_KEY);

        System.out.println(selectedItem.getIdentifier());
        System.out.println(selectedItem.getName());
        System.out.println(selectedItem.getPrice());

        mItemIdView.setText("ID: " + selectedItem.getIdentifier());
        mItemNameView.setText("Item Name: " + selectedItem.getName());
        mItemPriceView.setText(String.format("Price: $%.2f", selectedItem.getPrice()));

        mBackButton = findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(BACK_KEY, true);
                startActivity(intent);
            }
        });
    }
}
