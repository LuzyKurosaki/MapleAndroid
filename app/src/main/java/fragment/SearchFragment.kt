package fragment

import activity.MainActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.maple.R
import com.google.android.material.textfield.TextInputEditText

class SearchFragment(val activity: MainActivity): Fragment(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val search: TextInputEditText = view.findViewById(R.id.userSearch)

        search.addTextChangedListener(object :  TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(activity,p0.toString(),Toast.LENGTH_SHORT).show()
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}