package com.kh.sample.ktor.usecase

/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.lifecycle.MutableLiveData

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class APIResult<out R> {

    data class Success<out T>(val data: T) : APIResult<T>()
    data class Error(val exception: Exception) : APIResult<Nothing>()
//    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
//            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [APIResult] is of type [Success] & holds non-null [Success.data].
 */
val APIResult<*>.succeeded
    get() = this is APIResult.Success && data != null

fun <T> APIResult<T>.successOr(fallback: T): T {
    return (this as? APIResult.Success<T>)?.data ?: fallback
}

val <T> APIResult<T>.data: T?
    get() = (this as? APIResult.Success)?.data

/**
 * Updates value of [liveData] if [APIResult] is of type [Success]
 */
inline fun <reified T> APIResult<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is APIResult.Success) {
        liveData.value = data
    }
}
///**
// * Updates value of [MutableStateFlow] if [Result] is of type [Success]
// */
//inline fun <reified T> Result<T>.updateOnSuccess(stateFlow: MutableStateFlow<T>) {
//    if (this is Success) {
//        stateFlow.value = data
//    }
//}