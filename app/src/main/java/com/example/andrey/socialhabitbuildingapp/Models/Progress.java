package com.example.andrey.socialhabitbuildingapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Progress {
    @SerializedName("units_value")
    @Expose
    private Integer unitsValue;
    @SerializedName("pub_date")
    @Expose
    private String pubDate;

    public Progress(Integer unitsValue, String pubDate) {
        this.unitsValue = unitsValue;
        this.pubDate = pubDate;
    }

    public Integer getUnitsValue() {
        return unitsValue;
    }

    public void setUnitsValue(Integer unitsValue) {
        this.unitsValue = unitsValue;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
