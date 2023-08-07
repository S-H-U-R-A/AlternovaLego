package com.alternova.lego.ui.login.signIn

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.alternova.lego.R
import com.alternova.lego.core.enums.UserMessages
import com.alternova.lego.core.ext.convertToSpannableStringWithClick
import com.alternova.lego.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding get() = _binding!!

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        initObservers()
    }


    private fun initComponents() {

        binding.btnSignIn.setOnClickListener {
            if (!handleValidateFields()){
                viewModel.sendMessageUser(UserMessages.USER_FIELDS_NOT_VALID.code, "Los datos ingresados no son válidos")
            }else{
                viewModel.signInUser(
                    binding.tietEmail.text.toString(),
                    binding.tietPassword.text.toString()
                ){
                    val navOptions = NavOptions.Builder().setPopUpTo(
                        R.id.productsFragment, true
                    ).build()
                    findNavController().navigate(R.id.productsFragment, null, navOptions)
                }
            }
        }

        setSpannableClickTextSignUp()

    }

    private fun handleValidateFields(): Boolean {
        var isValid = true
        if( binding.tietEmail.text.toString().trim().isEmpty()){ isValid = false }
        if( binding.tietPassword.text.toString().trim().isEmpty() || binding.tietPassword.text.toString().trim().length <= 6 ){ isValid = false }
        return isValid
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{ uiState ->
                    handlerMessageUser(uiState.messagesUser)
                }
            }
        }
    }

    private fun handlerMessageUser(messagesUser: List<Map<Int, String>>) {
        messagesUser.forEach { messageState: Map<Int, String> ->
            when(messageState.keys.first()){
                UserMessages.USER_NOT_VALID_LOGIN.code -> {
                    Toast.makeText( requireContext() , messageState.values.first(), Toast.LENGTH_LONG ).show()
                }
                UserMessages.USER_FIELDS_NOT_VALID.code -> {
                    Toast.makeText( requireContext() , messageState.values.first(), Toast.LENGTH_LONG ).show()
                }
            }
            viewModel.deleteMessageUser(messageState.keys.first())
        }
    }

    private fun setSpannableClickTextSignUp(){
        //GET TEXT FROM RESOURCES
        val text: String = getString(R.string.sign_up_text_button)
        //SET TEXT SPAN CLICKABLE
        binding.signUp.text = text.convertToSpannableStringWithClick{
            val action: NavDirections = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            findNavController().navigate(action)
        }
        binding.signUp.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}