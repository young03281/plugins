package org.plugin.plugin.utils;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UtilList {
    public static List<ItemStack> getUtilList(){
        List<ItemStack> items = new ArrayList<>();
        items.add(Kevin.createKevin());
        return items;
    }

    public static List<String> getItemName(){
        List<String> names = new ArrayList<>();
        for(ItemStack items : getUtilList()){
            names.add(Objects.requireNonNull(items.getItemMeta()).getLocalizedName());
        }

        return names;

    }


}
