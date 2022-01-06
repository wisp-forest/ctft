package com.chyzman.ctft.compat;

import com.chyzman.ctft.items.MiscInit;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class CtftReiCompat implements REIClientPlugin {
    @Override
    public void registerEntries(EntryRegistry registry) {
        registry.removeEntry(EntryStacks.of(MiscInit.CHYZBLADE));
        registry.removeEntry(EntryStacks.of(MiscInit.CTFTICON));
    }
}
