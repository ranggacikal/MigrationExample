package com.ranggacikal.migrationexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.ranggacikal.migrationexample.R
import com.ranggacikal.migrationexample.databinding.ActivityLoginBinding
import com.ranggacikal.migrationexample.ui.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
        observeLogin()
    }

    private fun observeLogin() {
        loginViewModel.loginObserver.observe(this@LoginActivity) { response ->
            if (response?.sukses == false)
                Toast.makeText(
                    this@LoginActivity, response?.pesan, Toast.LENGTH_SHORT
                ).show()
            else {
                Toast.makeText(
                    this@LoginActivity, response?.pesan, Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(Intent(this@LoginActivity, MainActivity::class.java))
                startActivity(intent)
            }
        }
    }

    private fun setupListener() {
        binding.run {
            binding.btnLogin.setOnClickListener {
                val username = binding.edtUsernameLogin.text.toString().trim()
                val password = binding.edtPasswordLogin.text.toString().trim()
                validateField(username, password)
                loginViewModel.requestLogin(username, password)
            }
        }
    }

    private fun validateField(username: String, password: String) = with(binding) {
        if (username.isEmpty()) {
            edtUsernameLogin.error = "Username is required!"
            edtUsernameLogin.requestFocus()
            return
        }
        if (password.isEmpty()) {
            edtPasswordLogin.error = "Password is required!"
            edtPasswordLogin.requestFocus()
            return
        }
    }
}