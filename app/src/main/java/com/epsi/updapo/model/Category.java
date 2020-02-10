package com.epsi.updapo.Model;

import org.json.JSONObject;

import java.io.Serializable;

public class Category implements Serializable {

    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String pictureUrl = "";

    public Category(JSONObject jsonObject) {
        firstName = jsonObject.optString("firstName", "");
        lastName = jsonObject.optString("lastName", "");
        email = jsonObject.optString("email", "");
        pictureUrl = jsonObject.optString("picture_url", "");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
