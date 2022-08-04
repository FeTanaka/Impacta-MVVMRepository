package br.com.impacta.jsonrepository.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.jsonrepository.ui.viewmodels.PostCommentsViewModel
import br.com.impacta.jsonrepository.databinding.FragmentPostCommentsBinding
import br.com.impacta.jsonrepository.ui.adapters.CommentAdapter


class PostCommentsFragment : Fragment() {

    private var _binding: FragmentPostCommentsBinding? = null
    private val binding get() = _binding!!
    private val args: PostCommentsFragmentArgs by navArgs()
    private val viewModel: PostCommentsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostCommentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.post.observe(viewLifecycleOwner) { post ->
            binding.include.post = post
        }

        viewModel.listaComentarios.observe(viewLifecycleOwner) { lista ->
            binding.commentRecyclerView.adapter = CommentAdapter(lista)
            binding.commentRecyclerView.layoutManager = LinearLayoutManager(context)
        }

        val postId = args.postId
        viewModel.getData(postId)

    }

}