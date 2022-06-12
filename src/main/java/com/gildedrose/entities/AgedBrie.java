package com.gildedrose.entities;

public class AgedBrie extends ItemModel {

    protected void updateExpired(Item item) {
        incrementQuality(item);
    }

    protected void updateQuality(Item item) {
        incrementQuality(item);
    }
}
