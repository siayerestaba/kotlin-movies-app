package com.iliaberlana.movies.domain.exception

sealed class DomainError: Exception() {
    object NoInternetConnectionException : DomainError()
    object NoMoreMoviesException : DomainError()
    object UnknownException: DomainError()
}