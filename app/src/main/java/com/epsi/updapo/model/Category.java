package com.epsi.updapo.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Category implements Serializable {

    private String category_id = "";
    private String title = "";
    private String products_url = "";

    public Category(JSONObject jsonObject) {
        category_id = jsonObject.optString("category_id", "");
        title = jsonObject.optString("title", "");
        products_url = jsonObject.optString("products_url", "");
        products_url = getProductsUrl().replace("http", "https");
    }


    public String getCategoryId() {
        return category_id;
    }

    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductsUrl() {
        return products_url;
    }

    public void setProductsUrl(String products_url) {
        this.products_url = products_url;
    }
}
