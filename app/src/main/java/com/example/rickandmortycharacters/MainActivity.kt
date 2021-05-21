package com.example.rickandmortycharacters

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortycharacters.api.Api
import com.example.rickandmortycharacters.api.Character
import com.example.rickandmortycharacters.api.MainViewModel
import com.example.rickandmortycharacters.api.Repository
import com.example.rickandmortycharacters.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    private val characters = mutableListOf<Character>()
    lateinit var adapter : MainRecyclerAdapter
    private val viewModel : MainViewModel by lazy{
        ViewModelProvider(this,MainViewModelFactory(Repository(Api.apiService)))
            .get (MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel.charactersLiveData.observe(this, Observer {
            characters.addAll(it)
            adapter.notifyDataSetChanged()
        }
        )
        adapter = MainRecyclerAdapter(this,characters)
        binding.characterRv.layoutManager = LinearLayoutManager(this)
        binding.characterRv.adapter = adapter
    }


}