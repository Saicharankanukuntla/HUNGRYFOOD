package com.example.hungryfood;

import com.google.gson.annotations.SerializedName;

public class GetRecipePojo {

    public GetRecipePojo(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("category")
    private String category;

    @SerializedName("description")
    private String description;

    public GetRecipePojo()
    {

    }
}



