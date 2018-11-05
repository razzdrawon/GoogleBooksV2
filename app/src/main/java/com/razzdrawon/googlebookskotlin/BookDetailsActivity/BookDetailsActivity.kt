package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import android.content.Intent
import android.os.Bundle
import com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment.BookDetailsFragment
import com.razzdrawon.googlebookskotlin.MainActivity.BookItemAdapter
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class BookDetailsActivity : DaggerAppCompatActivity(), BookDetailsActivityView {

    @Inject
    lateinit var presenter: BookDetailsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val intent : Intent = intent

        val books = intent.extras.getParcelableArrayList<Book>(BookItemAdapter.BOOK_LIST) as ArrayList<Book>
        val position = intent.extras.getInt(BookItemAdapter.BOOK_POSITION)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, BookDetailsFragment().newInstance(books.get(position))).commit()
    }

    override fun showLoaded(message: String) {

    }
}
