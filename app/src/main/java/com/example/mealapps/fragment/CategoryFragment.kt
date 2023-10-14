package com.example.mealapps.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealapps.R
import com.example.mealapps.adapter.CategoryAdapter
import com.example.mealapps.databinding.FragmentCategoryBinding
import com.example.mealapps.model.Meals
import com.example.mealapps.viewmodel.MealsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var genreAdapter: CategoryAdapter

    private lateinit var lm : LinearLayoutManager
    var     moviesnih :ArrayList<Meals> =ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var viewModel:MealsViewModel
    private lateinit var movieAdapter : CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentCategoryBinding.inflate(layoutInflater)
        lm  = LinearLayoutManager(requireContext())

        prepareRecyclerViews()
//        binding.textViewJudul.text = "Genre List"
        viewModel.observeMovieLiveData().observe(requireActivity(), Observer { movieList ->
            moviesnih.addAll(movieList)
            Log.d(ContentValues.TAG, "onCreateViewasaa: " + moviesnih)
            genreAdapter.notifyDataSetChanged()
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun prepareRecyclerViews() {
        var lm = LinearLayoutManager(requireContext())
        binding.rvMovies.layoutManager =lm
        viewModel = ViewModelProvider(this)[MealsViewModel::class.java]
        viewModel.getMeals()
        genreAdapter = CategoryAdapter(moviesnih)
        binding.rvMovies.setHasFixedSize(true)
        genreAdapter.notifyDataSetChanged()

    }
}