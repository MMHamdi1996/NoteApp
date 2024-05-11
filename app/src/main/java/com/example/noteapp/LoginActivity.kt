package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.noteapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {

            val userEditText = binding.usernameEditText.text.toString()
            val passEditText = binding.passwordEditText.text.toString()

            if (userEditText == "" || passEditText == "") {
                Toast.makeText(this, "لطفا تمامی مقادیر را پر کنید", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("message",  "Hello $userEditText")
                startActivity(intent)
            }
        }
    }
}