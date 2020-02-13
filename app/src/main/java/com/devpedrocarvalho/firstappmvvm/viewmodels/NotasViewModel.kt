package com.devpedrocarvalho.firstappmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devpedrocarvalho.firstappmvvm.data.Database
import com.devpedrocarvalho.firstappmvvm.data.GestorDeNotas
import com.devpedrocarvalho.firstappmvvm.data.Nota

class NotasViewModel: ViewModel() {

    private val database = Database()
    private val gestorNotas = GestorDeNotas(database)
    private var mNotas: MutableLiveData<MutableList<Nota>>? = null

    //retornar notas para qualquer lista que quiser
    fun getNotas(): LiveData<MutableList<Nota>> {
        if (mNotas == null){
            mNotas = gestorNotas.getNotas()
        }
        return mNotas!!
    }

    fun salvarNota (mNota: Nota){
        gestorNotas.addNota(mNota)
    }






}