package com.iliaberlana.movies.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.iliaberlana.movies.R
import com.iliaberlana.movies.ui.commons.inflate
import com.iliaberlana.movies.ui.model.UIMovie

class MoviesAdapter(
    val fetchNewPage: () -> Unit
) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var distance: Int = 6
    private var waitingForNextPage: Boolean = false

    private var movies: MutableList<UIMovie> = ArrayList()

    fun addAll(collection: Collection<UIMovie>) {
        setWaitingForNextPageFalse()
        movies.addAll(collection)
        notifyDataSetChanged()
    }

    fun clean() {
        setWaitingForNextPageFalse()
        movies.clear()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (!waitingForNextPage) {
            if (position.plus(distance) >= itemCount) {
                setWaitingForNextPageTrue()
                fetchNewPage()
            }
        }

        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(parent.inflate(R.layout.movie_item))

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(movies.get(position))

    override fun getItemCount(): Int = movies.size

    private fun setWaitingForNextPageFalse() {
        waitingForNextPage = false
    }

    private fun setWaitingForNextPageTrue() {
        waitingForNextPage = true
    }

}
