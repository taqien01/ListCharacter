package com.aplikasi.listcharacter.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.listcharacter.R
import com.aplikasi.listcharacter.databinding.ListCharBinding
import com.aplikasi.listcharacter.model.Results
import com.bumptech.glide.Glide

class ListCharacterAdapter(var list: List<Results>) : RecyclerView.Adapter<ListCharacterAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(val binding: ListCharBinding): RecyclerView.ViewHolder(binding.root)

    var mInterface: Interface? = null

    fun setInterface(mInterface: Interface?) {
        this.mInterface = mInterface
    }

    interface Interface {
        fun onClickDetail(item: Results)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCharacterAdapter.ViewHolder {
        val binding = ListCharBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListCharacterAdapter.ViewHolder, position: Int) {
        var oneChar = list[position]

        holder.binding.txtName.text = oneChar.name
        holder.binding.txtSpecies.text = oneChar.species
        holder.binding.txtStatus.text = oneChar.status

        Glide.with(context).load(oneChar.image).into(holder.binding.image)

        if (oneChar.status!! == "Alive"){
            holder.binding.txtStatus.background = context.resources.getDrawable(R.drawable.btn_rectangle, null)
        }else{
            holder.binding.txtStatus.background = context.resources.getDrawable(R.drawable.btn_rectangle_red, null)
        }

        holder.binding.container.setOnClickListener {
            mInterface!!.onClickDetail(oneChar)
//            Log.e("ADapter", "Click ${oneChar.name}")
//            Toast.makeText(context, "CLick "+oneChar.name, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}