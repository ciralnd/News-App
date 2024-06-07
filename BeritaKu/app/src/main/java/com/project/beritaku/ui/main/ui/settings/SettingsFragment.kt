package com.project.beritaku.ui.main.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.project.beritaku.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {
    private val settingsViewModel by viewModel<SettingsViewModel>()

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        observeViewModel()
        setListeners()

        return binding.root
    }

    private fun observeViewModel() {
        settingsViewModel.getDarkMode().observe(viewLifecycleOwner) {
            binding.switchMode.isChecked = it
            if (it)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setListeners() {
        binding.apply {
            switchMode.setOnCheckedChangeListener { _, isChecked ->
                settingsViewModel.setDarkMode(isChecked)
            }
        }
    }
}