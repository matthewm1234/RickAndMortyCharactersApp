package com.example.rickandmortycharacters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortycharacters.api.MainViewModel
import com.example.rickandmortycharacters.api.Repository

class MainViewModelFactory (private val repository: Repository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        else{
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}