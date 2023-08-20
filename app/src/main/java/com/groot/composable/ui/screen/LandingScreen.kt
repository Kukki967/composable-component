package com.groot.composable.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.groot.composable.NavDest
import com.groot.composable.ui.dto.ComponentCardLabel
import com.groot.composable.ui.theme.contentModifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavHostController) {

    val list = listOf<ComponentCardLabel>(ComponentCardLabel.LIST, ComponentCardLabel.FORM)


    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = contentModifier
        ) {
            Text(text = "List of composable components")
        }

        LazyColumn {
            itemsIndexed(list) { index: Int, item: ComponentCardLabel ->
                ListItem(title = item) {
                    when (item) {
                        ComponentCardLabel.LIST -> {
                            navController.navigate(NavDest.composableListScreen)
                        }

                        else -> {

                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(title: ComponentCardLabel, function: () -> Unit) {

    Surface(
        onClick = {

            function()
        },
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = contentModifier
        ) {
            Text(
                text = title.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.weight(0.1f))

            Image(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "right arrow"
            )

        }
    }
}