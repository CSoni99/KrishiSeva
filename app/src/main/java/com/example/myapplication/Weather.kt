package com.example.myapplication

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_weather.*
import org.json.JSONObject

class Weather : AppCompatActivity() {
    // weather url to get JSON
    var weather_url1 = ""

    // api id for url
    var api_id1 = "030314b750cc43e7b39e503dfe37150c"

    private lateinit var textView: TextView
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        // link the textView in which the
        // temperature will be displayed
        textView = findViewById(R.id.textView)

        // create an instance of the Fused
        // Location Provider Client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        Log.e("lat", weather_url1)

        // on clicking this button function to
        // get the coordinates will be called
        btVar1.setOnClickListener {
            progressBar2.visibility=View.VISIBLE
            Log.e("lat", "onClick")
            // function to find the coordinates
            // of the last location
            obtainLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun obtainLocation() {
        Log.e("lat", "function")
        // get the last location
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // get the latitude and longitude
                // and create the http URL
                weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "lat=" + location?.latitude + "&lon=" + location?.longitude + "&key=" + api_id1
                Log.e("lat", weather_url1.toString())
                // this function will
                // fetch data from URL
                getTemp()
            }
    }

    fun getTemp() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url: String = weather_url1
        Log.e("lat", url)

        // Request a string response
        // from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.e("lat", response.toString())

                // get the JSON object
                val obj = JSONObject(response)

                // get the Array from obj of name - "data"
                val arr = obj.getJSONArray("data")
                Log.e("lat obj1", arr.toString())

                // get the JSON object from the
                // array at index position 0
                val obj2 = arr.getJSONObject(0)
                Log.e("lat obj2", obj2.toString())

                // set the temperature and the city
                // name using getString() function
                textView.text = "Temperature might be " + obj2.getString("temp") + " degree Celcius in " + obj2.getString("city_name")
                progressBar2.visibility= View.INVISIBLE
            },
            // In case of any error
            Response.ErrorListener { textView!!.text = "Kindly Check Location And Internet" })
        queue.add(stringReq)
    }
}