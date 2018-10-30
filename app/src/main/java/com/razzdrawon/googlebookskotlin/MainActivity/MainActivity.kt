package com.razzdrawon.googlebookskotlin.MainActivity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AbsListView
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

    internal var isScrolling: Boolean = false
    internal var currentItems: Int = 0
    internal var totalItems:Int = 0
    internal var scrollOutItems:Int = 0

    val layoutManager : GridLayoutManager = GridLayoutManager(this, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getBookList("android", 0, 15)

        adapter = BookItemAdapter(ArrayList<Book>(),this)
        booksRecyclerView.hasFixedSize()
        booksRecyclerView.layoutManager = layoutManager
        booksRecyclerView.adapter = adapter
        booksRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItems = layoutManager.getChildCount()
                totalItems = layoutManager.getItemCount()
                scrollOutItems = layoutManager.findFirstCompletelyVisibleItemPosition()

                if (isScrolling && currentItems + scrollOutItems == totalItems) {
                    isScrolling = false
                    presenter.getBookList("android", totalItems, 5)
                }
            }
        })
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
