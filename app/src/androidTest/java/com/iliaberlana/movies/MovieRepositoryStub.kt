package com.iliaberlana.movies

import arrow.core.Either
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.framework.moviebd.model.MovieDB
import com.iliaberlana.movies.framework.moviebd.model.toMovie
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MovieRepositoryUnknownStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.UnknownException)
    }
}

class MovieRepositoryNoInternetConnectionStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.NoInternetConnectionException)
    }
}

class MovieRepositoryNoMoreMoviesStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.NoMoreMoviesException)
    }
}

class MovieRepositoryStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        val listMoviesDB = jsonToList()

        return Either.right(listMoviesDB.map { it.toMovie() })
    }

    fun jsonToList(): List<MovieDB> {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, MovieDB::class.java)
        val adapter: JsonAdapter<List<MovieDB>> = moshi.adapter(listType)
        return adapter.fromJson(json)?: emptyList()
    }

    private val json = "[{\n" +
                "\t\"original_name\": \"See No Evil: The Moors Murders\",\n" +
                "\t\"genre_ids\": [18],\n" +
                "\t\"name\": \"See No Evil: The Moors Murders\",\n" +
                "\t\"popularity\": 545.713,\n" +
                "\t\"origin_country\": [\"GB\"],\n" +
                "\t\"vote_count\": 10,\n" +
                "\t\"first_air_date\": \"2006-05-14\",\n" +
                "\t\"backdrop_path\": \"\\/7AKhSfJHnVi0zXQS4eJirHDs22p.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 11634,\n" +
                "\t\"vote_average\": 5.5,\n" +
                "\t\"overview\": \"The dramatisation of one of the most notorious killing sprees in British history.\",\n" +
                "\t\"poster_path\": \"\\/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Legion\",\n" +
                "\t\"genre_ids\": [10759, 10765],\n" +
                "\t\"name\": \"Legion\",\n" +
                "\t\"popularity\": 341.231,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 575,\n" +
                "\t\"first_air_date\": \"2017-02-08\",\n" +
                "\t\"backdrop_path\": \"\\/87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 67195,\n" +
                "\t\"vote_average\": 7.6,\n" +
                "\t\"overview\": \"David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he’s confronted with the possibility that the voices he hears and the visions he sees might be real.\",\n" +
                "\t\"poster_path\": \"\\/vT0Zsbm4GWd7llNjgWEtwY0CqOv.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Arrow\",\n" +
                "\t\"genre_ids\": [80, 18, 9648, 10759],\n" +
                "\t\"name\": \"Arrow\",\n" +
                "\t\"popularity\": 332.964,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 2529,\n" +
                "\t\"first_air_date\": \"2012-10-10\",\n" +
                "\t\"backdrop_path\": \"\\/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1412,\n" +
                "\t\"vote_average\": 5.8,\n" +
                "\t\"overview\": \"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\",\n" +
                "\t\"poster_path\": \"\\/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Stranger Things\",\n" +
                "\t\"genre_ids\": [18, 9648, 10765],\n" +
                "\t\"name\": \"Stranger Things\",\n" +
                "\t\"popularity\": 310.26,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 2408,\n" +
                "\t\"first_air_date\": \"2016-07-15\",\n" +
                "\t\"backdrop_path\": \"\\/56v2KjBlU4XaOv9rVYEQypROD7P.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 66732,\n" +
                "\t\"vote_average\": 8.3,\n" +
                "\t\"overview\": \"When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.\",\n" +
                "\t\"poster_path\": \"\\/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"The Flash\",\n" +
                "\t\"genre_ids\": [18, 10765],\n" +
                "\t\"name\": \"The Flash\",\n" +
                "\t\"popularity\": 284.879,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 2744,\n" +
                "\t\"first_air_date\": \"2014-10-07\",\n" +
                "\t\"backdrop_path\": \"\\/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 60735,\n" +
                "\t\"vote_average\": 6.7,\n" +
                "\t\"overview\": \"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.\",\n" +
                "\t\"poster_path\": \"\\/fki3kBlwJzFp8QohL43g9ReV455.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"ダンジョンに出会いを求めるのは間違っているだろうか\",\n" +
                "\t\"genre_ids\": [16, 35, 10765],\n" +
                "\t\"name\": \"Is It Wrong to Try to Pick Up Girls in a Dungeon?\",\n" +
                "\t\"popularity\": 279.499,\n" +
                "\t\"origin_country\": [\"JP\"],\n" +
                "\t\"vote_count\": 45,\n" +
                "\t\"first_air_date\": \"2015-04-04\",\n" +
                "\t\"backdrop_path\": \"\\/xCmdeEvJNxptR30bEVXXWLrt4iI.jpg\",\n" +
                "\t\"original_language\": \"ja\",\n" +
                "\t\"id\": 62745,\n" +
                "\t\"vote_average\": 7.2,\n" +
                "\t\"overview\": \"Bell Cranell is a rookie adventurer and the sole member of his dirt-poor guild founded by the petite goddess Hestia. Adventurers come from far and wide looking to strike it big in the massive labyrinth known as Dungeon, located beneath the city of Orario. Bell is more interested in picking up girls than Dungeon-crawling, but his reality check comes sooner than expected. Saved from a brush with death by the beautiful, renowned adventurer Aiz Wallenstein, Bell falls head-over-heels and sets his sights on winning her heart, but she's not the only woman he's caught the attention of, for better of worse.\",\n" +
                "\t\"poster_path\": \"\\/1RCLDDLhIYbHDxOEHhoLs33W4to.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"ドラゴンボール\",\n" +
                "\t\"genre_ids\": [16, 35, 10759, 10765],\n" +
                "\t\"name\": \"Dragon Ball\",\n" +
                "\t\"popularity\": 265.929,\n" +
                "\t\"origin_country\": [\"JP\"],\n" +
                "\t\"vote_count\": 327,\n" +
                "\t\"first_air_date\": \"1986-02-26\",\n" +
                "\t\"backdrop_path\": \"\\/iflq7ZJfso6WC7gk9l1tD3unWK.jpg\",\n" +
                "\t\"original_language\": \"ja\",\n" +
                "\t\"id\": 12609,\n" +
                "\t\"vote_average\": 7.1,\n" +
                "\t\"overview\": \"Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.\",\n" +
                "\t\"poster_path\": \"\\/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Grey's Anatomy\",\n" +
                "\t\"genre_ids\": [18],\n" +
                "\t\"name\": \"Grey's Anatomy\",\n" +
                "\t\"popularity\": 228.326,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 971,\n" +
                "\t\"first_air_date\": \"2005-03-27\",\n" +
                "\t\"backdrop_path\": \"\\/y6JABtgWMVYPx84Rvy7tROU5aNH.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1416,\n" +
                "\t\"vote_average\": 6.3,\n" +
                "\t\"overview\": \"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.\",\n" +
                "\t\"poster_path\": \"\\/eqgIOObafPJitt8JNh1LuO2fvqu.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Family Guy\",\n" +
                "\t\"genre_ids\": [16, 35],\n" +
                "\t\"name\": \"Family Guy\",\n" +
                "\t\"popularity\": 227.836,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 1565,\n" +
                "\t\"first_air_date\": \"1999-01-31\",\n" +
                "\t\"backdrop_path\": \"\\/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1434,\n" +
                "\t\"vote_average\": 6.5,\n" +
                "\t\"overview\": \"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.\",\n" +
                "\t\"poster_path\": \"\\/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"ワンパンマン\",\n" +
                "\t\"genre_ids\": [16, 35, 10759],\n" +
                "\t\"name\": \"One-Punch Man\",\n" +
                "\t\"popularity\": 222.79,\n" +
                "\t\"origin_country\": [\"JP\"],\n" +
                "\t\"vote_count\": 433,\n" +
                "\t\"first_air_date\": \"2015-10-04\",\n" +
                "\t\"backdrop_path\": \"\\/s0w8JbuNNxL1YgaHeDWih12C3jG.jpg\",\n" +
                "\t\"original_language\": \"ja\",\n" +
                "\t\"id\": 63926,\n" +
                "\t\"vote_average\": 8,\n" +
                "\t\"overview\": \"Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?\",\n" +
                "\t\"poster_path\": \"\\/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"The Simpsons\",\n" +
                "\t\"genre_ids\": [16, 35],\n" +
                "\t\"name\": \"The Simpsons\",\n" +
                "\t\"popularity\": 222.33,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 2055,\n" +
                "\t\"first_air_date\": \"1989-12-17\",\n" +
                "\t\"backdrop_path\": \"\\/1pP0gg0iNGX06wSs19EQOvzfZIF.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 456,\n" +
                "\t\"vote_average\": 7.1,\n" +
                "\t\"overview\": \"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.\",\n" +
                "\t\"poster_path\": \"\\/yTZQkSsxUFJZJe67IenRM0AEklc.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"鬼滅の刃\",\n" +
                "\t\"genre_ids\": [16, 18, 10759, 10765],\n" +
                "\t\"name\": \"Demon Slayer: Kimetsu no Yaiba\",\n" +
                "\t\"popularity\": 205.249,\n" +
                "\t\"origin_country\": [\"JP\"],\n" +
                "\t\"vote_count\": 18,\n" +
                "\t\"first_air_date\": \"2019-04-06\",\n" +
                "\t\"backdrop_path\": \"\\/nTvM4mhqNlHIvUkI1gVnW6XP7GG.jpg\",\n" +
                "\t\"original_language\": \"ja\",\n" +
                "\t\"id\": 85937,\n" +
                "\t\"vote_average\": 6.2,\n" +
                "\t\"overview\": \"It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself.\\n\\nThough devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.\",\n" +
                "\t\"poster_path\": \"\\/taT33NroOl2Fn8bUGj8bwdmNw3G.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"The 100\",\n" +
                "\t\"genre_ids\": [18, 10765],\n" +
                "\t\"name\": \"The 100\",\n" +
                "\t\"popularity\": 199.236,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 1586,\n" +
                "\t\"first_air_date\": \"2014-03-19\",\n" +
                "\t\"backdrop_path\": \"\\/qYTIuJJ7fIehicAt3bl0vW70Sq6.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 48866,\n" +
                "\t\"vote_average\": 6.5,\n" +
                "\t\"overview\": \"100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet — but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.\",\n" +
                "\t\"poster_path\": \"\\/wBzNjurA8ijJPF21Ggs9nbviIzi.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Game of Thrones\",\n" +
                "\t\"genre_ids\": [18, 10759, 10765],\n" +
                "\t\"name\": \"Game of Thrones\",\n" +
                "\t\"popularity\": 196.309,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 6148,\n" +
                "\t\"first_air_date\": \"2011-04-17\",\n" +
                "\t\"backdrop_path\": \"\\/qsD5OHqW7DSnaQ2afwz8Ptht1Xb.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1399,\n" +
                "\t\"vote_average\": 8.1,\n" +
                "\t\"overview\": \"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.\",\n" +
                "\t\"poster_path\": \"\\/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Law & Order: Special Victims Unit\",\n" +
                "\t\"genre_ids\": [80, 18],\n" +
                "\t\"name\": \"Law & Order: Special Victims Unit\",\n" +
                "\t\"popularity\": 190.487,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 637,\n" +
                "\t\"first_air_date\": \"1999-09-20\",\n" +
                "\t\"backdrop_path\": \"\\/kOvt2BOOwSAQCT8yo3pM3X2GXjh.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 2734,\n" +
                "\t\"vote_average\": 6.3,\n" +
                "\t\"overview\": \"In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.\",\n" +
                "\t\"poster_path\": \"\\/ydSvHgksuB8Ix0V05QEZBKrnIcg.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Marvel's Agents of S.H.I.E.L.D.\",\n" +
                "\t\"genre_ids\": [18, 10759, 10765],\n" +
                "\t\"name\": \"Marvel's Agents of S.H.I.E.L.D.\",\n" +
                "\t\"popularity\": 189.706,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 1319,\n" +
                "\t\"first_air_date\": \"2013-09-24\",\n" +
                "\t\"backdrop_path\": \"\\/iWopHyAvuIDjGX10Yc3nn6UEebW.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1403,\n" +
                "\t\"vote_average\": 6.8,\n" +
                "\t\"overview\": \"Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.\",\n" +
                "\t\"poster_path\": \"\\/cXiETfFK1BTLest5fhTLfDLRdL6.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Supergirl\",\n" +
                "\t\"genre_ids\": [28, 12, 18, 878],\n" +
                "\t\"name\": \"Supergirl\",\n" +
                "\t\"popularity\": 187.949,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 983,\n" +
                "\t\"first_air_date\": \"2015-10-26\",\n" +
                "\t\"backdrop_path\": \"\\/3x1lVyxtsLKsZyR2E3qRe1EAXG4.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 62688,\n" +
                "\t\"vote_average\": 5.8,\n" +
                "\t\"overview\": \"Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.\",\n" +
                "\t\"poster_path\": \"\\/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Fear the Walking Dead\",\n" +
                "\t\"genre_ids\": [18, 27],\n" +
                "\t\"name\": \"Fear the Walking Dead\",\n" +
                "\t\"popularity\": 186.403,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 962,\n" +
                "\t\"first_air_date\": \"2015-08-23\",\n" +
                "\t\"backdrop_path\": \"\\/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 62286,\n" +
                "\t\"vote_average\": 6.3,\n" +
                "\t\"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\",\n" +
                "\t\"poster_path\": \"\\/aOdTWn8dXlS0tA5xl0ZBr8Ws15R.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"Supernatural\",\n" +
                "\t\"genre_ids\": [18, 9648, 10765],\n" +
                "\t\"name\": \"Supernatural\",\n" +
                "\t\"popularity\": 181.503,\n" +
                "\t\"origin_country\": [\"US\"],\n" +
                "\t\"vote_count\": 1829,\n" +
                "\t\"first_air_date\": \"2005-09-13\",\n" +
                "\t\"backdrop_path\": \"\\/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg\",\n" +
                "\t\"original_language\": \"en\",\n" +
                "\t\"id\": 1622,\n" +
                "\t\"vote_average\": 7.3,\n" +
                "\t\"overview\": \"When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. \",\n" +
                "\t\"poster_path\": \"\\/3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg\"\n" +
                "}, {\n" +
                "\t\"original_name\": \"ブリーチ\",\n" +
                "\t\"genre_ids\": [16, 10759, 10765],\n" +
                "\t\"name\": \"Bleach\",\n" +
                "\t\"popularity\": 179.554,\n" +
                "\t\"origin_country\": [\"JP\"],\n" +
                "\t\"vote_count\": 155,\n" +
                "\t\"first_air_date\": \"2004-10-05\",\n" +
                "\t\"backdrop_path\": \"\\/rL5f718Nlnl10N4LnXFVxRO2XQz.jpg\",\n" +
                "\t\"original_language\": \"ja\",\n" +
                "\t\"id\": 30984,\n" +
                "\t\"vote_average\": 7.8,\n" +
                "\t\"overview\": \"For as long as he can remember, Ichigo Kurosaki has been able to see ghosts. But when he meets Rukia, a Soul Reaper who battles evil spirits known as Hollows, he finds his life is changed forever. Now, with a newfound wealth of spiritual energy, Ichigo discovers his true calling: to protect the living and the dead from evil.\",\n" +
                "\t\"poster_path\": \"\\/jLKCX4hDP5DbcsPHpOSs6CMWoNe.jpg\"\n" +
                "}]"
}

