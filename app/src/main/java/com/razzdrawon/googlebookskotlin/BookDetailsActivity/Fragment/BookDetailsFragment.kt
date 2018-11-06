package com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_book_details.*
import javax.inject.Inject

class BookDetailsFragment : DaggerFragment(), BookDetailsFragmentView {

    @Inject
    lateinit var presenter: BookDetailsFragmentPresenter

    companion object {
        fun newInstance(book: Book): BookDetailsFragment {
            val args = Bundle()
            args.putParcelable("Book", book)
            val fragment = BookDetailsFragment()
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book_details, container, false)
        val args = arguments
        val book = args!!.getParcelable<Book>("Book") as Book
        presenter.getBookDetails(book.id!!)
        return view
    }

    override fun showWait() {
        //progress.visibility = View.VISIBLE
    }

    override fun removeWait() {
        //progress.visibility = View.GONE
    }

    override fun onAPIFailure() {
        failure_book_message.visibility = View.VISIBLE
        book_details_layout.visibility = View.GONE
    }

    override fun getBookDetailsSuccess(book: Book) {

        progress.visibility = View.VISIBLE

        tvPublishDate.text = book.volumeInfo?.publishedDate
        tvAuthors.text = book.volumeInfo?.authorsString()
        tvDescription.text = book.volumeInfo?.description
        if (book.volumeInfo?.imageLinks?.smallThumbnail != null && book.volumeInfo?.imageLinks.smallThumbnail != "") {
            Picasso.get().load(book.volumeInfo?.imageLinks?.smallThumbnail).into(imgBookCover)
        } else {
            imgBookCover.setImageResource(R.mipmap.ic_launcher)
        }

        progress.visibility = View.GONE
    }

}
