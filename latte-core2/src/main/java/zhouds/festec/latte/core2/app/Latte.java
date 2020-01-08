package zhouds.festec.latte.core2.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * 创建者 zds
 * 创建时间 2020/1/7 0007  15:24
 *
 * @描述
 **/
public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
