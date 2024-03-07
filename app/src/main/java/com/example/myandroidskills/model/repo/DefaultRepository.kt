package com.example.myandroidskills.model.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map


class DefaultRepository {

    /// generate number without using flow
    fun generateNumber() = sequence<Int> {
        for (i in 1..10) {
            yield(i)
            Thread.sleep(2000)
        }
    }

    // use of flow builder
    fun generateNumberUsingFlow(): Flow<Int> = flow {

        for (i in 1..20) {
            emit(i)
            delay(2000)
        }
    }

    /// use of asFlow, flowOf, emitAll
    fun getFlowFlavour(): Flow<Int> = flow {

        val flowBuilder = flowOf(1,2,3)
        emitAll(flowBuilder)
        delay(2000)
        val listFlowBuilder = listOf(1,2,3,4).asFlow()
        emitAll(listFlowBuilder)
        delay(2000)
        emit(8)
    }



}