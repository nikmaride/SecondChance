package com.mvvmarch.secondchance.ui.characterList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvmarch.secondchance.R
import com.mvvmarch.secondchance.databinding.FragmentCharacterListBinding
import com.mvvmarch.secondchance.utils.Resource
import com.mvvmarch.secondchance.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterList : Fragment(){
    // TODO: Rename and change types of parameters

    private var binding: FragmentCharacterListBinding by autoCleared()
    private val viewModel: CharacterListViewModel by viewModels()
    private var adapter: CharactersListAdapter = CharactersListAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
//        adapter = CharactersListAdapter(this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext(),  LinearLayoutManager.HORIZONTAL, false)
        binding.charactersRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> Toast.makeText(binding.root.context, "Loading...", Toast.LENGTH_SHORT).show()
            }
        })
    }

}