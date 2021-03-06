/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2018
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.gui.containers;

import mods.railcraft.common.blocks.detector.TileDetector;
import mods.railcraft.common.blocks.interfaces.ITileAspectResponder;
import mods.railcraft.common.blocks.logic.BlastFurnaceLogic;
import mods.railcraft.common.blocks.logic.CokeOvenLogic;
import mods.railcraft.common.blocks.logic.ILogicContainer;
import mods.railcraft.common.blocks.logic.TradeStationLogic;
import mods.railcraft.common.blocks.machine.ITankTile;
import mods.railcraft.common.blocks.machine.equipment.TileFeedStation;
import mods.railcraft.common.blocks.machine.equipment.TileRollingMachine;
import mods.railcraft.common.blocks.machine.equipment.TileRollingMachinePowered;
import mods.railcraft.common.blocks.machine.manipulator.*;
import mods.railcraft.common.blocks.machine.worldspike.TileWorldspike;
import mods.railcraft.common.blocks.multi.*;
import mods.railcraft.common.blocks.single.TileEngineSteam;
import mods.railcraft.common.blocks.single.TileEngineSteamHobby;
import mods.railcraft.common.blocks.tracks.outfitted.TileTrackOutfitted;
import mods.railcraft.common.blocks.tracks.outfitted.kits.TrackKitRouting;
import mods.railcraft.common.carts.*;
import mods.railcraft.common.gui.EnumGui;
import mods.railcraft.common.modules.RailcraftModuleManager;
import mods.railcraft.common.util.misc.Game;
import mods.railcraft.common.util.routing.IRouter;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public final class FactoryContainer {

    @SuppressWarnings("ConstantConditions")
    public static Container build(EnumGui gui, InventoryPlayer inv, Object obj, World world, int x, int y, int z) {
        if (gui != EnumGui.ANVIL && obj == null)
            return null;

        if (obj instanceof TileMultiBlock && !((TileMultiBlock) obj).isStructureValid())
            return null;

        try {
            switch (gui) {
                case MANIPULATOR_ITEM:
                    return new ContainerManipulatorCartItem(inv, (TileItemManipulator) obj);
                case MANIPULATOR_FLUID:
                    return new ContainerManipulatorCartFluid(inv, (TileFluidManipulator) obj);
                case LOADER_ENERGY:
                    return new ContainerEnergyLoader(inv, (TileIC2Loader) obj);
                case UNLOADER_ENERGY:
                    return new ContainerEnergyLoader(inv, (TileIC2Unloader) obj);
                case MANIPULATOR_RF:
                    return new ContainerManipulatorCartRF((TileRFManipulator) obj);
                case DETECTOR_ITEM:
                    return new ContainerDetectorItem(inv, (TileDetector) obj);
                case DETECTOR_TANK:
                    return new ContainerDetectorTank(inv, (TileDetector) obj);
                case DETECTOR_SHEEP:
                    return new ContainerDetectorSheep(inv, (TileDetector) obj);
                case DETECTOR_ADVANCED:
                    return new ContainerDetectorAdvanced(inv, (TileDetector) obj);
                case DETECTOR_LOCOMOTIVE:
                    return new ContainerDetectorLocomotive(inv, (TileDetector) obj);
                case DETECTOR_ROUTING:
                    return new ContainerRouting(inv, (IRouter) ((TileDetector) obj).getDetector());
                case CART_DISPENSER:
                    return new ContainerDispenserCart(inv, (TileDispenserCart) obj);
                case TRAIN_DISPENSER:
                    return new ContainerDispenserTrain(inv, (TileDispenserTrain) obj);
                case COKE_OVEN:
                    return new ContainerCokeOven(inv, ((ILogicContainer) obj).getLogic(CokeOvenLogic.class)
                            .orElseThrow(NullPointerException::new));
                case BLAST_FURNACE:
                    return new ContainerBlastFurnace(inv, ((ILogicContainer) obj).getLogic(BlastFurnaceLogic.class)
                            .orElseThrow(NullPointerException::new));
                case STEAN_OVEN:
                    return new ContainerSteamOven(inv, (TileSteamOven) obj);
                case ROCK_CRUSHER:
                    return new ContainerRockCrusher(inv, (TileRockCrusher) obj);
                case TANK:
                    return new ContainerTank(inv, (ITankTile) obj);
                case ROLLING_MACHINE_MANUAL:
                    return new ContainerRollingMachine(inv, (TileRollingMachine) obj);
                case ROLLING_MACHINE_POWERED:
                    return new ContainerRollingMachinePowered(inv, (TileRollingMachinePowered) obj);
                case FEED_STATION:
                    return new ContainerFeedStation(inv, (TileFeedStation) obj);
                case TRADE_STATION:
                    return new ContainerTradeStation(inv, ((ILogicContainer) obj).getLogic(TradeStationLogic.class)
                            .orElseThrow(NullPointerException::new));
                case WORLDSPIKE:
                    return new ContainerWorldspike(inv, (TileWorldspike) obj);
                case ENGINE_STEAM:
                    return new ContainerEngineSteam(inv, (TileEngineSteam) obj);
                case ENGINE_HOBBY:
                    return new ContainerEngineSteamHobby(inv, (TileEngineSteamHobby) obj);
                case BOILER_SOLID:
                    return new ContainerBoilerSolid(inv, (TileBoilerFireboxSolid) obj);
                case BOILER_LIQUID:
                    return new ContainerBoilerFluid(inv, (TileBoilerFireboxFluid) obj);
                case TURBINE:
                    return new ContainerTurbine(inv, (TileSteamTurbine) obj);
                case ANVIL:
                    return new ContainerAnvil(inv, world, new BlockPos(x, y, z), inv.player);
                case CART_BORE:
                    return new ContainerBore(inv, (EntityTunnelBore) obj);
                case CART_ENERGY:
                    return new ContainerCartEnergy(inv, (IIC2EnergyCart) obj);
                case CART_RF:
                    return new ContainerCartRF((EntityCartRF) obj);
                case CART_TANK:
                    return new ContainerCartTank(inv, (EntityCartTank) obj);
                case CART_CARGO:
                    return new ContainerCartCargo(inv, (EntityCartCargo) obj);
                case CART_WORLDSPIKE:
                    return new ContainerWorldspike(inv, (EntityCartWorldspike) obj);
                case CART_WORK:
                    return new ContainerCartWork(inv, (EntityCartWork) obj);
                case CART_TRACK_LAYER:
                    return new ContainerCartTrackLayer(inv, (EntityCartTrackLayer) obj);
                case CART_TRACK_RELAYER:
                    return new ContainerCartTrackRelayer(inv, (EntityCartTrackRelayer) obj);
                case CART_UNDERCUTTER:
                    return new ContainerCartUndercutter(inv, (EntityCartUndercutter) obj);
                case LOCO_STEAM:
                    return ContainerLocomotiveSteamSolid.make(inv, (EntityLocomotiveSteamSolid) obj);
                case LOCO_ELECTRIC:
                    return ContainerLocomotiveElectric.make(inv, (EntityLocomotiveElectric) obj);
                case LOCO_CREATIVE:
                    return ContainerLocomotive.make(inv, (EntityLocomotiveCreative) obj);
                case SWITCH_MOTOR:
                    return new ContainerAspectAction(inv.player, (ITileAspectResponder) obj);
                case BOX_RECEIVER:
                    return new ContainerAspectAction(inv.player, (ITileAspectResponder) obj);
                case BOX_RELAY:
                    return new ContainerAspectAction(inv.player, (ITileAspectResponder) obj);
                case ROUTING:
                    return new ContainerRouting(inv, (IRouter) obj);
                case TRACK_ROUTING:
                    return new ContainerTrackRouting(inv, (TrackKitRouting) ((TileTrackOutfitted) obj).getTrackKitInstance());
                default:
                    return RailcraftModuleManager.getGuiContainer(gui, inv, obj, world, x, y, z);
            }
        } catch (ClassCastException ex) {
            Game.log(Level.WARN, "Error when attempting to build gui container {0}: {1}", gui, ex);
        }
        return null;
    }

    private FactoryContainer() {
    }

}
