package com.project.beritaku.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import com.project.beritaku.utils.SettingsPreferences.Companion.SETTINGS_PREFERENCES
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SETTINGS_PREFERENCES)

class SettingsPreferences(private val dataStore: DataStore<Preferences>) {
    fun getDarkMode() = dataStore.data.map {
        it[PREFS_DARK_MODE] ?: false
    }

    suspend fun setDarkMode(darkMode: Boolean) {
        dataStore.edit {
            it[PREFS_DARK_MODE] = darkMode
        }
    }

    companion object {
        const val SETTINGS_PREFERENCES = "settings_preferences"
        private val PREFS_DARK_MODE = booleanPreferencesKey("dark_mode")

        @Volatile
        private var INSTANCE: SettingsPreferences? = null
    }
}