package zhouds.festec.latte.core2.app;

import java.util.WeakHashMap;

/**
 * 创建者 zds
 * 创建时间 2020/1/7 0007  15:27
 *
 * @描述
 **/
public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    /************ 完美单例 start 懒汉模式***************/

    public static Configurator getInstance() {
        return Holder.INTANCE;
    }

    private static class Holder {
        private static final Configurator INTANCE = new Configurator();
    }

    /************ 完美单例 end***************/

    final WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfigurataion() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * @param key
     * @param <T>
     * @return
     */
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfigurataion();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
