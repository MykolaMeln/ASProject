package com.example.asproject.screens.elements

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.asproject.R
import com.example.asproject.databinding.FragmentElementsBinding
import kotlinx.android.synthetic.main.fragment_elements.*
import timber.log.Timber

class ElementsFragment : Fragment() {

    private lateinit var viewModel: ElementsViewModel
    private lateinit var binding: FragmentElementsBinding
    private lateinit var viewModelFactory: ElementsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            com.example.asproject.R.layout.fragment_elements,
            container,
            false
        )

        Timber.i("Called ViewModelProviders.of!")
        viewModelFactory = ElementsViewModelFactory("Factory Text")

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ElementsViewModel::class.java)
        binding.fragmod = viewModel
        binding.lifecycleOwner = this

        binding.root.findViewById<RadioButton>(R.id.radioButton).setOnClickListener {
            if (viewModel.event.value!!)//true
            {
                Timber.i("Event is true!")
                viewModel.noActiveEvent()
            }
        }

        binding.root.findViewById<RadioButton>(R.id.radioButton2).setOnClickListener{
            vibrorezhym(longArrayOf(100, 100, 100, 100, 100, 100))
        }

        viewModel.event.observe(viewLifecycleOwner, Observer{
            it->if(it) {
            Timber.i("It Event False!")
            viewModel.noActiveEvent()
        }
        })

        return binding.root
    }

    fun showChecked(view: View?) {
        val checkedRadioButtonId: Int = radioGroup.getCheckedRadioButtonId()
        val myRadioButton = activity?.findViewById<View>(checkedRadioButtonId) as RadioButton

        Toast.makeText(activity, myRadioButton.text, Toast.LENGTH_SHORT).show()
    }

    private fun vibrorezhym(pattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()

        buzzer?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                //deprecated in API 26
                buzzer.vibrate(pattern, -1)
            }
        }
    }
}