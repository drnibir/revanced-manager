package app.revanced.manager.ui.screen.settings.update

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.revanced.manager.R
import app.revanced.manager.ui.component.AppTopBar
import app.revanced.manager.ui.component.NotificationCard
import app.revanced.manager.ui.component.SettingsListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatesSettingsScreen(
    onBackClick: () -> Unit,
    onChangelogClick: () -> Unit,
    onUpdateClick: () -> Unit,
) {
    val listItems = listOf(
        Triple(
            stringResource(R.string.update_channel),
            stringResource(R.string.update_channel_description),
            third = { /*TODO*/ }
        ),
        Triple(
            stringResource(R.string.update_notifications),
            stringResource(R.string.update_notifications_description),
            third = { /*TODO*/ }
        ),
        Triple(
            stringResource(R.string.changelog),
            stringResource(R.string.changelog_description),
            third = onChangelogClick
        ),
    )


    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.updates),
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            NotificationCard(
                text = stringResource(R.string.update_notification),
                icon = Icons.Default.Update,
                primaryAction = onUpdateClick
            )

            listItems.forEach { (title, description, onClick) ->
                SettingsListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .clickable { onClick() },
                    headlineContent = title,
                    supportingContent = description
                )
            }
        }
    }
}