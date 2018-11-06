package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.razzdrawon.googlebookskotlin.MainActivity.BookItemAdapter
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import javax.inject.Inject

class BookDetailsActivity : DaggerAppCompatActivity(), BookDetailsActivityView {

    @Inject
    lateinit var presenter: BookDetailsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val intent : Intent = intent
        val bookId = intent.getStringExtra(BookItemAdapter.BOOK_ID)
        presenter.getBookDetails(bookId)
    }

    override fun showWait() {
        progressDetails.setVisibility(View.VISIBLE)
    }

    override fun removeWait() {
        progressDetails.setVisibility(View.GONE)
    }

    override fun onAPIFailure() {
        failure_book_message.setVisibility(View.VISIBLE)
        book_details_layout.setVisibility(View.GONE)
    }

    override fun getBookDetailsSuccess(book: Book) {
        tvPublishDate.text = book.volumeInfo?.publishedDate
        tvAuthors.text = book.volumeInfo?.authorsString()
        tvDescription.text = book.volumeInfo?.description
        if (book.volumeInfo?.imageLinks?.smallThumbnail != null && book.volumeInfo?.imageLinks.smallThumbnail != "") {
            Picasso.get().load(book.volumeInfo?.imageLinks?.smallThumbnail).into(imgBookCover)
        } else {
            imgBookCover.setImageResource(R.mipmap.ic_launcher)
        }
    }

}
