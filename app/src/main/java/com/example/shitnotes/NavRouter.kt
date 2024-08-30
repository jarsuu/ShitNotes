import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shitnotes.exercise.ExerciseCategory
import com.example.shitnotes.exercise.ExerciseList
import com.example.shitnotes.exercise.ExerciseListViewModel
import com.example.shitnotes.Home
import com.example.shitnotes.HomeViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavRouter() {
    val homeViewModel = HomeViewModel()
    val exerciseListViewModel = ExerciseListViewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(navController, homeViewModel)
        }
        composable(route = "exercise-category") {
            ExerciseCategory(navController, exerciseListViewModel)
        }
        composable(route = "exercise-category/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            ExerciseList(navController, exerciseListViewModel,category)
        }
    }
}