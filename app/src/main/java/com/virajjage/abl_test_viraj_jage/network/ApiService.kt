package com.virajjage.abl_test_viraj_jage.network

import com.virajjage.abl_test_viraj_jage.models.UserResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/bins/6c3je")
    fun getUsers(): Observable<UserResponseModel>
}