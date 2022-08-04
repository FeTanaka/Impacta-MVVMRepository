package br.com.impacta.jsonrepository.data.remote

import br.com.impacta.jsonrepository.data.models.Post
import retrofit2.http.GET

interface JSONPlaceHolderApi {

    @GET("/posts")
    suspend fun getAllPosts(): List<Post>

}