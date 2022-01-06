package com.chyzman.ctft;

import com.chyzman.ctft.items.PickaxeInit;
import com.chyzman.ctft.items.SwordInit;
import com.chyzman.ctft.registries.FuelInit;
import com.chyzman.ctft.util.CtftConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public enum CtftItemType {

    SWORD(basicInit(SwordInit.class, "SWORDS")),
    PICKAXE(basicInit(PickaxeInit.class, "PICKAXES"));

    public final String id;

    private final Runnable initializer;
    private boolean enabled;

    CtftItemType(Runnable initializer) {
        this.initializer = initializer;
        this.enabled = false;

        this.id = name().toLowerCase() + "s";
    }

    public boolean enabled() {
        return enabled;
    }

    public void init() {
        Ctft.LOGGER.info("Initializing ctft {}", id);
        initializer.run();
    }

    public static void readEnabledStates(CtftConfig config) {
        for (var type : CtftItemType.values()) {
            type.enabled = config.enabledItemTypes.get(type.id);
        }
    }

    private static Runnable basicInit(Class<?> initializer, String fuelInitName) {
        return () -> {
            try {
                callStaticMethod(initializer, "INIT");
                callStaticMethod(FuelInit.class, fuelInitName);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                Ctft.LOGGER.error("Could not initialize '{}'", initializer, e);
            }
        };
    }

    private static void callStaticMethod(Class<?> clazz, String name) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        var method = clazz.getDeclaredMethod(name);
        if (!Modifier.isPublic(method.getModifiers()) || !Modifier.isStatic(method.getModifiers())) return;

        method.invoke(null);
    }
}
