 package com.roadmod.myapplication
 import android.os.Bundle
 import androidx.fragment.app.Fragment
 import android.view.LayoutInflater
 import android.view.View
 import android.view.ViewGroup
 import androidx.lifecycle.ViewModelProvider
 import com.roadmod.myapplication.databinding.FragmentMainScreenBinding
 import com.roadmod.myapplication.repository.AppOutDataBase

 class MainScreenFragment : Fragment() {
     private var _binding : FragmentMainScreenBinding? = null
     private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
            val view = binding.root
            val application = requireNotNull(this.activity).application
            val dao = AppOutDataBase.getInstance(application).bookmarkDao
            val viewModelFactory = MainScreenViewModelFactory(dao)
            val viewModel = ViewModelProvider(
                this, viewModelFactory)[MainScreenViewModel::class.java]
            return view
        }

     override fun onDestroyView() {
         super.onDestroyView()
         _binding = null
     }
 }