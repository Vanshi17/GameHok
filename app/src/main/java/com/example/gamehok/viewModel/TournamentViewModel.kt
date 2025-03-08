package com.example.gamehok.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamehok.api.RetrofitInstance
import com.example.gamehok.model.Tournament
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TournamentViewModel : ViewModel() {
    private val _tournament = MutableStateFlow<Tournament?>(null)
    val tournament: StateFlow<Tournament?> = _tournament

    fun fetchTournamentById(tournamentId: Int) {
        viewModelScope.launch {
            try {
                val tournaments = RetrofitInstance.api.getTournaments()
                _tournament.value = tournaments.find { it.id == tournamentId }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
