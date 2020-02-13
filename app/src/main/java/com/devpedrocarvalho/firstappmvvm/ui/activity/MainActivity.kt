package com.devpedrocarvalho.firstappmvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpedrocarvalho.firstappmvvm.ui.adapter.NotasAdapter
import com.devpedrocarvalho.firstappmvvm.R
import com.devpedrocarvalho.firstappmvvm.data.Nota
import com.devpedrocarvalho.firstappmvvm.viewmodels.NotasViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_ui.view.*

class MainActivity : AppCompatActivity() {


    private lateinit var notasViewModel: NotasViewModel

   private val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaRV.adapter = notasAdapter
        listaRV.layoutManager = LinearLayoutManager(this)

        //inicializar vieModel
        notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)

        notasViewModel.getNotas().observe(this, Observer {data ->
            data?.let {
                notasAdapter.add(it)
                if (it.isEmpty()){
                    Toast.makeText(this, "Lista vazia",Toast.LENGTH_SHORT).show()
                } else{
                    notasAdapter.add(it)
                }
            }
        })

         
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId.equals(R.id.adicionarMN)){
            dialogoAddNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogoAddNota() {
        val layout = LayoutInflater.from(this).inflate(R.layout.dialog_ui, null, false)

        val inputNota = layout.suaNotaET


        val dialog = AlertDialog.Builder(this)
        dialog.setView(layout)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar") {d, i ->
            // salvar a nota
            var nota = Nota(0, inputNota.text.toString())

            notasViewModel.salvarNota(nota)
            //debug para verificar se a nota esta sendo add
           // val id = nota.id
        }

        dialog.create().show()
    }
}
