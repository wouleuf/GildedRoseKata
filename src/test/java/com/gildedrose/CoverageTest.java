package com.gildedrose;

import com.gildedrose.entities.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoverageTest {

    @Test
    public void updateQualityByDecrementsSellInAndItemQuality(){

        Item[] items = new Item[] { new Item("foo", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void onceTheSellByDateHasPassedQualityDegradesTwiceAsFast() throws Exception {
        Item[] items = new Item[] { new Item("foo", -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


    @Test
    public void qualityOfAnItemIsNeverNegative() throws Exception {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


    @Test
    public void briesQualityIncreaseInQualityTheOlderItGets() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void theQualityOfAnItemIsNeverMoreThan50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50), new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(50, app.items[1].quality);
        assertEquals(2, app.items[1].sellIn);
    }



    @Test
    public void SulfurasBeingALegendaryItemNeverHasToBeSoldOrDecreasesInQuality() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesQualityIncrementsByOneWithEachDayPassing() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(31, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy2WhenThereAre10DaysOrLessRemaining() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(32, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy3WhenThereAre5DaysOrLessRemaining() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(36, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesQualityDropsTo0AfterTheConcert() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


}
