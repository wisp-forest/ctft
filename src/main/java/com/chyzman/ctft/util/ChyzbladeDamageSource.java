package com.chyzman.ctft.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ChyzbladeDamageSource extends DamageSource {
    private boolean isWorthy;

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
                ? new TranslatableText(baseKey, entity.getDisplayName(), livingEntity.getDisplayName())
                : new TranslatableText(unworthyKey, entity.getDisplayName());
    }

    public DamageSource setUnworthy() {
        isWorthy = false;
        return this;
    }
}
