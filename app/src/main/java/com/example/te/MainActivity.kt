package com.example.te

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.te.api.Person
import com.example.te.api.RegResApi
import com.example.te.api.RegResObj
import com.example.te.api.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitApi.getRegResApi().getUsers(page = 2)
            .enqueue(object : Callback<RegResObj<List<Person>>> {
                override fun onResponse(
                    call: Call<RegResObj<List<Person>>>,
                    response: Response<RegResObj<List<Person>>>
                ) {

                    if (response.isSuccessful) {
                        response.body()?.data?.forEach{ p -> Log.d("MyData", p.toString()) }
                    }

                }

                override fun onFailure(call: Call<RegResObj<List<Person>>>, t: Throwable) {

                }

            })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPeople)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PersonAdapter(emptyList())
        recyclerView.adapter = adapter

        RetrofitApi.getRegResApi().getUsers(page = 2)
            .enqueue(object : Callback<RegResObj<List<Person>>> {
                override fun onResponse(
                    call: Call<RegResObj<List<Person>>>,
                    response: Response<RegResObj<List<Person>>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let { people ->
                            adapter.updateData(people)
                            people.forEach { p -> Log.d("MyData", p.toString()) }
                        }
                    }
                }

                override fun onFailure(call: Call<RegResObj<List<Person>>>, t: Throwable) {

                }


            })
    }
}