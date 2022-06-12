package com.gildedrose.entities;

import com.gildedrose.Item;

public class BackStage extends ItemModel{

    protected void updateExpired(Item item) {
        item.quality = 0;
    }

    protected void updateQuality(Item item) {
        incrementQuality(item);

        if (item.sellIn <= 10) {
            incrementQuality(item);
        }

        if (item.sellIn <= 5) {
            incrementQuality(item);
        }
    }
}
