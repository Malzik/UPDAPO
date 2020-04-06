package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.epsi.updapo.model.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends UPDAPOActivity {
    private Product product;

    public static void display(UPDAPOActivity activity, Product product) {
        Intent intent = new Intent(activity, ProductDetailsActivity.class);
        intent.putExtra("Product", product);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        showBackBtn();
        product = (Product) getIntent().getExtras().get("Product");

        TextView textProductDescription = findViewById(R.id.textViewDescriptionDetails);
        ImageView imageViewDetails = findViewById(R.id.imageViewProductDetails);

        textProductDescription.setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(imageViewDetails);

        setTitle(product.getName());

    }
}
