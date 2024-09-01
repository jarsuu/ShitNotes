import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shitnotes.exercise.ExerciseCategoryPage
import com.example.shitnotes.exercise.ExerciseListPage
import com.example.shitnotes.exercise.ExerciseListViewModel
import com.example.shitnotes.HomePage
import com.example.shitnotes.HomeViewModel
import com.example.shitnotes.exercise.ExerciseCreationPage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavRouter() {
    val homeViewModel = HomeViewModel()
    val exerciseListViewModel = ExerciseListViewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomePage(navController, homeViewModel)
        }
        composable(route = "exercise-category") {
            ExerciseCategoryPage(navController, exerciseListViewModel)
        }
        composable(route = "exercise-category/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            ExerciseListPage(navController, exerciseListViewModel,category)
        }
        composable(route = "exercise-create") {
            ExerciseCreationPage(navController)
        }
    }
}