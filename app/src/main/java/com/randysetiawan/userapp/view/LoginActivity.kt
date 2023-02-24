package com.randysetiawan.userapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.randysetiawan.userapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            if(fieldsCheck()) {

            }
        }
        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            this.startActivity(intent)
        }
    }

    fun fieldsCheck(): Boolean {
        var username = binding.usernameEditText.text.toString().trim()
        var password = binding.passwordEditText.text.toString().trim()
        var errorMsg: String;
        if(username.isEmpty() && password.isEmpty()) {
            errorMsg = "Form is empty"
            showErrorMsg(errorMsg)
            return false
        }else if(username.isEmpty()) {
            errorMsg = "Username is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(password.isEmpty()) {
            errorMsg = "Password is empty"
            showErrorMsg(errorMsg)
            return false
        }
        return true
    }

    fun showErrorMsg(errorMsg: String) {
        val text = errorMsg
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, text, duration)
        toast.show()
    }
}