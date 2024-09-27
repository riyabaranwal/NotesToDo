package eu.tutorials.notestodo1

import android.app.Application

class NotesListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }

}