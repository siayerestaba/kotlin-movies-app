package com.iliaberlana.movies.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.iliaberlana.movies.R
import com.iliaberlana.movies.ui.adapters.MoviesAdapter
import com.iliaberlana.movies.ui.presenters.MainPresenter
import kotlinx.android.synthetic.main.list_progressbar_emptytext.*
import org.koin.android.scope.currentScope

class MainActivity : AppCompatActivity() {
    private val presenter: MainPresenter by currentScope.inject()
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_progressbar_emptytext)

        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        //adapter = MoviesAdapter(presenter, {presenter.renderMoreMovies()})

        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

        //movies_recyclerview.adapter = adapter
        //movies_recyclerview.layoutManager = layoutManager
    }
}
