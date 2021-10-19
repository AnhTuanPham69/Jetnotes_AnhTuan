package com.example.jetnote.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.repository.Repository
import com.example.jetnote.domain.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model used for storing the global app state.
 *
 * This view model is used for all screens.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {


    val notesNotInTrash : LiveData<List<NoteModel>> by lazy {
        repository.getAllNotesNotInTrash()
    }

    fun onCreateNewNoteClick(){

    }

    fun onNoteClick(note: NoteModel){

    }

    fun onNoteCheckedChange(note:NoteModel){
        viewModelScope.launch(Dispatchers.Default){
            repository.insertNote(note)
        }
    }
}
