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

class BookItemAdapter(private val books: ArrayList<Book>, val context: Context) :
    RecyclerView.Adapter<BookItemAdapter.MyViewHolder>() {

    companion object {
        val BOOK_ID = "book_id"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(books[position])
    }

    override fun getItemCount() = books.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        fun bindItems(book: Book) {
            itemView.tvTitle.text = book.volumeInfo?.title ?: ""
            itemView.tvPublishDate.text = book.volumeInfo?.publishedDate ?: ""
            Picasso.get().load(book.volumeInfo?.imageLinks?.smallThumbnail).into(itemView.imgThumbnail)
            itemView.setOnClickListener(
                {
                    val intent: Intent = Intent(context, BookDetailsActivity::class.java)
                    intent.putExtra(BOOK_ID, book.id)
                    context.startActivity(intent)
                }
            )
        }
    }

    fun updateBooks(books: List<Book>) {
        if(books != null){
            this.books.addAll(books);
            notifyDataSetChanged();
        }
    }
}