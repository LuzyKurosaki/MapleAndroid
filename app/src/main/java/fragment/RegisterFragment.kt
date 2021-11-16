package fragment

import activity.AuthenticationActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.maple.R

class RegisterFragment(val activity: AuthenticationActivity) : Fragment(R.layout.fragment_register){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email: EditText = view.findViewById(R.id.registerEmail)
        val username: EditText = view.findViewById(R.id.registerUsername)
        val password: EditText = view.findViewById(R.id.registerPassword)
        val password_confirm: EditText = view.findViewById(R.id.registerPasswordConfirm)
        val login: Button = view.findViewById(R.id.backToLoginButton)
        val register: Button = view.findViewById(R.id.registerButton)

        login.setOnClickListener{
            activity.showLogin()
        }

        register.setOnClickListener{
            if(username.text.isNotEmpty() && password.text.isNotEmpty() && email.text.isNotEmpty() && password_confirm.text.isNotEmpty() && password.text.toString() == password_confirm.text.toString()){
                activity.register(username.text.toString(), username.text.toString(),password.text.toString(),password_confirm.text.toString())
            }
        }
    }
}