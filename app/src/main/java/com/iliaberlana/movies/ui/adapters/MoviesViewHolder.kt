package com.iliaberlana.movies.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.iliaberlana.movies.ui.model.UIMovie
import kotlinx.android.extensions.LayoutContainer

class MoviesViewHolder (
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer
{
    fun bind(movie: UIMovie) {
        TODO("not implemented")
    }
}