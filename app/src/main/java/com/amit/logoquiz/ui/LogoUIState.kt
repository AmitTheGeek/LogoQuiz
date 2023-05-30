package com.amit.logoquiz.ui

import com.amit.logoquiz.model.LogoQuiz

sealed interface LogoUIState {
    class Loading(val isLoading : Boolean) : LogoUIState
    class PayLoad(val logoQuiz: LogoQuiz) : LogoUIState
}