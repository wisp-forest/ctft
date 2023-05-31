package com.chyzman.ctft.util;

import com.chyzman.ctft.Ctft;
import net.minecraft.util.Identifier;

public class CtftRegistryHelper {
    public static Identifier id(String path) {
        return new Identifier(Ctft.MODID, path);
    }

}