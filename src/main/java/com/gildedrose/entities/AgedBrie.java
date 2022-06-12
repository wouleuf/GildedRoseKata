package com.gildedrose.entities;

import com.gildedrose.Item;

public class AgedBrie extends ItemModel {

    protected void updateExpired(Item item) {
        incrementQuality(item);
    }

    protected void updateQuality(Item item) {
        incrementQuality(item);
    }
}
