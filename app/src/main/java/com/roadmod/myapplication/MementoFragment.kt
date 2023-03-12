package com.roadmod.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.roadmod.myapplication.databinding.FragmentMementoBinding
import com.roadmod.myapplication.repository.AppOutDataBase

class MementoFragment : Fragment() {
    private var _binding : FragmentMementoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMementoBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = AppOutDataBase.getInstance(application).bookmarkDao
        val viewModelFactory = MementoViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory)[MementoViewModel::class.java]

        val adapter = OuteyItemAdapter()
        binding.oteyList.adapter = adapter

        viewModel.bookmarks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}