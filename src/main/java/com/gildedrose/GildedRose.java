package com.gildedrose;

import com.gildedrose.entities.AgedBrie;
import com.gildedrose.entities.BackStage;
import com.gildedrose.entities.ItemModel;
import com.gildedrose.entities.Sulfuras;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemModel model = findModelByItem(item);
            model.updateAnItem(item);
        }
    }

    private ItemModel findModelByItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras();
        }
        if (item.name.equals("Aged Brie")) {
            return new AgedBrie();
        }
        if (item.name.equals("Backstage passes")) {
            return new BackStage();
        }
        return new ItemModel();
    }
}
