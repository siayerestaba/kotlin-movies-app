package com.iliaberlana.movies.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.iliaberlana.movies.ui.commons.loadImage
import com.iliaberlana.movies.ui.model.UIMovie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer
{
    fun bind(movie: UIMovie) {
        containerView.movie_image.loadImage(movie.image)
        containerView.movie_name.text = movie.name
        // TODO Rating!

    }
}