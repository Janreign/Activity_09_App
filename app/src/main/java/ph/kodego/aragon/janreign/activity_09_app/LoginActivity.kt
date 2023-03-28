package ph.kodego.aragon.janreign.activity_09_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.activity_09_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val Intent = Intent(this,RegisterActivity::class.java)
            startActivity(Intent)


        }

        binding.btnForgotpassword.setOnClickListener {
            val Intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(Intent)

        }

        binding.btnLogin.setOnClickListener {
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)

        }


    }
//            var goToRegister = Intent(this, RegisterActivity::class.java)
//            launchRegister.launch(goToRegister)
//        }


    override fun onBackPressed() {
        super.onBackPressed()
    }
}

