package zhouds.festec.latte.core2.net.callback;

/**
 * 创建者 zds
 * 创建时间 2020/1/9 0009  17:24
 *
 * @描述
 **/
public interface IError {
    void onError(int code, String msg);
}
