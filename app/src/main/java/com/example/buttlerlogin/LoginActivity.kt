package com.example.buttlerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.buttlerlogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

        private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.edtMail.setOnClickListener {
           binding.edtMail.setBackgroundResource(R.drawable.go_to_login_bg)
            binding.edtMail.setText("")
        }

        binding.edtPassword.setOnClickListener {
            binding.edtPassword.setBackgroundResource(R.drawable.go_to_login_bg)
            binding.edtPassword.setText("")
        }

        binding.txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity,Forgot1Activity::class.java))

        }

        binding.btnLogin.setOnClickListener {

            var flag : Int = 0
            val edtMail =  binding.edtMail.text.toString()
            val edtPass = binding.edtPassword.text.toString()

            if(edtMail.equals("") || edtPass.equals("") )
            {
                Toast.makeText(this@LoginActivity , "Please Fill all the details",Toast.LENGTH_SHORT).show()
            }
            else {

                if (checkMail(edtMail)) {
                  //   startActivity(Intent(this, Forgot1Activity::class.java))
                   flag = 1
                }
                else {
                    Toast.makeText(this@LoginActivity, "Please enter correct mail", Toast.LENGTH_SHORT).show()

                }

                if(checkPass(edtPass)) {
                    flag = 1
                }
                else{
                    Toast.makeText(this@LoginActivity, "Please enter Password of size at least 8", Toast.LENGTH_SHORT).show()

                }

            }

            if(flag==1){
                startActivity(Intent(this, FragmentsActivity::class.java))
                 finish()
            }
        }



    }




    companion object {

        fun checkMail(email: String): Boolean {

            /*var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"*/

          //  var emailPattern = "[a-zA-Z0-9._-]{3,256}+@[a-z]{3,64}+.+[a-z]{2,3}+"

            var emailPattern = "^\\w+@[a-zA-Z_]{3,}+\\.[a-zA-Z]{2,3}\$"

           // return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

           //  return email.trim { it <= ' ' }.matches(emailPattern.toRegex())
            return email.matches(emailPattern.toRegex())
        }


        fun checkPass(pass: String): Boolean {
            return (pass.length >= 8)
        }
    }
}