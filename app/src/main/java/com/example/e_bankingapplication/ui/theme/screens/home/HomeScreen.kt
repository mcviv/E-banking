package com.example.e_bankingapplication.ui.theme.screens.home

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.e_bankingapplication.navigation.ROUTE_ABOUT
import com.example.e_bankingapplication.navigation.ROUTE_ADD_CLIENT
import com.example.e_bankingapplication.navigation.ROUTE_AIRTIME
import com.example.e_bankingapplication.navigation.ROUTE_UPDATE_CLIENT
import com.example.e_bankingapplication.navigation.ROUTE_VIEW_CLIENT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("E-Banking App", color = Color.Blue) })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            // Create a Row to hold the cards
            Column {
                // Card for "Buy Airtime"
                ClickableCard(title = "Buy Airtime", onClick = { navController.navigate(ROUTE_AIRTIME) })

                // Spacer between cards
                Spacer(modifier = Modifier.height(16.dp))

                // Card for "Add Client"
                ClickableCard(title = "Add Client", onClick = { navController.navigate(ROUTE_ADD_CLIENT) })

                // Spacer between cards
                Spacer(modifier = Modifier.height(16.dp))

                // Card for "Update Client"
                ClickableCard(title = "About Us", onClick = { navController.navigate(ROUTE_ABOUT) })

                // Spacer between cards
                Spacer(modifier = Modifier.height(16.dp))

                // Card for "View Client"
                ClickableCard(title = "View Client", onClick = { navController.navigate(ROUTE_VIEW_CLIENT) })
            }
        }
    }
}

@Composable
fun ClickableCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
