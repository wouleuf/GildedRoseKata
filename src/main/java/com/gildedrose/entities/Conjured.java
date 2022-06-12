package com.gildedrose.entities;

public class Conjured extends ItemModel {

    protected void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }

    protected void updateQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
