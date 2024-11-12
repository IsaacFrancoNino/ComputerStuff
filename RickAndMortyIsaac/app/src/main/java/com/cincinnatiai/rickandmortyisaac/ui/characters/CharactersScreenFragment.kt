package com.cincinnatiai.rickandmortyisaac.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cincinnatiai.rickandmortyisaac.databinding.FragmentCharactersScreenBinding


class CharactersScreenFragment : Fragment() {
    private var _binding: FragmentCharactersScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(requireActivity(), CharactersViewModelProvider()) [CharactersViewModel::class.java]
    }

    private var charactersAdapter : CharactersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersScreenBinding.inflate(inflater, container, false)
        charactersAdapter = CharactersAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = charactersAdapter


        viewModel.state.observe(viewLifecycleOwner){ state ->
            when(state){
                is CharactersUIState.CharactersLoaded -> {
                    hideLoading()
                    charactersAdapter?.setItems(state.characters)

                }
                is CharactersUIState.Error -> {
                    hideLoading()
                    showError(state.errorMesage)
                }
                CharactersUIState.Loading -> showLoading()
            }
        }
        viewModel.fetchCharacters()
        return binding.root
    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(errorMessage: Int){
        Toast.makeText(requireContext(),errorMessage, Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CharactersScreenFragment()
    }

}