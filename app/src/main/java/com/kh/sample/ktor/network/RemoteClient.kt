package com.kh.sample.ktor.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

object RemoteClient {
    val ktorHttpClient = HttpClient(Android) {

        install(Logging) {
            level = LogLevel.ALL
        }

        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }


    }
}