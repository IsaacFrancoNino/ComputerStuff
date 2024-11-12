package com.cincinnatiai.weatherapp.ui.weathers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cincinnatiai.weatherapp.databinding.FragmentWeathersScreenBinding


class WeathersScreenFragment : Fragment() {

    private var _binding: FragmentWeathersScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeathersViewModel by lazy {
        ViewModelProvider(requireActivity(),WeathersViewModelProvider()) [WeathersViewModel::class.java]
    }

    private var weathersAdapter: WeathersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeathersScreenBinding.inflate(inflater,container,false)
        weathersAdapter = WeathersAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = weathersAdapter

        viewModel.state.observe(viewLifecycleOwner){state ->
            when(state){
                is WeathersUIState.WeatherLoaded -> {
                    hideLoading()
                    weathersAdapter?.setItems(state.weather)
                }
                is  WeathersUIState.Error -> {
                    hideLoading()
                    showError(state.errorMessage)
                }
                WeathersUIState.Loading -> showLoading()
            }
        }
        viewModel.fetchWeathers()
        return binding.root

    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(errorMessage: Int){
        Toast.makeText(requireContext(),errorMessage,Toast.LENGTH_LONG).show()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            WeathersScreenFragment()
    }
}