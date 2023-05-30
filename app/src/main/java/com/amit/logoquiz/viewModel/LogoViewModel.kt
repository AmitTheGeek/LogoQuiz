package com.amit.logoquiz.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amit.logoquiz.model.LogoQuiz
import com.amit.logoquiz.repository.LogoRepository
import com.amit.logoquiz.ui.LogoUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LogoViewModel @Inject constructor(
    private val repository: LogoRepository
) : ViewModel() {

    private lateinit var logoQuizList: List<LogoQuiz>

    private val _logoUiState = MutableSharedFlow<LogoUIState>()
    val logoUiState = _logoUiState.asSharedFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            logoQuizList = repository.loadLogoQuiz()
        }
    }


    suspend fun loadLogoQuizPayload() {
        viewModelScope.launch(Dispatchers.IO) {
            _logoUiState.emit(LogoUIState.Loading(true))

            val payload = logoQuizList.random()

            _logoUiState.emit(LogoUIState.PayLoad(payload))

            _logoUiState.emit(LogoUIState.Loading(false))

        }
    }
}