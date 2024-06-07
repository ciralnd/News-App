package com.project.beritaku.ui.main.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.beritaku.data.Resource
import com.project.beritaku.databinding.FragmentHomeBinding
import com.project.beritaku.ui.adapter.NewsAdapter
import com.project.beritaku.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel by viewModel<HomeViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        observeViewModel()
        setRecyclerView()

        return binding.root
    }

    private fun observeViewModel() {
        homeViewModel.getLatestNews().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {
                    showLoading(true)
                }

                is Resource.Success -> {
                    showLoading(false)
                    newsAdapter.submitList(result.data)
                }

                is Resource.Error -> {
                    showLoading(false)
                    showToast(result.message.toString())
                }
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvNews.apply {
            newsAdapter.onNewsClick = {news ->
                val iDetail = Intent(requireActivity(), DetailActivity::class.java)
                iDetail.putExtra(DetailActivity.EXTRA_STORY, news)
                startActivity(iDetail)
            }

            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressbar.isVisible = isLoading
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}