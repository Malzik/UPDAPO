package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.epsi.updapo.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class CategoryActivity extends UPDAPOActivity {

    private CategoryAdapter adapter;

    private ArrayList<Category> categories = new ArrayList<>();

    public static void display(UPDAPOActivity activity) {
        Intent intent = new Intent(activity, CategoryActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        showBackBtn();
        ListView listView = findViewById(R.id.listViewCategories);
        adapter = new CategoryAdapter(this, R.layout.c_category, categories);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductActivity.display(CategoryActivity.this, categories.get(position));
            }
        });

        setTitle("Rayons");

        String url = "https://djemam.com/epsi/categories.json";

        new HttpAsyTask(url, new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                Category category = new Category(jsonArray.getJSONObject(i));
                categories.add(category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }
}