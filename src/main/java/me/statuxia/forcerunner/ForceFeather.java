package me.statuxia.forcerunner;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ForceFeather {

    public static ItemStack forceFeather = new ItemStack(Material.FEATHER, 1);

    public static void construct() {
        List<String> forceFeatherLore = new ArrayList<>();
        forceFeatherLore.add("�6��� - ��������� ������������ �������� � ����������� ������.");
        forceFeatherLore.add("�7������� � ��������� ������� ���� �� �������.");
        ItemMeta itemMeta = forceFeather.getItemMeta();
        itemMeta.setDisplayName("�6���� ����");
        forceFeather.setItemMeta(itemMeta);
        forceFeather.setLore(forceFeatherLore);
        forceFeather.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1);
    }
}
