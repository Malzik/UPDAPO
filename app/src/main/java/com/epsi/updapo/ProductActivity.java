package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.epsi.updapo.model.Category;
import com.epsi.updapo.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductActivity extends UPDAPOActivity {
    private Category category;
    private ProductAdapter adapter;

    private ArrayList<Product> products = new ArrayList<>();

    public static void display(UPDAPOActivity activity, Category category) {
        Intent intent = new Intent(activity, ProductActivity.class);
        intent.putExtra("category", category);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        showBackBtn();
        category = (Category) getIntent().getExtras().get("category");

        ListView listView = findViewById(R.id.listViewCategories);
        adapter = new ProductAdapter(this, R.layout.c_product, products);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductDetailsActivity.display(ProductActivity.this, products.get(position));
            }
        });

        new HttpAsyTask(category.getProductsUrl(), new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();

        setTitle(category.getTitle());
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                Product product = new Product(jsonArray.getJSONObject(i));
                products.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }
}
