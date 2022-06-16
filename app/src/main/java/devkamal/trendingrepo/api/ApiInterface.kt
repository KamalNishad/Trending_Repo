package devkamal.trendingrepo.api

import devkamal.trendingrepo.model.TrendingRepoModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("repositories")
    fun getTrendingRepoList(): Call<TrendingRepoModel>

}