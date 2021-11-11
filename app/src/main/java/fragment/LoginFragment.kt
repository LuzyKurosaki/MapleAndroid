package fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.maple.R
import model.ApiModel

class LoginFragment(val activity: Activity): Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var username: EditText = view.findViewById(R.id.loginUsername)
        var password: EditText = view.findViewById(R.id.loginPassword)
        var login: Button = view.findViewById(R.id.loginButton)
        login.setOnClickListener{
            if(username.text.isNotEmpty() && password.text.isNotEmpty()){
                ApiModel(requireContext(), activity).login(username.text.toString(), password.text.toString())
            }
        }
    }

}