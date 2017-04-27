package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import spdroid_adv.nstech.spdroid_adv.R;
import spdroid_adv.nstech.spdroid_adv.databinding.ActivityDatabindingBinding;

/**
 * Created by webwerks on 27/4/17.
 */

public class MvvmActivity extends AppCompatActivity {

    private static final String TAG = "MvvmActivity";

    private ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        User user = new User();
        user.setName("Learn2Crack");
        binding.setUser(user);
        binding.setActivity(this);
    }

    public void onButtonClick(String email){
        Log.d(TAG, "Email :" +binding.getUser().getEmail());
        Log.d(TAG, "Email : "+email);
        Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
    }
}
