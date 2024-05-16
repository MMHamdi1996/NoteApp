package com.example.noteapp.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        editor = preferences.edit()
        editor.apply()


        val appOpen = preferences.getBoolean("openApp", false)
        if (appOpen) binding.loginButton.text = "ورود"

        binding.loginButton.setOnClickListener {

            val userEditText = binding.usernameEditText.text.toString()
            val passEditText = binding.passwordEditText.text.toString()

            if (userEditText == "" || passEditText == "") {
                Toast.makeText(this, getString(R.string.login_toast_message), Toast.LENGTH_SHORT)
                    .show()
            } else {

                if (appOpen) {
                    if (userEditText == preferences.getString("userNameSave", "test") &&
                        passEditText == preferences.getString("passSave", "test")
                    ) {
                        goToMainActivity(userEditText)
                    } else {
                        Toast.makeText(
                            this,
                            "نام کاربری یا رمز عبور به درستی وارد نشده است",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else {
                    editor.putString("userNameSave", userEditText).apply()
                    editor.putString("passSave", passEditText).apply()
                    editor.putBoolean("openApp", true).apply()

                    goToMainActivity(userEditText)
                }
            }
        }
    }
    fun goToMainActivity(userEditText : String){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("message", "Hello $userEditText")
        startActivity(intent)
        finish()
    }
}