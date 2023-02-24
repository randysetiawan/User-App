package com.randysetiawan.userapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.randysetiawan.userapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerButton.setOnClickListener {
            if(fieldsCheck()) {
                Log.d("REGISTRATION", "Register Success")
            } else {
                Log.d("REGISTRATION", "Register Fail")
            }
        }
    }

    fun fieldsCheck(): Boolean {
        var username = binding.usernameEditText.text.toString().trim()
        var email = binding.passwordEditText.text.toString().trim()
        var firstName = binding.firstNameEditText.text.toString().trim()
        var lastName = binding.lastNameEditText.text.toString().trim()
        var ageString = binding.ageEditText.text.toString().trim()
        var password = binding.passwordEditText.text.toString().trim()
        var confirmPassword = binding.confirmPasswordEditText.toString().trim()
        var errorMsg: String;
        if(username.isEmpty() &&
            email.isEmpty() &&
            firstName.isEmpty() &&
            lastName.isEmpty() &&
            ageString.isEmpty() &&
            password.isEmpty() &&
            confirmPassword.isEmpty()) {
            errorMsg = "Form is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(username.isEmpty()) {
            errorMsg = "Username is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(email.isEmpty()) {
            errorMsg = "Email is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(firstName.isEmpty()) {
            errorMsg = "First name is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(lastName.isEmpty()) {
            errorMsg = "Last name is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(ageString.isEmpty()) {
            errorMsg = "Age is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(password.isEmpty()) {
            errorMsg = "Password is empty"
            showErrorMsg(errorMsg)
            return false
        } else if(confirmPassword.isEmpty()) {
            errorMsg = "Confirm Password is empty"
            showErrorMsg(errorMsg)
            return false
        }
        return true
    }

    fun showErrorMsg(errorMsg: String) {
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, errorMsg, duration)
        toast.show()
    }
}