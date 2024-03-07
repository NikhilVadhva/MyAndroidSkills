package com.example.myandroidskills.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroidskills.model.repo.DefaultRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import java.lang.Exception

class DefaultViewModel : ViewModel() {

    private val defaultRepository = DefaultRepository()
    private val _number = mutableStateOf(0)

    val number: State<Int>
        get() = _number

    var mFlowData: Flow<Int> = flow {
        (1..5).forEach {
             throw Exception()
            emit(it)
            delay(1000)
        }
    }.onCompletion { throwable ->
        if (throwable == null)
            Log.d("mData:", "onCompletion Done")
        else
            Log.d("mData:", "Failed")

    }.onStart {
        emit(101)
        Log.d("mData:", "onStartCalled")
    }.catch {
        Log.d("mData","Caught in catch")
    }


    fun runFlowData() {
        /// use of different terminal operator of flow
        val flowData = flowOf(1, 2, 3, 4, 5, 1, 2, 3)
        viewModelScope.launch {
            // toList terminal
            println(flowData.toList())
            // toSet terminal
            println(flowData.toSet())
            // first terminal
            println(flowData.first())
            // first + predicate
            println(flowData.filter { it % 2 == 0 }.first())
            // reduce
            println(flowData.reduce { accumulator, value -> accumulator * value })
            // fold
            println(flowData.fold(2) { accumulator, value -> accumulator * value })


        }

    }


    init {

        /* defaultRepository.generateNumber().forEach {
             _number.value = it
             Log.d("number generated", it.toString())
         }*/

        viewModelScope.launch {
            defaultRepository.generateNumberUsingFlow().map { it * it }.collect {
                _number.value = it
                Log.d("number generated", it.toString())
            }
        }
        Log.d("number execution status", "completed ")

        /* viewModelScope.launch {
             defaultRepository.getFlowFlavour().collect{
                 _number.value = it
                 Log.d("number generated", it.toString())
             }
         }
 */
        /// use launchIn and onEach terminal method in flow

        /* viewModelScope.launch {
             defaultRepository.generateNumberUsingFlow().onEach {
                 _number.value = it
                 Log.d("number generated", it.toString())
             }.launchIn(this)

             defaultRepository.generateNumberUsingFlow().onEach {
                 _number.value = it
                 Log.d("number generated", it.toString())
             }.launchIn(this)
         }
 */

    }
}