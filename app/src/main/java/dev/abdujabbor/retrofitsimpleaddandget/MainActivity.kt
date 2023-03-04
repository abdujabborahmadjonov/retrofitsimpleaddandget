package dev.abdujabbor.retrofitsimpleaddandget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.abdujabbor.retrofitsimpleaddandget.adapter.RvAdapter
import dev.abdujabbor.retrofitsimpleaddandget.databinding.ActivityMainBinding
import dev.abdujabbor.retrofitsimpleaddandget.models.MyModel
import dev.abdujabbor.retrofitsimpleaddandget.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RvAdapter
    lateinit var list : ArrayList<MyModel>
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        list = ArrayList()

        adapter = RvAdapter(list)
        binding.recyclerview.adapter = adapter
        ApiClient.getApiService().getAllTodo().enqueue(object :Callback<ArrayList<MyModel>>{
            override fun onResponse(
                call: Call<ArrayList<MyModel>>,
                response: Response<ArrayList<MyModel>>
            ) {
              if (response.isSuccessful){
                  Toast.makeText(this@MainActivity, "Internetdan malumot yuklash ijobiy", Toast.LENGTH_SHORT).show()
                    adapter.list.addAll(response.body()!!)
                    adapter.notifyDataSetChanged()
              }
            }

            override fun onFailure(call: Call<ArrayList<MyModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Internetga boglanish yaxshi emas", Toast.LENGTH_SHORT).show()
            }
        })

    }
}