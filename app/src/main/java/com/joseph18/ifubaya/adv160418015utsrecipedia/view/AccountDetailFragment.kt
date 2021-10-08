package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.util.Util.Companion.loadImage
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.AccountDetailViewModel
import kotlinx.android.synthetic.main.fragment_account_detail.*

class AccountDetailFragment : Fragment() {
    private lateinit var viewModel :AccountDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AccountDetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.accountLD.observe(viewLifecycleOwner, Observer {
            txtId3.setText(it.id)
            txtName3.setText(it.name)
            txtBio3.setText(it.bio)
            imageView3.loadImage(it.photoUrl.toString(), progressBar3)
        })
    }
}