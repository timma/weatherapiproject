package com.farshatov.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<E : ViewEvent, S : ViewState, C : ViewCommand> : ViewModel() {

    protected abstract val initialState: S

    protected val state: S
        get() = uiState().value

    private val mutableState: MutableStateFlow<S> by lazy { MutableStateFlow(initialState) }

    fun uiState(): StateFlow<S> = mutableState.asStateFlow()

    protected fun updateState(newState: S) {
        mutableState.value = newState
    }

    private val command: Channel<ViewCommand> = Channel()

    fun uiCommand(): Flow<ViewCommand> = command.receiveAsFlow()

    protected fun setCommand(newCommand: C) {
        launch { command.send(newCommand) }
    }

    abstract fun perform(viewEvent: E)

    fun launch(
        excHandler: CoroutineExceptionHandler? = null,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(excHandler ?: EmptyCoroutineContext) { block() }
}
