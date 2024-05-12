package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentLoginBinding
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts.LoginScreenEvent
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts.LoginScreenState
import com.mis.route.e_commerce.presentation.ui.activities.home.HomeActivity
import com.mis.route.e_commerce.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::renderUiState)

        binding.btnLogin.setOnClickListener {
            viewModel.invoke(
                LoginScreenEvent.Login(
                    binding.txtInputEmail.text.toString(),
                    binding.txtInputPassword.text.toString()
                )
            )
        }

        binding.txtCreateAccount.setOnClickListener {
            viewModel.invoke(LoginScreenEvent.NavigateToRegister)
        }
    }

    private fun renderUiState(state: LoginScreenState) {
        when (state) {
            is LoginScreenState.NavigateToHome -> navigateToHomeScreen(state)
            LoginScreenState.NavigateToRegister -> navigateToRegisterScreen()
        }
    }

    private fun navigateToRegisterScreen() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun navigateToHomeScreen(state: LoginScreenState.NavigateToHome) {
        Toast.makeText(requireContext(), "${state.user.name}", Toast.LENGTH_SHORT).show()
        startActivity(Intent(requireContext(), HomeActivity::class.java))
        requireActivity().finish()
    }

}