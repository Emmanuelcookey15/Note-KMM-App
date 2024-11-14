package com.example.noteappkmm.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.noteappkmm.android.note_details.NoteDetailScreen
import com.example.noteappkmm.android.note_list.NoteListScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: Any,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ){
        composable<ScreenA>{
            NoteListScreen(
                onNavigateClick = { noteId ->
                    navHostController.navigate(
                        ScreenB(noteId)
                    )
                }
            )
        }
        composable<ScreenB> {
            val args = it.toRoute<ScreenB>()
            val noteId = args.id ?: -1L
            NoteDetailScreen(
                noteId = noteId,
                onNavigateClick = {
                    navHostController.popBackStack()
                }
            )
        }
    }

}

