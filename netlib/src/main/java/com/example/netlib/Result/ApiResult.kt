package com.example.netlib.Result

import android.util.Log
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val message: String, val code: Int? = null) : ApiResult<Nothing>()
}

private const val TAG = "ApiClient"

internal suspend fun <T> safeCall(name: String, call: suspend () -> T): ApiResult<T> {
    Log.i(TAG, "[$TAG]: Запрос - $name")
    return try {
        val data = call()
        Log.d(TAG, "[$TAG]: Успех - $name")
        ApiResult.Success(data)
    } catch (e: HttpException){
        val message = when(e.code()) {
            401 -> "Сессия истекла"
            404 -> "Не найдено"
            in 500..599 -> "Ошибка сервера"
            else -> "Ошибка запроса (${e.code()})"
        }
        Log.e(TAG, "[$TAG]: Ошибка - $name (код ${e.code()})")
        ApiResult.Error(message, e.code())
    } catch (e: IOException){
        Log.e(TAG, "[$TAG]: Ошибка - $name (Ошибка соединения)")
        ApiResult.Error("Нет соединения с интернетом")
    } catch (e: SerializationException){
        Log.e(TAG, "[$TAG]: Ошибка - $name (некорректный ответ)")
        ApiResult.Error("Некорректный ответ сервера")
    }
}