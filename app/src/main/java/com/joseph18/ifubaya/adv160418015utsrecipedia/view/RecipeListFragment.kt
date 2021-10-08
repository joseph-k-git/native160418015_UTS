package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeListViewModel
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import kotlinx.android.synthetic.main.recipe_list_item.*

class RecipeListFragment : Fragment() {

    private lateinit var viewModel :RecipeListViewModel

    private val recipeListAdapter = RecipeListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)
        viewModel.refresh()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recipeListAdapter

        refreshLayout.setOnRefreshListener {
            recyclerView.visibility = View.GONE
            txtErrorMessage.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

            viewModel.refresh()

            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            recipeListAdapter.updateRecipeList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            txtErrorMessage.visibility = if(it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            refreshProgressBar.visibility = if(it) View.VISIBLE else View.GONE
            recyclerView.visibility = if(!it) View.VISIBLE else View.GONE
        })
    }
}