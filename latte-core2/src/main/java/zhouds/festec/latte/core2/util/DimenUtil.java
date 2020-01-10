package zhouds.festec.latte.core2.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import zhouds.festec.latte.core2.app.Latte;

/**
 * 创建者 zds
 * 创建时间 2020/1/10 0010  12:07
 *
 * @描述
 **/
public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

}
