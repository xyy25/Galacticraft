package micdoodle8.mods.galacticraft.core.tile;

import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.multiblock.IMultiBlock;
import universalelectricity.prefab.multiblock.TileEntityMulti;

public class GCCoreTileEntitySpaceStationBase extends TileEntityMulti implements IMultiBlock
{
	public String ownerUsername = "bobby";

    @Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.ownerUsername = par1NBTTagCompound.getString("ownerUsername");
    }

    @Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
    	par1NBTTagCompound.setString("ownerUsername", this.ownerUsername);
    }
    
    public void setOwner(String username)
    {
    	this.ownerUsername = username;
    }
    
    public String getOwner()
    {
    	return this.ownerUsername;
    }

	@Override
	public boolean onActivated(EntityPlayer entityPlayer) 
	{
		return false;
	}

	@Override
	public void onCreate(Vector3 placedPosition) 
	{
		this.mainBlockPosition = placedPosition;
		
		for (int y = 1; y < 3; y++)
		{
			Vector3 vecToAdd = Vector3.add(placedPosition, new Vector3(0, y, 0));
			
			if (!vecToAdd.isEqual(placedPosition))
			{
				GCCoreBlocks.dummyBlock.makeFakeBlock(this.worldObj, vecToAdd, placedPosition, 1);
			}
		}
	}

	@Override
	public void onDestroy(TileEntity callingBlock) 
	{
	}
}
