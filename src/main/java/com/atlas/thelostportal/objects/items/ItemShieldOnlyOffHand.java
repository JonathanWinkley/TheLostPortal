package com.atlas.thelostportal.objects.items;

import javax.annotation.Nullable;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.init.ModItemsInit;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldOnlyOffHand extends Item
{
	private final float attackDamage;
	
	public ItemShieldOnlyOffHand(String name, int durability, float attackDamage)
	{
		this.maxStackSize = 1;
        this.setMaxDamage(durability);
        this.attackDamage = 2.0F + attackDamage;
        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.lostportaltab);
		
		ModItemsInit.ITEMS.add(this);
	}
	
	public float getAttackDamage()
    {
        return this.attackDamage;
    }
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK; 
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	if(handIn == EnumHand.OFF_HAND)
    	{
    		ItemStack itemstack = playerIn.getHeldItem(handIn);
    		playerIn.setActiveHand(handIn);
    		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    	}
    	else
    	{
    		return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
    	}
    }
    
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2, 0));
        }

        return multimap;
    }
}

