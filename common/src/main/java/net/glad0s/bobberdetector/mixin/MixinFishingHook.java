package net.glad0s.bobberdetector.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.glad0s.bobberdetector.mixin_interface.FishingHookAccessor;
import net.glad0s.bobberdetector.multiloader.Platform;
import net.glad0s.bobberdetector.util.ClientPlayerUtil;
import net.glad0s.bobberdetector.util.ServerPlayerUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;

@Mixin(FishingHook.class)
public abstract class MixinFishingHook extends Projectile implements FishingHookAccessor {

    @Shadow
    private boolean biting;

    public MixinFishingHook(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean bobberdetector$isBiting() {
        return biting;
    }

    @WrapOperation(method = "recreateFromPacket", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/FishingHook;getPlayerOwner()Lnet/minecraft/world/entity/player/Player;"))
    private Player shouldIgnore(FishingHook instance, Operation<Player> original) {
        return Platform.Environment.getCurrent() == Platform.Environment.CLIENT
                ? ClientPlayerUtil.getPlayer(original.call(instance))
                : ServerPlayerUtil.getPlayer(original.call(instance));// returns some player (the client player) that is not null
    }

    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/FishingHook;getPlayerOwner()Lnet/minecraft/world/entity/player/Player;"))
    private Player modifyPlayer(FishingHook instance, Operation<Player> original) {
        if (instance.level().isClientSide()) {
            // If the player is null, we set it to something not null (the client player).
            Player p = original.call(instance);
            return p != null ? p : Platform.Environment.getCurrent() == Platform.Environment.CLIENT
                    ? ClientPlayerUtil.getPlayer(original.call(instance))
                    : ServerPlayerUtil.getPlayer(original.call(instance));
        } else {
            return original.call(instance);
        }
    }
}
