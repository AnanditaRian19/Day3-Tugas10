package com.kotlin.day3_tugas10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.kotlin.day3_tugas10.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.edtEmail.text.toString().trim()
            val inputPass = binding.edtPassword.text.toString().trim()

            var isEmptyForm = false

            if (TextUtils.isEmpty(inputEmail)) {
                isEmptyForm = true
                binding.tipEmail.error = getString(R.string.form_validation)
            } else if (!isValidEmail(inputEmail)) {
                binding.tipEmail.error = getString(R.string.wrong_email_format)
                return@setOnClickListener
            } else {
                binding.tipEmail.error = null
            }

            if (TextUtils.isEmpty(inputPass)) {
                isEmptyForm = true
                binding.tipPassword.error = getString(R.string.form_validation)
            } else {
                binding.tipPassword.error = null
            }

            when {
                inputEmail.isEmpty() -> {
                    isEmptyForm = true
                    binding.tipEmail.error = getString(R.string.form_validation)
                }
                inputPass.isEmpty() -> {
                    isEmptyForm = true
                    binding.tipPassword.error = getString(R.string.form_validation)
                }
            }

            if (!isEmptyForm) {
                Toast.makeText(
                    this@LoginActivity,
                    getString(R.string.in_development),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.forgotPass.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                getString(R.string.in_development),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.ivLoginByGoogle.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                getString(R.string.in_development),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.ivLoginByFacebook.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                getString(R.string.in_development),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.tvRegister.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                getString(R.string.in_development),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}