package com.example.paras.primotech;

/**
 * Created by anmol on 1/12/2018.
 */

public class MyData {


    int id;
    private String Title,Description,Image;
    public MyData() {
    }
    public MyData(String Title, String Description, String Image) {

        this.Title = Title;
        this.Description = Description;
        this.Image = Image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String Image) {
        this.Image = Image;
    }
}
