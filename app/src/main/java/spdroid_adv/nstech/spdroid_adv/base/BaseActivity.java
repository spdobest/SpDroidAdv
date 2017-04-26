package spdroid_adv.nstech.spdroid_adv.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spdroid_adv.nstech.spdroid_adv.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
