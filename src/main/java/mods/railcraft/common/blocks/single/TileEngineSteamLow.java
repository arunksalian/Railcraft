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
import mods.railcraft.common.util.steam.SteamConstants;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class TileEngineSteamLow extends TileEngineSteam {

    private static final int OUTPUT_RF = 40;

    @Override
    public EnumGui getGui() {
        return EnumGui.ENGINE_STEAM;
    }

    @Override
    public int getMaxOutputRF() {
        return OUTPUT_RF;
    }

    @Override
    public int steamUsedPerTick() {
        return SteamConstants.STEAM_PER_10RF * (OUTPUT_RF / 10);
    }

    @Override
    public int maxEnergy() {
        return 200000;
    }

    @Override
    public int maxEnergyReceived() {
        return 6000;
    }
}
