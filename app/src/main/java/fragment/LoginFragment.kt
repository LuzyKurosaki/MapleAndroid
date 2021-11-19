package fragment

import activity.AuthenticationActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.maple.R

class LoginFragment(val activity: AuthenticationActivity): Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username: EditText = view.findViewById(R.id.loginUsername)
        val password: EditText = view.findViewById(R.id.loginPassword)
        val login: Button = view.findViewById(R.id.loginButton)
        val register: Button = view.findViewById(R.id.backToRegisterButton)

        register.setOnClickListener {
            activity.showRegister()
        }

        login.setOnClickListener{
            if(username.text.isNotEmpty() && password.text.isNotEmpty()){
                activity.login(username.text.toString(), password.text.toString())
            }
        }
    }

}