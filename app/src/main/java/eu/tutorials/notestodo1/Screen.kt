package eu.tutorials.notestodo1

sealed class Screen(val route : String) {
    object First : Screen("Notes_screen")
    object  Second1 : Screen("NotesScreen_screen")
    object Third : Screen("NotesDetail_screen")
}