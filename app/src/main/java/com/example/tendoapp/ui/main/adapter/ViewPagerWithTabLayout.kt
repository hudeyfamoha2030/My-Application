package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.ui.main.view.fragments.InfoTabFragment
import com.example.tendoapp.ui.main.view.fragments.ReviewsTabFragment

class ViewPagerWithTabLayout(fm: FragmentManager, context: Context): FragmentStatePagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0-> {return "Info"}
            1-> {return "Reviews"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                val logintabfragment= InfoTabFragment()
                return logintabfragment
            }
            1->{
                val signuptabfragment= ReviewsTabFragment()
                return signuptabfragment
            }

        }
        return null!!
    }


}