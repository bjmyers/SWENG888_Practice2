package com.example.practice2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {

    public ItemListAdapter(@NonNull Context context, @NonNull List<Item> objects) {
        super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final View listViewElement = convertView != null ? convertView : LayoutInflater.from(getContext())
                .inflate(R.layout.list_item, parent, false);
        final Item item = getItem(position);
        final TextView itemNameView = listViewElement.findViewById(R.id.item_name);
        final TextView itemPriceView = listViewElement.findViewById(R.id.item_price);

        itemNameView.setText(item.getName());
        itemPriceView.setText(String.format("$%.2f", item.getPrice()));

        return listViewElement;
    }
}
