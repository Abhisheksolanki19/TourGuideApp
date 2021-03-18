package com.merchpandas.tourguide;

public class VisitItem {
    private String title;
    private String location;
    private int resourceId;


    public VisitItem(String title, int resourceId, String location) {
        this.title = title;
        this.resourceId = resourceId;
        this.location = location;

    }

    public String getTitle() {
        return this.title;
    }

    public String getLocation() {
        return this.location;
    }

    public int getResourceId() {
        return this.resourceId;
    }

}