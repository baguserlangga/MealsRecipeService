package com.example.mealapps.model

import com.google.gson.annotations.SerializedName

class ResultListCategory (
    @SerializedName("categories" ) var categories : ArrayList<Categories> = arrayListOf()
        )
