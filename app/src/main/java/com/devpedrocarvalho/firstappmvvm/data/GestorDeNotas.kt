package com.devpedrocarvalho.firstappmvvm.data

import androidx.lifecycle.MutableLiveData

class GestorDeNotas(val database: Database) {


    fun getNotas() = database.obterNotas()

    fun addNota(mNota: Nota) {

        database.inserirNota(mNota)
    }

    }
