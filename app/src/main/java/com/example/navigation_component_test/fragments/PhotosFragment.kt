package com.example.navigation_component_test.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.navigation_component_test.viewmodels.FragmentPhotosViewModel
import com.example.navigation_component_test.R
import com.example.navigation_component_test.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {
    lateinit var binding:FragmentPhotosBinding
    companion object {
        fun newInstance() = PhotosFragment()
    }

    private lateinit var viewModel: FragmentPhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentPhotosViewModel::class.java)
        binding.homeButtonPhotos.setOnClickListener({
            Navigation.findNavController(it).navigate(R.id.photos_home_action)
            //val photosToHomeAction=PhotosFragmentDirections.photosHomeAction()
        })
        arguments?.let {
            val safeArgs= PhotosFragmentArgs.fromBundle(it)
            binding.numOfPhotos.text="Num of photos : ${safeArgs.numOfPhotos}"
        }
    }

}