package com.coodecool.plaza.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProduct extends Product {

    private int calories;
    private Date bestBefore;

    public FoodProduct(long barcode, String manufacturer, String name, int calories, Date bestBefore) {
        super(barcode, manufacturer, name);
        this.calories = calories;
        this.bestBefore = bestBefore;
    }

    public boolean isStillConsumable() {
        Date date = new Date();
        String simpleBestBefore = new SimpleDateFormat("yyyy-MM-dd").format(bestBefore);
        String simpleCurrDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        int compareDates = simpleBestBefore.compareTo(simpleCurrDate);
        return compareDates <= 0;
    }

    public int getCalories(){
        return calories;
    }

    public String toString() {
        return "barcode :" + barcode +"\nmanufacturer :" + manufacturer + "\nname :" + name + "\ncalories :" + calories +"\nstill eatable : " +isStillConsumable();
    }
}
