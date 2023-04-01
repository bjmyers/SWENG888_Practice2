package com.example.practice2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        final ImageView imageView = listViewElement.findViewById(R.id.dealImageDisplay);

        itemNameView.setText(item.getName());
        itemPriceView.setText(String.format("$%.2f", item.getPrice()));

        setDealImage(imageView, item.getPrice());

        return listViewElement;
    }

    public static void setDealImage(final ImageView imageView, final double price) {
        if (price < 5.0) {
            imageView.setImageResource(R.drawable.high);
        }
        else if (price < 10.0) {
            imageView.setImageResource(R.drawable.medium);
        }
        else {
            imageView.setImageResource(R.drawable.low);
        }
    }

    public static void setDealText(final TextView textView, final double price) {
        if (price < 5.0) {
            textView.setTextColor(Color.GREEN);
            textView.setText("Great Deal");
        }
        else if (price < 10.0) {
            textView.setTextColor(Color.YELLOW);
            textView.setText("Average Deal");
        }
        else {
            textView.setTextColor(Color.RED);
            textView.setText("Poor Deal");
        }
    }
}
