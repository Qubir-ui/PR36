package com.example.listfragments.placeholder

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import java.util.HashMap
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.example.listfragments.MainActivity
import com.example.listfragments.R


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    val colorNames = MainActivity.context?.resources?.getStringArray(R.array.colorNames)
    val colorValues = MainActivity.context?.resources?.getStringArray(R.array.colorValues)

    init {
        // Add some sample items.
        if (colorNames != null) {
            for (i in colorNames) {
                addItem(createPlaceholderItem(i))
            }
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
    }

    private fun createPlaceholderItem(position: String): PlaceholderItem {
        return PlaceholderItem(position)
    }


    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val content: String) {
        override fun toString(): String = content
    }
}