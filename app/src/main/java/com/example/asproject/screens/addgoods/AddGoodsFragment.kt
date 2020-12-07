package com.example.asproject.screens.addgoods

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.asproject.R
import com.example.asproject.database.GoodsDB
import com.example.asproject.databinding.AddGoodsFragmentBinding
import com.google.android.material.snackbar.Snackbar

class AddGoodsFragment : Fragment() {

    private lateinit var viewModel: AddGoodsViewModel
    private lateinit var binding: AddGoodsFragmentBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddGoodsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.add_goods_fragment,container,false)

        val application = requireNotNull(this.activity).application

        val dataSource = GoodsDB.getInstance(application).goodsDB_Dao

        val viewModelFactory = AddGoodsViewModelFactory(dataSource,application)

        val viewModel = ViewModelProviders.of(this,viewModelFactory).get(AddGoodsViewModel::class.java)

        binding.goods = viewModel
        binding.lifecycleOwner = this

        binding.root.findViewById<Button>(R.id.buttonaddgood).setOnClickListener{
            viewModel.name = binding.root.findViewById<EditText>(R.id.namegoods).text.toString()
            viewModel.code = binding.root.findViewById<EditText>(R.id.codegoods).text.toString()
            viewModel.count = binding.root.findViewById<EditText>(R.id.countgoods).text.toString()

            viewModel.onStartRecording()

            binding.root.findViewById<EditText>(R.id.namegoods).setText("")
            binding.root.findViewById<EditText>(R.id.codegoods).setText("")
            binding.root.findViewById<EditText>(R.id.countgoods).setText("")
        }

        viewModel.showShackBarEvent.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    "All Data Destroyed",
                    Snackbar.LENGTH_SHORT
                ).show()
                viewModel.doneShowingSnackBar()
            }
        })

        return binding.root
    }
}