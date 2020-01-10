package zhouds.festec.com;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import zhouds.festec.latte.core2.delegate.LatteDelegate;
import zhouds.festec.latte.core2.net.RestClient;
import zhouds.festec.latte.core2.net.callback.IError;
import zhouds.festec.latte.core2.net.callback.IFailure;
import zhouds.festec.latte.core2.net.callback.IRequest;
import zhouds.festec.latte.core2.net.callback.ISuccess;

/**
 * 创建者 zds
 * 创建时间 2020/1/8 0008  16:21
 *
 * @描述
 **/
public class ExampleDelegate extends LatteDelegate {

    private static final String TAG = "zds";


    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View rootView) {

        testRestClient();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    private void testRestClient() {
        RestClient.builder()
                .url("/box_cms_v3/get_data_bykey.php?")
                .params("model", "p212")
                .params("up_lan_mac", "00226D676705")
                .params("workshop", "-1")
                .loaderDialog(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i(TAG, "onSuccess: " + response);
                    }
                })
                .faliure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .request(new IRequest() {
                    @Override
                    public void onRequestStart() {

                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .build()
                .get();
    }
}
