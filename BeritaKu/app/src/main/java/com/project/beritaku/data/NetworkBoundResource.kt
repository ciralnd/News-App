package com.project.beritaku.data

import com.project.beritaku.data.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

@Suppress("UNCHECKED_CAST")
abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {

                emit(
                    Resource.Success(apiResponse.data as ResultType)
                )
            }

            is ApiResponse.Empty -> {
                emit(
                    Resource.Success(apiResponse as ResultType)
                )
            }

            is ApiResponse.Error -> {
                emit(
                    Resource.Error(apiResponse.errorMessage)
                )
            }
        }
    }

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}