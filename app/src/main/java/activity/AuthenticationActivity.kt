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

    override fun onBackPressed() {
       // super.onBackPressed()
    }
    public fun resolveLogin(username: String, password: String){
    }

}