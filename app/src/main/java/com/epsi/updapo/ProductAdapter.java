package com.epsi.updapo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.epsi.updapo.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.c_product, null);

        TextView textViewTitle = convertView.findViewById(R.id.textViewProductName);
        TextView textViewDescription = convertView.findViewById(R.id.textViewProductDescription);
        ImageView imageView = convertView.findViewById(R.id.imageViewProduct);

        Product product = getItem(position);

        assert product != null;
        textViewTitle.setText(product.getName());
        textViewDescription.setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(imageView);

        return convertView;
    }
}
