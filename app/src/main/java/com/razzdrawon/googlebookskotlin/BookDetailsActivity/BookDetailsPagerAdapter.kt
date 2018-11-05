package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment.BookDetailsFragment

class BookDetailsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return BookDetailsFragment()
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}