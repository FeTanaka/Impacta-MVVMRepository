package br.com.impacta.jsonrepository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.jsonrepository.databinding.FragmentPostsBinding


class PostsFragment : Fragment() {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listaPosts.observe(viewLifecycleOwner) { lista ->
            binding.postsRecyclerView.adapter = PostAdapter(lista) { id ->
                val action = PostsFragmentDirections.actionPostsFragmentToPostCommentsFragment(id)
                findNavController().navigate(action)
            }
            binding.postsRecyclerView.layoutManager = LinearLayoutManager(context)
        }

        binding.button2.setOnClickListener {
            viewModel.getAllPost()
        }
    }


}