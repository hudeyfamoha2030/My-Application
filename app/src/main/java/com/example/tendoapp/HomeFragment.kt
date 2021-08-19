package com.example.tendoapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.databinding.ActivityMain2Binding.inflate
import com.example.tendoapp.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        searchViewListener()
        return binding.root

        var manager= GridLayoutManager(context ,2)
        recyclerview.layoutManager = manager
        recyclerview.adapter = Adapter(getData())
    }

    private fun getData():ArrayList<DataModel>
    {
        var list=ArrayList<DataModel>()

        var model= DataModel("blue_t-shirt", "text_price", R.drawable.tisho2)
        list.add(model)
        var model1= DataModel("orange_t-shirt", "text_price", R.drawable.tisho3)
        list.add(model1)
        var model2= DataModel("yellow_t-shirt", "text_price", R.drawable.tisho)
        list.add(model2)
        var model3= DataModel("bluelight_t-shirt", "text_price", R.drawable.tisho4)
        list.add(model3)


        var model4= DataModel("blue_t-shirt", "text_price", R.drawable.tisho2)
        list.add(model4)
        var model5= DataModel("orange_t-shirt", "text_price", R.drawable.tisho3)
        list.add(model5)
        var model6= DataModel("yellow_t-shirt", "text_price", R.drawable.tisho)
        list.add(model6)
        var model7= DataModel("bluelight_t-shirt", "text_price", R.drawable.tisho4)
        list.add(model7)
        return list

    }

    private fun flipperImages(image:Int){
        val imageView= ImageView(requireContext())
        imageView.setBackgroundResource(image)

        binding.viewFlipper.addView(imageView)
        binding.viewFlipper.flipInterval=4000  //4sec
        binding.viewFlipper.isAutoStart=true

        //some animations

        binding.viewFlipper.setInAnimation(requireContext(),android.R.anim.slide_in_left)
        binding.viewFlipper.setOutAnimation(requireContext(),android.R.anim.slide_out_right)


    }

    override fun onResume() {
        super.onResume()
        val imagesArray= arrayOf(R.drawable.ic_slideshow1,R.drawable.ic_slideshow2,R.drawable.ic_slideshow3)

        for(image in imagesArray){    // we have put this in OnResume because it is also called during onCreate
            flipperImages(image)
        }
    }

    fun searchViewListener(){
        binding.LLSearchView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }

}