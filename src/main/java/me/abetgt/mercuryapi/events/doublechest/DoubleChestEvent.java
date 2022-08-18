package me.abetgt.mercuryapi.events.doublechest;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.inventory.InventoryHolder;

public final class DoubleChestEvent extends Event implements Cancellable {

    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Player eventPlayer;
    private Block eventBlock;
    private BlockState eventBlockState;
    private DoubleChest eventDoubleChest;
    private Block eventBlockAgainst;
    private InventoryHolder eventChestLeft;
    private InventoryHolder eventChestRight;

    /**
     * An event that triggers when a player places down a chest, that forms a double chest.
     */
    public DoubleChestEvent(Player player,
                            Block block,
                            BlockState blockState,
                            DoubleChest doubleChest,
                            Block againstBlock,
                            InventoryHolder chestLeftSide,
                            InventoryHolder chestRightSide){
        eventPlayer = player;
        eventBlock = block;
        eventBlockState = blockState;
        eventDoubleChest = doubleChest;
        eventBlockAgainst = againstBlock;
        eventChestLeft = chestLeftSide;
        eventChestRight = chestRightSide;
    }

    /**
     * Returns the player.
     * @return Player
     */
    public Player getPlayer() {return eventPlayer;}
    /**
     * Returns the block involved in this event.
     * @return Block
     */
    public Block getBlock() {return eventBlock;}
    /**
     * Returns the block state involved in this event.
     * @return BlockState
     */
    public BlockState getBlockState() {return eventBlockState;}

    /**
     * Returns the double chest involved.
     * @return DoubleChest
     */
    public DoubleChest getDoubleChest() {return eventDoubleChest;}

    /**
     * Returns the block placed against involved in this event.
     * @return Block
     */
    public Block getAgainstBlock() {return eventBlockAgainst;}

    /**
     * Returns the left side of the chest involved in this event.
     * @return InventoryHolder
     */
    public InventoryHolder getLeftChest() {return eventChestLeft;}

    /**
     * Returns the right side of the chest involved in this event.
     * @return InventoryHolder
     */
    public InventoryHolder getRightChest() {return eventChestRight;}

    public static final HandlerList getHandlerList() {return handlers;}
    public final HandlerList getHandlers() {return handlers;}

    public boolean isCancelled() {return this.cancel;}
    public void setCancelled(boolean cancel) {this.cancel = cancel;}
}

