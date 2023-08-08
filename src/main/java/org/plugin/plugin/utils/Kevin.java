package org.plugin.plugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Kevin {
    public static ItemStack createKevin(){
        ItemStack kevin = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = kevin.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" +  ChatColor.BOLD + ChatColor.ITALIC + " 　Kevin Killer");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "　　賤民要有一把劍");
        lore.add(ChatColor.YELLOW + "一把燃燒掠奪加擊退的劍");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 32767, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 32767, true);
        meta.setLocalizedName("kevin_killer");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kevin.setItemMeta(meta);

        return kevin;
    }
}
