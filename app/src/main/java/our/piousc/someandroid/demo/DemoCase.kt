package our.piousc.someandroid.demo

import android.content.Context
import android.widget.Toast
import our.piousc.someandroid.base.case_.CaseItemBean
import our.piousc.someandroid.base.case_.ICaseProvider
import our.piousc.someandroid.base.case_.OnCaseClickListener

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
class DemoCase(override val context: Context) : ICaseProvider {

    override fun getName(): String {
        return "DemoCase"
    }

    override fun getClickListener(): OnCaseClickListener {
        return object : OnCaseClickListener {
            override fun onCaseClick(position: Int, item: CaseItemBean?) {
                Toast.makeText(context, getName(), Toast.LENGTH_SHORT).show()
            }

        }
    }
}