package com.example.mealapps.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealapps.model.Meals
import com.example.mealapps.model.ResultListMeals
import com.example.mealapps.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class MealsViewModel: ViewModel(){
    private var mealsLiveData = MutableLiveData<List<Meals>>()
    fun getMeals() {
        val params: MutableMap<String, String> = HashMap()
        RetrofitInstance.api.getListMeals(params).enqueue(object  :
            Callback<ResultListMeals> {
            override fun onResponse(call: Call<ResultListMeals>, response: Response<ResultListMeals>) {
                if (response.body()!=null){
                    if(mealsLiveData!=null)
                    {
                        var m =mealsLiveData.value

                        mealsLiveData.value = response.body()!!.meals

                    }
                    else{

                        mealsLiveData.value = response.body()!!.meals

                    }

                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<ResultListMeals>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
    fun getsearch(Search:String) {
        val params: MutableMap<String, String> = HashMap()

        RetrofitInstance.api.getListMeals(params).enqueue(object  :
            Callback<ResultListMeals> {
            override fun onResponse(call: Call<ResultListMeals>, response: Response<ResultListMeals>) {
                if (response.body()!=null){
                    if(mealsLiveData!=null)
                    {
                        var m =mealsLiveData.value

                        mealsLiveData.value = response.body()!!.meals

                    }
                    else{

                        mealsLiveData.value = response.body()!!.meals

                    }

                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<ResultListMeals>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Meals>> {
        return mealsLiveData
    }
}