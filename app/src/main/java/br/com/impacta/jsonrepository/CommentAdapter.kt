package br.com.impacta.jsonrepository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.jsonrepository.data.models.Comment
import br.com.impacta.jsonrepository.databinding.CommentItemBinding

class CommentAdapter(val listaComentarios: List<Comment>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(val binding: CommentItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.comment = listaComentarios[position]
    }

    override fun getItemCount(): Int {
        return listaComentarios.size
    }
}