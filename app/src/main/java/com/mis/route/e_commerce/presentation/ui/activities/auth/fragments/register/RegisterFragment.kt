package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentRegisterBinding
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts.RegisterScreenEvent
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts.RegisterScreenState
import com.mis.route.e_commerce.presentation.ui.activities.home.HomeActivity
import com.mis.route.e_commerce.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {

    override val viewModel: RegisterViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::renderUiState)
        binding.btnRegister.setOnClickListener {
            viewModel.invoke(
                RegisterScreenEvent.Register(
                    binding.txtInputFullName.text.toString(),
                    binding.txtInputEmail.text.toString(),
                    binding.txtInputPassword.text.toString(),
                    binding.txtInputPassword.text.toString(),
                    binding.txtInputMobileNumber.text.toString()
                )
            )
        }
    }

    private fun renderUiState(state: RegisterScreenState) {
        when (state) {
            is RegisterScreenState.NavigateToHome -> navigateToHome(state)
        }
    }

    private fun navigateToHome(navigateToHome: RegisterScreenState.NavigateToHome) {
        Toast.makeText(requireContext(), "${navigateToHome.user.name}", Toast.LENGTH_SHORT).show()
        startActivity(Intent(requireContext(), HomeActivity::class.java))
        requireActivity().finish()
    }

}