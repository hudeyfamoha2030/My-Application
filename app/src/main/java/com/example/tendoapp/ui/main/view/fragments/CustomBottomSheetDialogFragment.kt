package com.example.tendoapp.ui.main.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tendoapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_share_item_bottom_sheet.*

/**
 * Created by goodlife on 03,September,2021
 */
class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_share_item_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_share.setOnClickListener {
            //handle click event
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Oversized Denim Tshirt at the cheapest cost. For Just 67.90 Cedis .")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
//        secondButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//        thirdButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
//        }

    }
}