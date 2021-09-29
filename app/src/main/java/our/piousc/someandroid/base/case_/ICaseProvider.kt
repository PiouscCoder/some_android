package our.piousc.someandroid.base.case_

import android.content.Context

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
interface ICaseProvider {

    val context: Context

    fun getName():String

    fun getClickListener(): OnCaseClickListener
}