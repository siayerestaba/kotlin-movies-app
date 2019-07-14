package com.iliaberlana.movies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.Toast
import com.iliaberlana.movies.R
import com.iliaberlana.movies.ui.adapters.MoviesAdapter
import com.iliaberlana.movies.ui.commons.toast
import com.iliaberlana.movies.ui.model.UIMovie
import com.iliaberlana.movies.ui.presenters.MainPresenter
import com.iliaberlana.movies.ui.presenters.views.ViewMain
import kotlinx.android.synthetic.main.list_withprogressbar_text.*
import org.koin.android.scope.currentScope

class MainActivity : AppCompatActivity(), ViewMain {
    private val presenter: MainPresenter by currentScope.inject()
    private lateinit var adapter: MoviesAdapter

    override fun onResume() {
        super.onResume()
        presenter.view = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_withprogressbar_text)

        presenter.create()

        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        adapter = MoviesAdapter({presenter.renderMoreMovies()})

        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

        movies_recyclerview.adapter = adapter
        movies_recyclerview.layoutManager = layoutManager

        movies_swiperefreshlayout.setOnRefreshListener { presenter.refresh() }
    }

    override fun listMovies(movies: List<UIMovie>) {
        adapter.addAll(movies)
    }

    override fun cleanMovies() {
        adapter.clean()
    }

    override fun hideLoading() {
        movies_swiperefreshlayout.isRefreshing = false
        movies_progressbar.visibility = View.GONE
    }

    override fun showLoading() {
        movies_progressbar.visibility = View.VISIBLE
    }

    override fun showToastMessage(stringId: Int) {
        this.toast(this, resources.getString(stringId))
    }

    override fun showErrorCase(stringId: Int) {
        movies_texterror.text = resources.getString(stringId)
        movies_texterror.visibility = View.VISIBLE
    }

    override fun hideErrorCase() {
        movies_texterror.visibility = View.GONE
    }
}
