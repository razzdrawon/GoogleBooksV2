package com.razzdrawon.googlebookskotlin.MainActivity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainActivityView {

    @Inject
    lateinit var presenter: MainActivityPresenter

    lateinit var adapter: BookItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getBookList()

        adapter = BookItemAdapter(ArrayList<Book>(),this)
        booksRecyclerView.hasFixedSize()
        booksRecyclerView.layoutManager = LinearLayoutManager(this)
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

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getBookResponseSuccess(books: ArrayList<Book>) {
        this.adapter.updateBooks(books)
        failureMessage.setVisibility(View.GONE)
    }

}
