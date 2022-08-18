package me.abetgt.mercuryapi.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;

public final class PlayerOpenMerchantInventoryEvent extends Event implements Cancellable {

    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Player eventPlayer;
    private Inventory eventInventory;
    private MerchantInventory eventMerchantInventory;
    private Merchant eventMerchant;
    private Integer eventInventorySize;

    public PlayerOpenMerchantInventoryEvent(
            Player player,
            Inventory inventory,
            MerchantInventory merchantInventory,
            Merchant merchant,
            Integer inventorySize
    ){
        eventPlayer = player;
        eventInventory = inventory;
        eventMerchantInventory = merchantInventory;
        eventMerchant = merchant;
        eventInventorySize = inventorySize;
    }

    /**
     * Returns the player.
     * @return Player
     */
    public Player getPlayer() {return eventPlayer;}

    /**
     * Returns the player - duplicate of getPlayer().
     * @deprecated Please use getPlayer() instead, this is a duplicate.
     * @return Player
     */
    public Player getEventPlayer() {return eventPlayer;}

    /**
     * Returns the inventory involved in this event.
     * @return Inventory
     */
    public Inventory getInventory() {return eventInventory;}

    /**
     * Returns the merchant inventory involved in this event.
     * @return MerchantInventory
     */
    public MerchantInventory getMerchantInventory() {return eventMerchantInventory;}

    /**
     * Returns the merchant.
     * @return Merchant
     */
    public Merchant getMerchant() {return eventMerchant;}

    /**
     * Returns the merchant involved in this event.
     * @deprecated Please use getMerchant() instead, this is a duplicate.
     * @return Merchant
     */
    public Merchant getEventMerchant() {return eventMerchant;}

    /**
     * Returns the inventory size of the MerchantInventory.
     * @return Integer
     */
    public Integer getInventorySize() {return eventInventorySize;}

    /**
     * Sets the max stack size.
     */
    public void setMaxStackSizeMercury(Integer stackSize) {eventMerchantInventory.setMaxStackSize(stackSize);}

    public static final HandlerList getHandlerList(){
        return handlers;
    }
    public final HandlerList getHandlers(){
        return handlers;
    }
    public boolean isCancelled(){
        return this.cancel;
    }
    public void setCancelled(boolean cancel){
        this.cancel = cancel;
    }
}

