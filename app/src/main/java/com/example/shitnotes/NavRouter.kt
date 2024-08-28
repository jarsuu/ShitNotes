import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shitnotes.ExerciseCategory
import com.example.shitnotes.Home

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavRouter() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(navController)
        }
        composable(route = "exercise-category") {
            ExerciseCategory(navController)
        }
    }
}