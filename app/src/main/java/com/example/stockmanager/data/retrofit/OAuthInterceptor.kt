package com.example.stockmanager.data.retrofit

import com.example.stockmanager.data.authUser
import okhttp3.Interceptor

class OAuthInterceptor(private val tokenType: String ): Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder()
            .header("Authorization", "$tokenType ${authUser.value?.token}").build()
        return chain.proceed(request)
    }
}
