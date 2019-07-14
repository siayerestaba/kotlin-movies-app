package com.iliaberlana.movies.domain.exception

sealed class DomainError: Exception() {
    class NoInternetConnectionException : DomainError()
    object NoMoreMoviesException : DomainError()
    object UnknownException: DomainError()
}