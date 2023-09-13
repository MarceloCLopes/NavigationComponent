package com.mcl.navigationcomponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mcl.navigationcomponent.databinding.FragmentResumeBinding

class ResumeFragment : Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ResumeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvPerson.text = args.model.person
        binding.tvAddress.text = args.model.address
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}