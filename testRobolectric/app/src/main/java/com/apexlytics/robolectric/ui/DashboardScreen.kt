package com.apexlytics.robolectric.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Card(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            Box(Modifier.padding(16.dp)) { Text("Analytics Overview") }
        }
        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            Box(Modifier.padding(16.dp)) { Text("Recent Activity") }
        }
        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            Box(Modifier.padding(16.dp)) { Text("Performance Metrics") }
        }
    }
}
