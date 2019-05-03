package com.example.evaluacion2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluacion2.fragments.Buttonfragment
import com.example.evaluacion2.fragments.GalleryFragment

class MainActivity : AppCompatActivity(), Buttonfragment.OnSelectOption {

    override fun onAction(id: Int) {
        var content:Int= when (id) {
            1 -> {
                R.drawable.img1
            }
            2 -> {
                R.drawable.img2
            }
            3 -> {
                R.drawable.img3
            }
            else -> {
                R.drawable.img3
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, GalleryFragment.newInstance(content.toString()))
                .addToBackStack("Co")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = Buttonfragment.newInstace(
                "Back",
                "Next"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}
