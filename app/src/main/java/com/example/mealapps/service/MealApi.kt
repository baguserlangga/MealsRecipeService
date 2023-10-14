package com.example.mealapps.service

import com.example.mealapps.model.ResultListArea
import com.example.mealapps.model.ResultListCategory
import com.example.mealapps.model.ResultListMeals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MealApi {
    @GET("/search.php")
    fun getListMeals( @QueryMap params : Map<String,String>) : Call<ResultListMeals>
    @GET("/list.php?c=list")
    fun getCategory( @QueryMap params : Map<String,String>) : Call<ResultListMeals>
    @GET("/list.php?a=list")
    fun getArea( @QueryMap params : Map<String,String>) : Call<ResultListMeals>
    @GET("/lookup.php?i={id}")
    fun getArea( @Path("id") idmovie:String) : Call<ResultListMeals>

}