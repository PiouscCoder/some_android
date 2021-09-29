package our.piousc.someandroid.main

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import our.piousc.someandroid.base.BaseActivity
import our.piousc.someandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun onCreateConfigured(savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        mViewBinding?.rvMain?.let {
            it.layoutManager = GridLayoutManager(this,3)
            it.adapter = MainCaseAdapter(this).also { adapter ->
                adapter.setData(CaseRepository.getCaseList(this))
            }
        }
    }
}