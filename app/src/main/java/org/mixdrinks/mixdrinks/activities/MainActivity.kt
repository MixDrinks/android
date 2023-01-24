
package org.mixdrinks.mixdrinks.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import org.mixdrinks.mixdrinks.CocktailsAdapter
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.api.RetrofitClient
import org.mixdrinks.mixdrinks.databinding.ActivityMainBinding
import org.mixdrinks.mixdrinks.models.CocktailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = CocktailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 1)
        binding.recyclerView.adapter = adapter

        getData()

    }

    private fun getData() {
        RetrofitClient.instance.getCocktails(0).enqueue(object:
            Callback<CocktailsResponse> {
                override fun onResponse(
                    call: Call<CocktailsResponse>,
                    response: Response<CocktailsResponse>,
                ) {
                    Log.d("MyLog", "onResponse")

                    response.body()?.cocktails?.let {
                        adapter.cocktailList = it
                        adapter.notifyDataSetChanged()
                    }
                }
                override fun onFailure(call: Call<CocktailsResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, R.string.failure_connecting, Toast.LENGTH_LONG).show()
            }
        })
    }
}