package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.epsi.updapo.model.Category;
import com.squareup.picasso.Picasso;

class CategoriesDetailsActivity extends UPDAPOActivity {
    private Category category;

    public static void display(UPDAPOActivity activity) {
        Intent intent = new Intent(activity, CategoryActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        showBackBtn();
        category = (Category) getIntent().getExtras().get("student");
        TextView firstName = findViewById(R.id.textViewFirstNameDetails);
        TextView lastName = findViewById(R.id.textViewLastNameDetails);
        TextView textEmail = findViewById(R.id.textViewEmailDetails);
        ImageView imageViewDetails = findViewById(R.id.imageViewCategoryDetails);

        firstName.setText(category.getFirstName());
        lastName.setText(category.getLastName());
        textEmail.setText(category.getEmail());
        Picasso.get().load(category.getPictureUrl()).into(imageViewDetails);

        setTitle(category.getFirstName());

    }
}
