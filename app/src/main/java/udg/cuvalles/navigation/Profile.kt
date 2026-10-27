package udg.cuvalles.navigation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(
    userId: String,
    userName: String,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil de Usuario",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "ID: $userId",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nombre: $userName",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onNavigateBack
        ) {
            Text("Regresar")
        }
    }
}
