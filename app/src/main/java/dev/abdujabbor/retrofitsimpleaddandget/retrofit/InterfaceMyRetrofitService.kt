package dev.abdujabbor.retrofitsimpleaddandget.retrofit

import dev.abdujabbor.retrofitsimpleaddandget.models.MyModel
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceMyRetrofitService {
    @GET(value ="plan")
    fun getAllTodo():Call<ArrayList<MyModel>>

}