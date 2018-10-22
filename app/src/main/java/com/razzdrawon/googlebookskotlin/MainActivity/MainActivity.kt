package com.razzdrawon.googlebookskotlin.MainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityView {
    var adapter: BookItemAdapter? = BookItemAdapter(ArrayList<Book>(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var books: ArrayList<Book> = ArrayList<Book>()
        val presenter: MainActivityPresenter = MainActivityPresenter(this)
        presenter.getBookList()

        booksRecyclerView.layoutManager = LinearLayoutManager(this)
        booksRecyclerView.hasFixedSize()
        booksRecyclerView.adapter = adapter
    }

    override fun showWait() {
        progress.visibility = View.VISIBLE
    }

    override fun removeWait() {
        progress.visibility = View.GONE
    }

    override fun onAPIFailure() {
        failureMessage.visibility = View.VISIBLE
    }

    override fun getBookResponseSuccess(books: ArrayList<Book>) {
        this.adapter!!.updateBooks(books)
        failureMessage.setVisibility(View.GONE)
    }

}
