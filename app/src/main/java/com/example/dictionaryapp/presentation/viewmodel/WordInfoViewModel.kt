package com.example.dictionaryapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.Util.Resource
import com.example.dictionaryapp.domain.usecase.WordInfoUsecase
import com.example.dictionaryapp.presentation.WordInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val  wordInfoUsecase: WordInfoUsecase
) : ViewModel() {

    private val _searchQuery by lazy { mutableStateOf("") }
    val searchQuery: State<String> = _searchQuery

    private val _state by lazy { mutableStateOf(WordInfoState()) }
    val state: State<WordInfoState> = _state

    private val _eventFlow by lazy { MutableSharedFlow<UIEvent>() }
    val eventFlow: SharedFlow<UIEvent> = _eventFlow

    private var searchJob: Job? = null

    fun onSearch(word: String) {
        _searchQuery.value = word
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            wordInfoUsecase(word = word)
                .onEach { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(UIEvent.showSnackbar(result.message ?: "Unknown Error"))
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }

                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                }.launchIn(this)
        }
    }

    sealed class UIEvent {
        data class showSnackbar(val message: String) : UIEvent()
    }

}