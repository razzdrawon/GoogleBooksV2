package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment.BookDetailsFragment
import com.razzdrawon.googlebookskotlin.models.Book

class BookDetailsPagerAdapter(fragmentManager: FragmentManager, private val books: ArrayList<Book>) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return BookDetailsFragment.newInstance(books[position])
    }

    override fun getCount(): Int {
        return books.size
    }

}