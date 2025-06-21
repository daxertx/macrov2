package net.project.macrov2.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.project.macrov2.Macrov2;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.item.custom.ChiselItem;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item GAUNTLET = registerItem("gauntlet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel",new ChiselItem(new Item.Settings().maxDamage(50)));



        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, Identifier.of(Macrov2.MOD_ID, name), item);
        }

        public static void registerModItems() {
            Macrov2.LOGGER.info("Registering Mod Items for " + Macrov2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            //adds it to creative mod tab
            //items:
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(GAUNTLET);
        });
    }
}