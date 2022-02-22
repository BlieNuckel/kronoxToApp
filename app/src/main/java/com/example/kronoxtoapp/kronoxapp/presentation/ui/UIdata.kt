package com.example.kronoxtoapp.kronoxapp.presentation.ui

data class UIdata (
    val mapOfPrograms: Map<String, String> = mapOf("SGGS2" to "p.SGGS2+2021+35+100+NML+sv",
        "TGDU3" to "p.TBSE2+2021+35+100+NML+en"),

    val listOfPrograms: List<String> = listOf("TGDU3", "SGGS2")
)