package zhouds.festec.com;

import android.app.Application;

import zhouds.festec.latte.core2.app.Latte;

/**
 * 创建者 zds
 * 创建时间 2020/1/10 0010  10:12
 *
 * @描述
 **/
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this).withApiHost("http://192.168.130.36/").configure();
    }
}
