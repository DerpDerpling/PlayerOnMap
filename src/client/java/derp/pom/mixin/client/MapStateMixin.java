package derp.pom.mixin.client;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MapState.class)
public class MapStateMixin {

	@Redirect(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;contains(Lnet/minecraft/item/ItemStack;)Z"))
	private boolean redirectContainsCheck(PlayerInventory instance, ItemStack stack) {
		// Always return true to skip the inventory check
		return true;
	}
}

