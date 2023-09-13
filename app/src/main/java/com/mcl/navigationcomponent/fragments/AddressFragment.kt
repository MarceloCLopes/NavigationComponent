package com.mcl.navigationcomponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mcl.navigationcomponent.databinding.FragmentAddressBinding
import com.mcl.navigationcomponent.extensions.text

class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<AddressFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnNext.setOnClickListener {
            val model = args.model.copy(
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )
            val direction = AddressFragmentDirections.goToResumeFragment(model)
            findNavController().navigate(direction)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}