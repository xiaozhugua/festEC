package zhouds.festec.com;

import zhouds.festec.latte.core2.activity.ProxyActivity;
import zhouds.festec.latte.core2.delegate.LatteDelegate;

public class ExampleActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
