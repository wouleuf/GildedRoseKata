package com.gildedrose;

import com.gildedrose.entities.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    @Test
    public void conjuredItemsDegradeInQualityTwiceAsFastAsNormalItems() throws Exception {
        Item[] items = new Item[] { new Item("Conjured", 2, 36) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(34, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }
}
