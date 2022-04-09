package com.example.listfragments

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.listfragments.placeholder.PlaceholderContent

class MainActivity : AppCompatActivity() {
    companion object {
        var context: Context? = null
        var activity: MainActivity? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        activity = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout: LinearLayout = findViewById(R.id.Layout)
        if(savedInstanceState != null){
            color = savedInstanceState.getString("color").toString()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment1, ColorListFragment()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment2, ColoredFragment.newInstance(color)).commit()
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> layout.orientation = LinearLayout.VERTICAL;
            Configuration.ORIENTATION_LANDSCAPE -> layout.orientation = LinearLayout.HORIZONTAL;
            else -> ""
        }
    }
    fun changeColor(Color: String){
        color = Color
        supportFragmentManager.beginTransaction().replace(R.id.fragment2, ColoredFragment.newInstance(color)).commit()

    }
    var color: String = "WHITE"
    override fun onSaveInstanceState(outState: Bundle) {
        // Сохраняем его состояние
        outState.run{
            outState.putString("color", color)}
        // всегда вызывайте суперкласс для сохранения состояний видов
        super.onSaveInstanceState(outState)
    }
}