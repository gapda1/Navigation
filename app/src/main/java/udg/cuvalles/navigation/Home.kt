package udg.cuvalles.navigation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(
    onNavigationProfile: (String, String) -> Unit
) {
    var userId by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ingresa el nombre del usuario",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            label = { Text("Id Usuario") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nombre Usuario") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (userId.isNotBlank() && userName.isNotBlank()) {
                    onNavigationProfile(userId, userName)
                }
            },
            enabled = userId.isNotBlank() && userName.isNotBlank()
        ) {
            Text("Ir al perfil")
        }
    }
}
