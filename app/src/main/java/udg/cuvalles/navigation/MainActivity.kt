
package udg.cuvalles.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import android.net.Uri
import udg.cuvalles.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavigationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {
            Home(
                onNavigationProfile = { userId, userName ->

                    val encodedId = Uri.encode(userId)
                    val encodedName = Uri.encode(userName)

                    navController.navigate(
                        "profile/$encodedId/$encodedName"
                    )
                }
            )
        }

        composable(
            route = "profile/{userId}/{userName}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.StringType
                },
                navArgument("userName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val userId =
                backStackEntry.arguments?.getString("userId") ?: ""

            val userName =
                backStackEntry.arguments?.getString("userName") ?: ""

            Profile(
                userId = userId,
                userName = userName,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
