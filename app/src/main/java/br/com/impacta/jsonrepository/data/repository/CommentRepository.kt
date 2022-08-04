package br.com.impacta.jsonrepository.data.repository

import br.com.impacta.jsonrepository.data.models.Comment
import br.com.impacta.jsonrepository.data.remote.JSONPlaceHolderApi
import br.com.impacta.jsonrepository.data.remote.RetrofitBuilder

class CommentRepository {

    private val retrofit = RetrofitBuilder.getRetrofitInstance("https://jsonplaceholder.typicode.com/")
    private val endpoints = retrofit.create(JSONPlaceHolderApi::class.java)

    suspend fun getPostComments(postId: Int) : List<Comment> {
        return endpoints.getPostCommentaries(postId)
    }
}