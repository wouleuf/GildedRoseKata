package com.gildedrose.entities;

import com.gildedrose.Item;

public class ItemModel {

    public static final int LOWEST_POSSIBLE_QUALITY = 0;
    public static final int HIGHEST_POSSIBLE_QUALITY = 50;
    public static final int UNITY_UPDATE = 1;
    public static final int NUMBER_DAYS_REMAINING_OR_LESS_INCREASING_BY_TWO = 10;
    public static final int NUMBER_DAYS_REMAINING_OR_LESS_INCREASING_BY_THREE = 5;

    protected void incrementQuality(Item item) {
        if (item.quality < HIGHEST_POSSIBLE_QUALITY) {
            item.quality = item.quality + UNITY_UPDATE;
        }
    }

    protected void decrementQuality(Item item) {
        if (item.quality > LOWEST_POSSIBLE_QUALITY) {
            item.quality = item.quality - UNITY_UPDATE;
        }
    }

    protected void updateExpired(Item item) {
        decrementQuality(item);
    }

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - UNITY_UPDATE;
    }

    protected void updateQuality(Item item) {
        decrementQuality(item);
    }

    public void updateAnItem(Item item) {
        updateQuality(item);

        updateSellIn(item);

        if (item.sellIn < LOWEST_POSSIBLE_QUALITY) {
            updateExpired(item);
        }
    }

}
