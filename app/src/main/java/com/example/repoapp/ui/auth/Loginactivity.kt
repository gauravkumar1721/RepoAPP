package com.example.repoapp.ui.auth

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.repoapp.R
import com.example.repoapp.databinding.ActivityLoginBinding
import com.example.repoapp.util.show
import com.example.repoapp.util.toast
import kotlinx.android.synthetic.main.activity_signup.*


class MainActivity(override val loginResponse: Any) : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
    progress_bar.show()
    }

    override fun onSuccess(loginResponse: Unit) {
        progress_bar.hide()
    loginResponse.observe(this, Observer(this::toast))
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
    toast(message)
    }
}

private fun ProgressBar.hide() {
    TODO("Not yet implemented")
}

private fun Any.observe(mainActivity: MainActivity, observer: Any) {
    TODO("Not yet implemented")
}
