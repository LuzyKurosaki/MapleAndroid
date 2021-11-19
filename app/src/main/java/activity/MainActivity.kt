package activity

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import com.example.maple.R
import com.example.maple.databinding.ActivityMainBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import fragment.LoginFragment
import fragment.SearchFragment
import model.RuntimeData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = this.getSharedPreferences("UserData",Context.MODE_PRIVATE);
        if(sharedPreferences == null || sharedPreferences.getString("username", "")!!.isEmpty() || sharedPreferences.getString(
                "password",
                ""
            )!!.isEmpty()
        ){
            val intent = Intent(this, AuthenticationActivity::class.java)
            startActivity(intent)
        }
        if (savedInstanceState == null) {
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.searchBarChatrooms, SearchFragment(this@MainActivity))
            }
        }
        RuntimeData.apiToken = sharedPreferences.getString("apiToken", null)
        initView()
    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setBottomNavbar()
        setContentView(view)
    }

    private fun setBottomNavbar(){
        var radius = resources.getDimension(R.dimen.cornerSize)
        val navbarLeftModel = ShapeAppearanceModel().toBuilder().setTopRightCorner(CornerFamily.CUT, radius).build()
        val navbarLeftShape = MaterialShapeDrawable(navbarLeftModel).apply {
            fillColor = ColorStateList.valueOf(R.attr.colorPrimary)
        }
        val navbarRightModel = ShapeAppearanceModel().toBuilder().setTopLeftCorner(CornerFamily.CUT,radius).build()
        val navbarRightShape = MaterialShapeDrawable(navbarRightModel).apply {
            fillColor = ColorStateList.valueOf(R.attr.colorPrimary)
        }
        radius = resources.getDimension(R.dimen.cornerSizeHomeButton)
        val homeButtonModel = ShapeAppearanceModel().toBuilder().setAllCorners(CornerFamily.CUT, radius).build()
        val homeButtonShape = MaterialShapeDrawable(homeButtonModel)
        ViewCompat.setBackground(binding.bottomNavbarLeft, navbarLeftShape)
        ViewCompat.setBackground(binding.bottomNavbarRight, navbarRightShape)
        ViewCompat.setBackground(binding.HomeButton, homeButtonShape)
    }
}