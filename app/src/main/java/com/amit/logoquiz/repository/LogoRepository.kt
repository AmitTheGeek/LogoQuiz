package com.amit.logoquiz.repository

import com.amit.logoquiz.model.LogoQuiz

interface LogoRepository {

    fun loadLogoQuiz() : List<LogoQuiz>
}