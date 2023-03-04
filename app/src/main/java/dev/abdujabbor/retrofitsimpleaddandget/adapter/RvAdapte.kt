package dev.abdujabbor.retrofitsimpleaddandget.adapter

import dev.abdujabbor.retrofitsimpleaddandget.databinding.RvItemBinding
import dev.abdujabbor.retrofitsimpleaddandget.models.MyModel
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RvAdapter(var list: ArrayList<MyModel>) :
    RecyclerView.Adapter<RvAdapter.VH>() {
    inner class VH(var itemViewBinding: RvItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(list: MyModel, position: Int) {
            itemViewBinding.matn.text = list.matn
            itemViewBinding.sarlavha.text = list.sarlavha

            itemViewBinding.sana.text = list.oxirgi_muddat
            itemViewBinding.xolat.text = list.holat

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        return VH(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
