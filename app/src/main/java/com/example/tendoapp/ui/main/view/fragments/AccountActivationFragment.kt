package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentAccountActivationBinding

class AccountActivationFragment : Fragment(), TextWatcher {

    lateinit var binding: FragmentAccountActivationBinding
    private val editTextArray: ArrayList<EditText> = ArrayList(NUM_OF_DIGITS)
    private lateinit var numTemp: String

    companion object {

        const val NUM_OF_DIGITS = 4
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_account_activation,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnActivateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_accountActivationFragment_to_mainActivity2)
        }

        setUpEdittexts()
    }

    fun setUpEdittexts() {
        val layout = binding.codeLayout
        for (index in 0 until (layout.childCount)) {
            val view: View = layout.getChildAt(index)
            if (view is EditText) {
                editTextArray.add(index, view)
                editTextArray[index].addTextChangedListener(this)
                editTextArray[index].setOnKeyListener { _, keyCode, event ->
                    if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                        //this is for backspace
                        if (index != 0) {
                            editTextArray[index - 1].requestFocus()
                            editTextArray[index - 1].setSelection(editTextArray[index - 1].length())
                        }
                    }
                    false
                }
            }
        }

        editTextArray[0].requestFocus()

    }

    private fun enableCodeEditTexts(enable: Boolean) {

        for (i in 0 until editTextArray.size)
            editTextArray[i].isEnabled = enable

    }

    private fun initCodeEditTexts() {

        for (i in 0 until editTextArray.size)
            editTextArray[i].setText("")

        editTextArray[0].requestFocus()

    }


    //Code auto set
    fun setVerificationCode(verificationCode: String) {

        for (i in 0 until editTextArray.size)
            editTextArray[i].setText(verificationCode.substring(i, i))
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        numTemp = s.toString()
    }//store the previous digit

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(s: Editable) {

        (0 until editTextArray.size)
            .forEach { i ->
                if (s === editTextArray[i].editableText) {

                    if (s.isBlank()) {
                        return
                    }
                    if (s.length >= 2) {//if more than 1 char
                        val newTemp = s.toString().substring(s.length - 1, s.length)
                        if (newTemp != numTemp) {
                            editTextArray[i].setText(newTemp)
                        } else {
                            editTextArray[i].setText(s.toString().substring(0, s.length - 1))
                        }
                    } else if (i != editTextArray.size - 1) { //not last char
                        editTextArray[i + 1].requestFocus()
                        editTextArray[i + 1].setSelection(editTextArray[i + 1].length())
                        return
                    } else
                        Log.e("test", "hi")

                    //will verify code the moment the last character is inserted and all digits have a number
//                        verifyCode(testCodeValidity())


                }
            }
    }


}
