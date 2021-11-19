package model

import activity.MainActivity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception
import java.util.HashMap

class UserSearchModel(val context: Context, val activity: MainActivity) {
    private var baseUrl: String =  "https://masouri.de/api"
    private var nextPage: Int = 0;
    private val queue = Volley.newRequestQueue(context);
    class UserSearchResponse(val message: String,val data: List<UserModel>, val success: Boolean){}

    public fun search(search: String){
        val request = "$baseUrl/search/$search/user"
        val jsonObjectRequest = object : StringRequest(request,{
                response -> try {
            val gson =  Gson();
            val apiResponse = gson.fromJson(response.toString(), UserSearchResponse::class.java);

            if(apiResponse.success){

            }
        }catch (e: Exception){

        }
        }, { error -> Log.d("ApiError", error.toString())})
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers: MutableMap<String, String> = HashMap()
                headers["Authorization"] = "Bearer " + RuntimeData.apiToken
                return headers
            }

        }
        queue.add(jsonObjectRequest)
    }
    public fun getNextPage(){

    }
}