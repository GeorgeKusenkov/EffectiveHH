package com.egasmith.presentation.vacancydetails.ui.components.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egasmith.domain.model.VacancyDetails
import com.egasmith.presentation.vacancydetails.ui.components.main.companyInfo.CompanyInfo
import com.egasmith.presentation.vacancydetails.ui.components.main.companyInfo.Responsibilities
import com.egasmith.presentation.vacancydetails.ui.components.main.header.VacancyHeader
import com.egasmith.presentation.vacancydetails.ui.components.main.questions.Questions
import com.egasmith.presentation.vacancydetails.ui.components.main.statisticCards.VacancyStatisticCards

@Composable
fun VacancyDetailsList(
    vacancy: VacancyDetails,
    onQuestionClick: (String) -> Unit,
    onConfirmClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        item {
            VacancyHeader(
                title = vacancy.title,
                salary = vacancy.salary?.full ?: "Не указана",
                experience = vacancy.experience.text,
                schedules = vacancy.schedules.firstOrNull() ?: "Не указан",
            )
        }
        item {
            VacancyStatisticCards(
                appliedNumber = vacancy.appliedNumber ?: 0,
                lookingNumber = vacancy.lookingNumber ?: 0
            )
        }
        item {
            CompanyInfo(
                companyTitle = vacancy.company.name,
                city = vacancy.company.address.city,
                street = "${vacancy.company.address.street}, ${vacancy.company.address.building}"
            )
        }
        item {
            Responsibilities(
                description = vacancy.company.description ?: "",
                responsibilities = vacancy.responsibilities
            )
        }
        item {
            Questions(
                onQuestionClick = onQuestionClick,
                onConfirmClick = onConfirmClick
            )
        }
    }
}