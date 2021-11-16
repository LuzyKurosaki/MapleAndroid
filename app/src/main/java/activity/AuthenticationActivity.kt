package activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.maple.R
import com.example.maple.databinding.ActivityAuthenticationBinding
import com.example.maple.databinding.ActivityMainBinding
import fragment.LoginFragment
import fragment.RegisterFragment
import model.ApiModel

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.authFrame,LoginFragment(this@AuthenticationActivity))
            }
        }
    }

    public fun login(username: String, password: String){
        ApiModel(baseContext, this).login(username, password)
    }

    public fun resolveLogin(username: String, password: String, apiToken: String){
        val sharedPreferences = this.getSharedPreferences("UserData",Context.MODE_PRIVATE);
        with(sharedPreferences.edit()){
            putString("username", username)
            putString("password", password)
            putString("apiToken", apiToken)
            apply()
            commit()
        }
        super.onBackPressed()
    }

    public fun register(username: String, email: String, password: String, password_confirm: String){
        ApiModel(baseContext, this).register(username,email,password,password_confirm)
    }

    public fun resolveRegister(){
        showLogin()
    }

    public fun showLogin(){
        fragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.authFrame, LoginFragment(this@AuthenticationActivity))
        }
    }

    public fun showRegister(){
        fragmentManager.commit{
            setReorderingAllowed(true)
            replace(R.id.authFrame, RegisterFragment(this@AuthenticationActivity))
        }
    }
    override fun onBackPressed() {
       // super.onBackPressed()
    }


}