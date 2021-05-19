package com.example.rickandmortycharacters.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository : Repository) : ViewModel(){
    private  val TAG = "MainViewModel"
    private val _charactersLiveData = MutableLiveData<List<Character>>()
    val charactersLiveData : LiveData<List<Character>> get() = _charactersLiveData
    init {
        getCharacters()
    }
    private fun getCharacters (){
        viewModelScope.launch{
            try {
                _charactersLiveData.value = repository.getCharacters("1").results
                Log.d(TAG,"${_charactersLiveData.value}")
            }
        catch (e: Exception){
            Log.v(TAG,e.message.toString())
        }
    }
}
}