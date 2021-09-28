package our.piousc.someandroid

import android.os.Bundle
import android.widget.Toast
import our.piousc.someandroid.base.BaseActivity
import our.piousc.someandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun onCreateConfigured(savedInstanceState: Bundle?) {
        mViewBinding?.tvText?.setOnClickListener {
            Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show()
        }
    }
}