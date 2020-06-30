package com.swetajain.headandtails

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.swetajain.headandtails.data.AndroidImageAssets
import com.swetajain.headandtails.data.BodyPartFragment

class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val headFragment = BodyPartFragment()
        headFragment.setImageIds(AndroidImageAssets.heads)
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.head_container, headFragment)
            .commit()

        //create and display head and leg fragments

        val bodyFragment = BodyPartFragment()
        bodyFragment.setImageIds(AndroidImageAssets.bodies)
        fragmentManager.beginTransaction()
            .add(R.id.body_container, bodyFragment)
            .commit()

        val legFragment = BodyPartFragment()
        legFragment.setImageIds(AndroidImageAssets.legs)
        fragmentManager.beginTransaction()
            .add(R.id.leg_container, legFragment)
            .commit()


    }
}