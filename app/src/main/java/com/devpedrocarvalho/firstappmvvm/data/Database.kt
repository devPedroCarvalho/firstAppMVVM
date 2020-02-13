package com.devpedrocarvalho.firstappmvvm.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val mDadatabase: MutableLiveData<MutableList<Nota>> = MutableLiveData()


    fun inserirNota(nota: Nota){

        var tmp = mDadatabase.value
        if(tmp == null){
            tmp = mutableListOf()
            tmp.add(nota)
        }else{
            tmp?.add(nota)
        }
        mDadatabase.postValue(tmp)
    }

    fun obterNotas() = mDadatabase


}