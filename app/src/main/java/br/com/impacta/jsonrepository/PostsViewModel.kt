package br.com.impacta.jsonrepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.impacta.jsonrepository.data.models.Post
import br.com.impacta.jsonrepository.data.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {

    private val _listaPosts: MutableLiveData<List<Post>> = MutableLiveData(listOf())
    val listaPosts: LiveData<List<Post>> = _listaPosts
    private val postRepository = PostRepository()

    fun getAllPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val lista = postRepository.getAllPosts()
            _listaPosts.postValue(lista)
        }
    }

}