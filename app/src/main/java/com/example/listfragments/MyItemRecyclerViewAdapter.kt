package com.example.listfragments

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.listfragments.placeholder.PlaceholderContent.PlaceholderItem
import com.example.listfragments.databinding.FragmentColorListBinding
import android.graphics.ColorSpace.Model
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>, private val color: Array<String>?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    var ma: MainActivity? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentColorListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    val colorHex = MainActivity.context?.resources?.getStringArray(R.array.colorHex)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item.content
        holder.itemView.setBackgroundColor(Color.parseColor(colorHex!![position].toString()))
        holder.itemView.setOnClickListener {
            MainActivity.activity?.changeColor(colorHex!![position].toString())
        }
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentColorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }


}