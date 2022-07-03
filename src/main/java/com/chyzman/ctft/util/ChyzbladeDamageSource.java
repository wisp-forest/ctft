package com.chyzman.ctft.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;

public class ChyzbladeDamageSource extends DamageSource {
    private boolean isWorthy = true;

    public ChyzbladeDamageSource() {
        super("player");
        this.setOutOfWorld();
        this.setBypassesArmor();
        this.setUnblockable();
    }

    @Override
    public Text getDeathMessage(LivingEntity entity) {
        LivingEntity livingEntity = entity.getPrimeAdversary();
        String baseKey = "death.attack.chyzblade";
        String unworthyKey = baseKey + ".unworthy";
        return isWorthy
                ? Text.translatable(baseKey, entity.getDisplayName(), livingEntity.getDisplayName())
                : Text.translatable(unworthyKey, entity.getDisplayName());
    }

    @Override
    public boolean isSourceCreativePlayer() {
        return true;
    }

    public DamageSource setUnworthy() {
        isWorthy = false;
        return this;
    }
}
