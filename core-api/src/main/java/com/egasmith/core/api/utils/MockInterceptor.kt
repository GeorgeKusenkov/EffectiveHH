package com.egasmith.core.api.utils

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import android.util.Log


class MockInterceptor (private val jsonReader: AssetJsonReader): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val uri = request.url.toUri().toString()

        val responseString = jsonReader.getJsonFromAssets("hhrespose.json")

        return if (responseString != null) {
            Log.d("MockInterceptor", "Returning mock response for: $uri")
            Log.d("MockInterceptor", "responseString: $responseString")
            Response.Builder()
                .request(request)
                .code(200)
                .message("OK")
                .body(responseString.toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .protocol(Protocol.HTTP_1_1)
                .build()
        } else {
            Log.d("MockInterceptor", "No mock response found for: $uri")
            chain.proceed(request)
        }
    }
}