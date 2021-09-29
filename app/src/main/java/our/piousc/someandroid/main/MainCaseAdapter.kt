package our.piousc.someandroid.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import our.piousc.someandroid.R
import our.piousc.someandroid.base.case_.CaseItemBean
import our.piousc.someandroid.databinding.ItemMainCaseBinding

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
class MainCaseAdapter(private val context:Context) : RecyclerView.Adapter<MainCaseAdapter.MainCaseViewHolder>() {

    private var mutableList: MutableList<CaseItemBean>? = null

    fun setData(mutableList: MutableList<CaseItemBean>){
        this.mutableList = mutableList
        notifyItemRangeChanged(0,mutableList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCaseViewHolder {
        val binding = ItemMainCaseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainCaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainCaseViewHolder, position: Int) {
        holder.binding.let {
            val item = mutableList?.get(position)
            it.caseName.text = item?.name
            it.caseName.setOnClickListener {
                item?.onClickListener?.onCaseClick(position,item)
            }
            if (position % 2 ==0){
                it.caseName.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_200))
            } else {
                it.caseName.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))
            }
        }
    }

    override fun getItemCount(): Int {
        return mutableList?.size ?: 0
    }

    inner class MainCaseViewHolder(val binding: ItemMainCaseBinding) : RecyclerView.ViewHolder(binding.root)
}