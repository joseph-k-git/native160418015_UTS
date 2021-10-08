package com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Account
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe

class AccountDetailViewModel(application: Application): AndroidViewModel(application)
{
    val accountLD = MutableLiveData<Account>()

    fun fetch() {
        accountLD.value = Account.getMockAccount();
    }

    override fun onCleared() {
        super.onCleared()
    }
}