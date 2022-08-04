package br.com.impacta.jsonrepository.data.remote

import br.com.impacta.jsonrepository.data.models.Comment
import br.com.impacta.jsonrepository.data.models.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceHolderApi {

    @GET("/posts")
    suspend fun getAllPosts(): List<Post>

    @GET("/posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: Int): Post

    @GET("/posts/{postId}/comments")
    suspend fun getPostCommentaries(@Path("postId") postId: Int): List<Comment>

}