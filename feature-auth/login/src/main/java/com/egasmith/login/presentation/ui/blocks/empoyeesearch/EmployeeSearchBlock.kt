package com.egasmith.login.presentation.ui.blocks.empoyeesearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.login.R

@Composable
fun EmployeeSearchBlock() {
    InfoBlock(
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                HeaderText(stringResource(R.string.employee_search))
                Spacer(modifier = Modifier.height(4.dp))
                StandardText(
                    text = stringResource(R.string.vacancy_and_resume_access),
                )
                Spacer(modifier = Modifier.height(14.dp))
                GreenConfirmButton(text = stringResource(R.string.i_am_looking_for_employees))
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EmployeeSearchBlockPreview() {
    EffectiveMobileProjectHHTheme {
        EmployeeSearchBlock()
    }
}
