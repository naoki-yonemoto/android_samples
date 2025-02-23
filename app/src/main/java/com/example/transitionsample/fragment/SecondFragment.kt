package com.example.transitionsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackInvokedCallback
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import com.example.transitionsample.R
import com.example.transitionsample.databinding.FragmentSecondBinding
import com.example.transitionsample.util.Transit
import com.example.transitionsample.util.onBackAction

class SecondFragment : BaseFragment() {
	
	private var _binding : FragmentSecondBinding? = null
	private val binding get() = _binding!!
	
	override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View {
		super.onCreateView(inflater, container, savedInstanceState)
		_binding = FragmentSecondBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding.button.setOnClickListener {
			Transit.slide(parentFragmentManager)
				.replace(R.id.container, ThirdFragment())
				.addToBackStack("third")
				.commit()
		}
		
		onBackAction {
			Log.d("SecondFragment", "onBack")
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}