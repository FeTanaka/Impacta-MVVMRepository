package br.com.impacta.jsonrepository.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.jsonrepository.data.models.Post
import br.com.impacta.jsonrepository.databinding.PostItemBinding

class PostAdapter(val listaPosts: List<Post>, val action: (Int) -> Unit): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.post = listaPosts[position]
        holder.binding.root.setOnClickListener {
            action(listaPosts[position].id)
        }
    }

    override fun getItemCount(): Int {
        return listaPosts.size
    }
}