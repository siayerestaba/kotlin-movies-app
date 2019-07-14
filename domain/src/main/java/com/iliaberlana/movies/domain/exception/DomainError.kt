package com.iliaberlana.movies.domain.exception

abstract class DomainError : Error()
class NoInternetConnectionException : DomainError()
class NoMoreMoviesException : DomainError()