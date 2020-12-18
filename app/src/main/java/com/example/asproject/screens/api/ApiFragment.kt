package com.example.asproject.screens.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.asproject.R
import com.example.asproject.databinding.ApiFragmentBinding

class ApiFragment : Fragment() {

    companion object {
        fun newInstance() = ApiFragment()
    }

    private lateinit var viewModel: ApiViewModel

    private lateinit var binding: ApiFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ApiFragmentBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(ApiViewModel::class.java)

        binding.number = viewModel
        binding.lifecycleOwner = this

        viewModel.IMAGE_URL.observe(viewLifecycleOwner, Observer {
            Glide.with(binding.root.findViewById<ImageView>(R.id.image).context)
                .load(viewModel.IMAGE_URL)
                .into(binding.root.findViewById<ImageView>(R.id.image))
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ApiViewModel::class.java)
    }

}

