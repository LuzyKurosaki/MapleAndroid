package activity

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.example.maple.R
import com.example.maple.databinding.ActivityMainBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = this?.getPreferences(Context.MODE_PRIVATE) ?: null;

        if(sharedPreferences == null || sharedPreferences?.getString("username", "") == "" || sharedPreferences?.getString("password", "") != ""){
            val intent = Intent(this, AuthenticationActivity::class.java)
            startActivity(intent)
        }else{
            initView()
        }

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