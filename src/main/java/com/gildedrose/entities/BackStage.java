package com.gildedrose.entities;

import com.gildedrose.Item;

public class BackStage extends ItemModel{

    protected void updateExpired(Item item) {
        item.quality = 0;
    }

    protected void updateQuality(Item item) {
        incrementQuality(item);

        if (item.sellIn <= NUMBER_DAYS_REMAINING_OR_LESS_INCREASING_BY_TWO) {
            incrementQuality(item);
        }

        if (item.sellIn <= NUMBER_DAYS_REMAINING_OR_LESS_INCREASING_BY_THREE) {
            incrementQuality(item);
        }
    }
}
