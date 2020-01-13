package zhouds.festec.latte.core2.app;

import android.content.Context;

import java.util.ArrayList;
import java.util.WeakHashMap;

import okhttp3.Interceptor;

/**
 * 创建者 zds
 * 创建时间 2020/1/7 0007  15:27
 *
 * @描述
 **/
public class Configurator {

    private static final WeakHashMap<Object, Object> LATTE_CONFIGS = new WeakHashMap<>();
    /*拦截器 用于拦截URL请求，模拟返回json数据*/
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    /************ 完美单例 start 懒汉模式***************/

    public static Configurator getInstance() {
        return Holder.INTANCE;
    }

    private static class Holder {
        private static final Configurator INTANCE = new Configurator();
    }

    /************ 完美单例 end***************/

    final WeakHashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    public final Configurator withApplication(Context context) {
        LATTE_CONFIGS.put(ConfigKeys.APPLICATION_CONTEXT.name(), context);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;
    }

    private void checkConfigurataion() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * @param key
     * @param <T>
     * @return
     */
    final <T> T getConfiguration(Enum<ConfigKeys> key) {
        checkConfigurataion();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
