import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.usecases.ListMovies
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ListMoviesTest {

    @Test
    fun `call MovieRepository when execute ListMovies`() = runBlocking {
        val movieRepository = mockk<MovieRepository>(relaxed = true)
        val listMovies = ListMovies(movieRepository)

        listMovies(1)

        coVerify { movieRepository.listMovies(1) }
    }
}