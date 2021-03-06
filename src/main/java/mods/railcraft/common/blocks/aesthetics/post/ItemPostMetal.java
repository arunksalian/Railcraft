/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2018
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.blocks.aesthetics.post;

import mods.railcraft.common.blocks.ItemBlockRailcraftColored;
import mods.railcraft.common.plugins.color.EnumColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class ItemPostMetal extends ItemBlockRailcraftColored<BlockPostMetalBase> {

    public ItemPostMetal(BlockPostMetalBase block) {
        super(block);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if (stack.getItemDamage() == -1 || stack.getItemDamage() == OreDictionary.WILDCARD_VALUE)
            return EnumPost.METAL_UNPAINTED.getTag();
        return super.getTranslationKey() + "." + EnumColor.fromOrdinal(stack.getItemDamage()).getBaseTag();
    }
}
