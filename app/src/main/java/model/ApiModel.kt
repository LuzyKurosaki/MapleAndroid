package model

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception
import java.util.HashMap

class ApiModel(private val context: Context, private val activity : Activity) {
    val baseUrl: String =  "http://maple.test/api"

    val queue = Volley.newRequestQueue(context);
    class AuthResponse(val message: String, val success: Boolean)

    public fun login(username: String, password: String){
        val request = "$baseUrl/login"
        val jsonObjectRequest = object : StringRequest(request,{
            response -> try {

            }catch (e: Exception){

            }
        }, { _ -> Log.d("response", "error")}){
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"]="Mozilla/5.0"
                return headers
            }
        }
    }
}