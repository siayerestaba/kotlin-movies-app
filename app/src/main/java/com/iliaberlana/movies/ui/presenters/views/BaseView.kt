package com.iliaberlana.movies.ui.presenters.views

interface BaseView {
    fun hideLoading()
    fun showLoading()

    fun showToastMessage(stringId: Int)

    fun showEmptyCase()
    fun hideEmptyCase()
}