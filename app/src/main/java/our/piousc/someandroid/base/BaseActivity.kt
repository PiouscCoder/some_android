package our.piousc.someandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Created by qianbingbing on 2021/9/28
 * Description：
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    var mViewBinding : VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType){
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)
            mViewBinding = method.invoke(null, layoutInflater) as VB
            mViewBinding?.run {
                setContentView(root)
            }
        }
        onCreateConfigured(savedInstanceState)
    }

    abstract fun onCreateConfigured(savedInstanceState: Bundle?)
}