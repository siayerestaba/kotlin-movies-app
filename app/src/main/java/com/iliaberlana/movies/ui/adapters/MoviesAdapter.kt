package com.iliaberlana.movies.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.iliaberlana.movies.ui.presenters.MainPresenter

class MoviesAdapter(
    presenter: MainPresenter,
    val fetchNewPage: () -> Unit
): RecyclerView.Adapter<MoviesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MoviesViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MoviesViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
