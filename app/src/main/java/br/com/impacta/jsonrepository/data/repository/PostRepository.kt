package br.com.impacta.jsonrepository.data.repository

import br.com.impacta.jsonrepository.data.models.Post
import br.com.impacta.jsonrepository.data.remote.JSONPlaceHolderApi
import br.com.impacta.jsonrepository.data.remote.RetrofitBuilder

class PostRepository {

    val retrofit = RetrofitBuilder.getRetrofitInstance("https://jsonplaceholder.typicode.com/")
    val endpoints = retrofit.create(JSONPlaceHolderApi::class.java)

    suspend fun getAllPosts(): List<Post> {
        return endpoints.getAllPosts()
    }

    suspend fun getPostById(postId: Int): Post {
        return endpoints.getPostById(postId)
    }
}