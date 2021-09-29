package our.piousc.someandroid.main

import android.content.Context
import our.piousc.someandroid.base.case_.CaseItemBean
import our.piousc.someandroid.demo.DemoCase
import our.piousc.someandroid.base.case_.ICaseProvider
import our.piousc.someandroid.demo.DemoCase2

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
object CaseRepository {


    /**
     * 把继承 ICaseProvider 的 case ，注册到这里
     * @param context Context
     * @return MutableList<ICaseProvider>
     */
   private fun registerCase(context: Context):MutableList<ICaseProvider>{
        return mutableListOf(
            DemoCase(context),
            DemoCase2(context)
        )
    }

    fun getCaseList(context: Context): MutableList<CaseItemBean> {
        return registerCase(context).map {
            CaseItemBean(it.getName(),it.getClickListener())
        }.toMutableList()
    }
}