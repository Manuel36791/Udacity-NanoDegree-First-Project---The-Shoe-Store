package com.example.udacitynanodegreefirstproject_theshoestore.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udacitynanodegreefirstproject_theshoestore.Model.ShoeModel

class AppViewModel: ViewModel() {

    var currentShoe: ShoeModel? = null

    private val _shoes = MutableLiveData<List<ShoeModel>>()
    val shoes: LiveData<List<ShoeModel>>
        get() = _shoes

    private val _eventCloseScreen = MutableLiveData<Boolean?>()
    val eventCloseScreen: LiveData<Boolean?>
    get() = _eventCloseScreen

    private val _eventShowWelcomeScreen = MutableLiveData<Boolean?>()
    val eventShowWelcomeScreen: LiveData<Boolean?>
        get() = _eventShowWelcomeScreen

    private val _eventShowInstructionScreen = MutableLiveData<Boolean?>()
    val eventShowInstructionScreen: LiveData<Boolean?>
        get() = _eventShowInstructionScreen

    private val _eventShowShoeListScreen = MutableLiveData<Boolean?>()
    val eventShowShoeListScreen: LiveData<Boolean?>
        get() = _eventShowShoeListScreen

    fun close() {
        _eventCloseScreen.value = true
    }

    fun onEventCloseComplete() {
        _eventCloseScreen.value = null
    }

    fun showWelcomeScreen() {
        _eventShowWelcomeScreen.value = true
    }

    fun onEventShowWelcomeScreenComplete() {
        _eventShowWelcomeScreen.value = null
    }

    fun showInstructionScreen() {
        _eventShowInstructionScreen.value = true
    }

    fun onEventShowInstructionScreenComplete() {
        _eventShowInstructionScreen.value = null
    }

    fun showShoeListScreen() {
        _eventShowShoeListScreen.value = true
    }

    fun onEventShowShowListScreenComplete() {
        _eventShowShoeListScreen.value = null
    }

    fun createNewShoe() {
        currentShoe = ShoeModel("", 0.0, "", "")
    }

    init {
        _shoes.value = createSampleShoes()
    }

    private fun createSampleShoes(): List<ShoeModel> {
        val tempShoes = mutableListOf<ShoeModel>()

        tempShoes.add(ShoeModel("Originals Vegan Samba", 36.0, "adidas", "Originals Vegan Samba trainers in white"))
        tempShoes.add(ShoeModel("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable", ))

        return tempShoes
    }

    fun save() {
        val tempShoes = mutableListOf<ShoeModel>()

        _shoes.value?.let {
            tempShoes.addAll(it)
        }

        currentShoe?.let {
            tempShoes.add(it)
        }

        _shoes.value = tempShoes
        _eventCloseScreen.value = true
    }
}