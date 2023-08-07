package com.alternova.lego.ui.login

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.alternova.lego.R
import com.alternova.lego.core.ext.convertToSpannableStringWithClick
import com.alternova.lego.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val actionBar: ActionBar = (requireActivity() as AppCompatActivity).supportActionBar!!
        actionBar.hide()

        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {

        binding.signIn.setOnClickListener {
            val action: NavDirections = LoginFragmentDirections.actionLoginFragmentToSignInFragment()
            findNavController().navigate(action)
        }

        setSpannableClickTextSignUp()

    }

    private fun setSpannableClickTextSignUp(){
        //GET TEXT FROM RESOURCES
        val text: String = getString(R.string.sign_up_text_button)
        //SET TEXT SPAN CLICKABLE
        binding.signUp.text = text.convertToSpannableStringWithClick{
            val action: NavDirections = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            findNavController().navigate(action)
        }

        binding.signUp.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}