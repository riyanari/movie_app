package com.riyan.movieapp.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.riyan.movieapp.core.data.remote.Resource
import com.riyan.movieapp.core.domain.model.TvShow
import com.riyan.movieapp.utils.showToast
import com.riyan.movieapp.databinding.FragmentTvShowBinding
import com.riyan.movieapp.ui.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private lateinit var binding: FragmentTvShowBinding

    private lateinit var adapter: TvShowAdapter

    private val viewModel: TvShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        if (_binding == null){
            _binding = FragmentTvShowBinding.inflate(inflater, container, false)
            binding = _binding as FragmentTvShowBinding
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TvShowAdapter().apply {
            onClick {
                Intent(activity, DetailActivity::class.java).also { intent ->
                    intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.data[1])
                    intent.putExtra(DetailActivity.EXTRA_DATA, it)
                    startActivity(intent)
                }
            }
        }

        getTvShow()
    }

    private fun getTvShow() {
       // TODO : Kerjakan sendiri
        viewModel.getTvShow().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> showLoading(true)
                is Resource.Success -> {
                    if (it.data != null){
                        adapter.tvshow = it.data as MutableList<TvShow>
                        binding.apply {
                            rvTvshow.setHasFixedSize(true)
                            rvTvshow.adapter = adapter
                        }
                        showLoading(false)
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    activity?.showToast(it.message.toString())
                }
            }
        }
    }

    private fun showLoading(state: Boolean){
        binding.apply {
            if (state){
                progressBar.visibility = View.VISIBLE
                rvTvshow.visibility = View.GONE
            }else{
                progressBar.visibility = View.GONE
                rvTvshow.visibility = View.VISIBLE
            }
        }
    }

}