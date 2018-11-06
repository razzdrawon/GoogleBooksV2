package com.razzdrawon.googlebookskotlin.MainActivity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.razzdrawon.googlebookskotlin.BookDetailsActivity.BookDetailsActivity
import com.razzdrawon.googlebookskotlin.R
import com.razzdrawon.googlebookskotlin.models.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_item.view.*
import android.os.Bundle

class BookItemAdapter(private val books: ArrayList<Book>, val context: Context) :
    RecyclerView.Adapter<BookItemAdapter.MyViewHolder>() {

    companion object {
        val BOOK_LIST = "book_list"
        val BOOK_POSITION = "position"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return MyViewHolder(v, books)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(books[position], position)
    }

    override fun getItemCount() = books.size

    class MyViewHolder(itemView: View, private val books: ArrayList<Book>) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        fun bindItems(book: Book, position: Int) {

            itemView.tvTitle.text = book.volumeInfo?.title ?: ""
            itemView.tvPublishDate.text = book.volumeInfo?.publishedDate ?: ""
            if (book.volumeInfo?.imageLinks?.smallThumbnail != null && book.volumeInfo?.imageLinks?.smallThumbnail != "") {
                Picasso.get().load(book.volumeInfo?.imageLinks?.smallThumbnail).into(itemView.imgThumbnail)
            } else {
                itemView.imgThumbnail.setImageResource(R.mipmap.ic_launcher)
            }

            itemView.setOnClickListener(
                {
                    val intent: Intent = Intent(context, BookDetailsActivity::class.java)
                    val extras = Bundle()
                    intent.putExtra(BOOK_LIST, books)
                    intent.putExtra(BOOK_POSITION, position)
                    intent.putExtras(extras)
                    context.startActivity(intent)
                }
            )
        }
    }

    fun updateBooks(books: List<Book>) {
        if (books != null) {
            this.books.addAll(books);
            notifyDataSetChanged();
        }
    }
}