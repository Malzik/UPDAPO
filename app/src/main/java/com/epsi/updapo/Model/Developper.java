package com.epsi.updapo.Model;

import org.json.JSONObject;

import java.io.Serializable;

public class Developper implements Serializable {
    private String name;
    private String prenom;
    private String mail;
    private String website;
    private String description;
    private String pictureUrl;


    public Developper(JSONObject jsonObject) {
        this.name = jsonObject.optString("name","");
        this.prenom = jsonObject.optString("prenom", "");
        this.mail = jsonObject.optString("mail", "");
        this.website = jsonObject.optString("website", "");
        this.description = jsonObject.optString("description", "");
        this.pictureUrl = jsonObject.optString("picture_url", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String picture_url) {
        this.pictureUrl = picture_url;
    }
}
