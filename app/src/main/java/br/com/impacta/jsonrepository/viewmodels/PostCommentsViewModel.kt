package br.com.impacta.jsonrepository.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.impacta.jsonrepository.data.models.Comment
import br.com.impacta.jsonrepository.data.models.Post
import br.com.impacta.jsonrepository.data.repository.CommentRepository
import br.com.impacta.jsonrepository.data.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostCommentsViewModel: ViewModel() {

    private val _post: MutableLiveData<Post> = MutableLiveData(null)
    val post: LiveData<Post> = _post
    private val _listaComentarios: MutableLiveData<List<Comment>> = MutableLiveData(listOf())
    val listaComentarios: LiveData<List<Comment>> = _listaComentarios

    private val postRepository = PostRepository()
    private val commentRepository = CommentRepository()

    fun getData(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val postGet = postRepository.getPostById(postId)
            withContext(Dispatchers.Main) {
                _post.value = postGet
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            val commentsGet = commentRepository.getPostComments(postId)
            _listaComentarios.postValue(commentsGet)
        }
    }
}