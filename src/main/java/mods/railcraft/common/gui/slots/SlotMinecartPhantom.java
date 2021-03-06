/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2018
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.gui.slots;

import mods.railcraft.common.util.inventory.filters.StandardStackFilters;
import net.minecraft.inventory.IInventory;

public class SlotMinecartPhantom extends SlotStackFilter {

    public SlotMinecartPhantom(IInventory iinventory, int slotIndex, int posX, int posY) {
        super(StandardStackFilters.MINECART, iinventory, slotIndex, posX, posY);
        setPhantom();
        setStackLimit(1);
    }

}
