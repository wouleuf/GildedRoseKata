package com.gildedrose;

import com.gildedrose.entities.*;

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
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackStage();
        }
        if (item.name.equals("Conjured")){
            return new Conjured();
        }
        return new ItemModel();
    }
}
