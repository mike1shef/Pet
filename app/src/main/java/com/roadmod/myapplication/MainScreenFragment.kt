 package com.roadmod.myapplication
 import android.app.AlertDialog
 import android.app.Dialog
 import android.os.Bundle
 import android.view.ContextThemeWrapper
 import androidx.fragment.app.Fragment
 import android.view.LayoutInflater
 import android.view.View
 import android.view.ViewGroup
 import android.widget.EditText
 import androidx.fragment.app.DialogFragment
 import androidx.lifecycle.ViewModelProvider
 import androidx.navigation.findNavController
 import androidx.navigation.fragment.findNavController
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

            val fab = binding.fab
            var alertDialog: AlertDialog? = null

            fab.setOnClickListener {
                showEditTextDialog(viewModel)
            }

            return view
        }

     private var alertDialog: AlertDialog? = null

     private fun showEditTextDialog(viewModel: MainScreenViewModel) {
         val builder = AlertDialog.Builder(requireContext())

         // Inflate the dialog layout and get the EditText view
         val dialogLayout = layoutInflater.inflate(R.layout.fragment_add_outey, null)
         val editText = dialogLayout.findViewById<EditText>(R.id.dialog_addUrl)

         // Set the builder's view to the inflated layout
         builder.setView(dialogLayout)

         builder.setPositiveButton("OK") { _, _ ->
             // Do something with the entered text
             val text = editText.text.toString()
             viewModel.newBookmarkAddress = text
             viewModel.addBookmark()
         }

         builder.setNegativeButton("Cancel") { _, _ -> }

         alertDialog = builder.create()
         alertDialog?.show()
     }

     override fun onDestroyView() {
         super.onDestroyView()
         alertDialog?.dismiss()
         _binding = null
     }
 }