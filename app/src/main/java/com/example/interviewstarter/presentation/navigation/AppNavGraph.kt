package com.example.interviewstarter.presentation.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.DynamicFeed
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.DynamicFeed
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.interviewstarter.presentation.bookmarks.BookmarksScreen
import com.example.interviewstarter.presentation.bookmarks.BookmarksViewModel
import com.example.interviewstarter.presentation.detail.DetailScreen
import com.example.interviewstarter.presentation.detail.DetailViewModel
import com.example.interviewstarter.presentation.feed.FeedScreen
import com.example.interviewstarter.presentation.feed.FeedViewModel
import com.example.interviewstarter.presentation.settings.SettingsScreen
import com.example.interviewstarter.presentation.settings.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Feed : Screen("feed", "Pulse", Icons.Filled.DynamicFeed, Icons.Outlined.DynamicFeed)
    data object Bookmarks : Screen("bookmarks", "Saved", Icons.Filled.Bookmarks, Icons.Outlined.Bookmarks)
    data object Settings : Screen("settings", "Inspector", Icons.Filled.Settings, Icons.Outlined.Settings)
    data object Detail : Screen("article/{articleId}", "Detail", Icons.Filled.DynamicFeed, Icons.Outlined.DynamicFeed) {
        fun createRoute(articleId: String) = "article/$articleId"
    }
}

val bottomNavItems = listOf(
    Screen.Feed,
    Screen.Bookmarks,
    Screen.Settings
)

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = bottomNavItems.any { it.route == currentRoute }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    bottomNavItems.forEach { screen ->
                        val isSelected = currentRoute == screen.route
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                    contentDescription = screen.title
                                )
                            },
                            label = { Text(screen.title) },
                            selected = isSelected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Feed.route,
            modifier = Modifier.padding(bottom = padding.calculateBottomPadding())
        ) {
            composable(Screen.Feed.route) {
                val feedViewModel: FeedViewModel = koinViewModel()
                FeedScreen(
                    viewModel = feedViewModel,
                    onArticleClick = { articleId ->
                        navController.navigate(Screen.Detail.createRoute(articleId))
                    }
                )
            }

            composable(Screen.Bookmarks.route) {
                val bookmarksViewModel: BookmarksViewModel = koinViewModel()
                BookmarksScreen(
                    viewModel = bookmarksViewModel,
                    onArticleClick = { articleId ->
                        navController.navigate(Screen.Detail.createRoute(articleId))
                    }
                )
            }

            composable(Screen.Settings.route) {
                val settingsViewModel: SettingsViewModel = koinViewModel()
                SettingsScreen(
                    viewModel = settingsViewModel
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("articleId") { type = NavType.StringType }
                ),
                deepLinks = listOf(
                    navDeepLink {
                        uriPattern = "techpulse://article/{articleId}"
                    }
                )
            ) { backStackEntry ->
                val articleId = backStackEntry.arguments?.getString("articleId") ?: ""
                val detailViewModel: DetailViewModel = koinViewModel()
                DetailScreen(
                    articleId = articleId,
                    viewModel = detailViewModel,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
