package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up,container,false)
        setSpannableString()
        return binding.root
    }

    private fun setSpannableString() {     //String which we can click
        val span= SpannableString(getString(R.string.Already_have_account))
        val clickableSpan= object : ClickableSpan(){
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText=false     //by default every clickable link has an underline, so we need to remove it manually
                ds.color =resources.getColor(R.color.primary)
            }

            override fun onClick(widget: View) {
                // on clicking this string what will happen we have to define here
                // in this case we want to send the user back to the previous activity

                //Implement the sign in logic here
                Toast.makeText(requireContext(),"Touched", Toast.LENGTH_SHORT).show()
            }
        }
        //now we will set the span. meaning which text we want to make clickable and all
        span.setSpan(clickableSpan,span.length-7,span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvAlreadyHaveAccount.movementMethod= LinkMovementMethod.getInstance()
        binding.tvAlreadyHaveAccount.text=span
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_accountActivationFragment)
        }
    }
}