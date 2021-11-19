package model

import activity.AuthenticationActivity
import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception
import java.util.HashMap

class AuthenticationModel(private val context: Context, private val activity : AuthenticationActivity) {
    private val baseUrl: String =  "https://10.0.2.2:443/maple.test/api"
    private val queue = Volley.newRequestQueue(context);

    class AuthResponse(val message: String, val success: Boolean)

    public fun login(username: String, password: String){
        val request = "$baseUrl/login"
        val jsonObjectRequest = object : StringRequest(Request.Method.POST,request,{
            response -> try {
            val gson =  Gson();
                val apiResponse = gson.fromJson(response.toString(), AuthResponse::class.java);

                if(apiResponse.success){
                    Toast.makeText(context,apiResponse.message.toString(), Toast.LENGTH_SHORT)
                    activity.resolveLogin(username,password,apiResponse.message)
                }
            }catch (e: Exception){

            }
        }, { error -> Log.d("ApiError", error.toString())})
            {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                //Change with your post params
                params["username"] = username
                params["password"] = password
                params["device_name"] = android.os.Build.MODEL
                return params
            }
        }
        queue.add(jsonObjectRequest)
    }

    public fun register(username: String, email: String,password: String, password_confirmation: String){
        val request = "$baseUrl/register"
        val jsonObjectRequest = object : StringRequest(Request.Method.POST,request,{
                response -> try {
            val gson =  Gson();
            val apiResponse = gson.fromJson(response.toString(), AuthResponse::class.java);
            Log.d("debug_me", apiResponse.message)

            if(apiResponse.success){
                Toast.makeText(context, apiResponse.message.toString(), Toast.LENGTH_SHORT)
                activity.resolveRegister()
            }
        }catch (e: Exception){

        }
        }, { error -> Log.d("ApiError", error.toString())})
        {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                //Change with your post params
                params["username"] = username
                params["password"] = password
                params["password_confirmation"] = password_confirmation
                params["email"] = email
                return params
            }
        }
        queue.add(jsonObjectRequest)
    }

}