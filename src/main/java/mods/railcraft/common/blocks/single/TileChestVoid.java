/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2018
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.blocks.single;

import mods.railcraft.common.gui.EnumGui;
import mods.railcraft.common.blocks.logic.Logic;
import mods.railcraft.common.blocks.logic.VoidChestLogic;
import org.jetbrains.annotations.Nullable;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class TileChestVoid extends TileChestRailcraft {

    {
        setLogic(new VoidChestLogic(Logic.Adapter.of(this)));
    }

    @Override
    public @Nullable EnumGui getGui() {
        return null;
    }
}
