package eu.tutorials.notestodo1

import android.app.Application
import eu.tutorials.notestodo1.Graphh.Graph

class NotesListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }

}