package zhouds.festec.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import zhouds.festec.latte.core2.app.Latte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latte.init(this).withApiHost("http://127.0.0.1").configure();

    }
}
