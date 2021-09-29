package our.piousc.someandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    var mViewBinding : VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateConfigured()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mViewBinding == null) {
            mViewBinding = createViewBinding()
        }
        return mViewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView(savedInstanceState)
    }

    /**
     * onCreate 时调用
     */
    abstract fun onCreateConfigured()

    /**
     * 初始化 view
     * @param savedInstanceState Bundle?
     */
    abstract fun onInitView(savedInstanceState: Bundle?)

    /**
     * 反射创建 ViewBinding
     * @return VB?
     */
    private fun createViewBinding(): VB? {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)
            return method.invoke(null, layoutInflater) as VB
        }
        return null
    }
}