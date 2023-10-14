package com.example.mealapps.model

import com.google.gson.annotations.SerializedName

class ResultListMeals {
    @SerializedName("meals" ) var meals : ArrayList<Meals> = arrayListOf()
}
