package com.mvvmarch.secondchance.ui.characterList

import androidx.lifecycle.ViewModel
import com.mvvmarch.secondchance.model.repo.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(val repository: CharactersRepository) : ViewModel() {
    val characters = repository.getCharacters()
}