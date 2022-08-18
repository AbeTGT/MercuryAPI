package me.abetgt.mercuryapi.events.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public final class PlayerInfluenceFlowerPotEvent extends Event implements Cancellable {
    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Player eventPlayer;
    private Block eventFlowerPot;
    private EquipmentSlot eventUsedHand;
    private ItemStack eventHeldItem;
    private Material eventItemMaterial;


    /**
     * The PlayerInfluenceFlowerPotEvent is used to determine when a player puts an item into a flower pot.
     * @param player
     * @param flowerPot
     * @param usedHand
     * @param heldItem
     * @param usedItemMaterial
     */
    public PlayerInfluenceFlowerPotEvent(
            Player player,
            Block flowerPot,
            EquipmentSlot usedHand,
            ItemStack heldItem,
            Material usedItemMaterial
    ){
        eventPlayer = player;
        eventFlowerPot = flowerPot;
        eventUsedHand = usedHand;
        eventHeldItem = heldItem;
        eventItemMaterial = usedItemMaterial;
    };

    /**
     * Returns the player.
     * @return Player
     */
    public Player getPlayer() {return eventPlayer;}

    /**
     * Returns the flower pot involved.
     * @return Block
     */
    public Block getFlowerPot() {return eventFlowerPot;}

    /**
     * Returns the used hand involved.
     * @return EquipmentSlot
     */
    public EquipmentSlot getUsedHand() {return eventUsedHand;}

    /**
     * Returns the held item involved.
     * @return ItemStack
     */
    public ItemStack getHeldItem() {return eventHeldItem;}

    /**
     * Returns the material of the item involved.
     * @return ItemStack
     */
    public Material getItemMaterial() {return eventItemMaterial;}

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
