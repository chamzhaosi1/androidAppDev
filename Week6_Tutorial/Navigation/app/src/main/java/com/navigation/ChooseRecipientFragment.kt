package com.navigation

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.navigation.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    lateinit var binding: FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.next_btn -> {
                if(!TextUtils.isEmpty(binding.inputRecipient.text.toString())){
                    val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                    navController!!.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
                }else{
                    Toast.makeText(activity, "Enter a recipient", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> requireActivity()!!.onBackPressed()
        }
    }


}