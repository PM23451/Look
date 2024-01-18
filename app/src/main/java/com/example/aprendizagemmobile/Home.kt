package com.example.aprendizagemmobile
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.aprendizagemmobile.adapter.CidadesAdapter
import com.example.aprendizagemmobile.dao.AppDatabase
import com.example.aprendizagemmobile.repositorio.eventsRepo
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.aprendizagemmobile.dao.EventoDao
import com.example.aprendizagemmobile.entities.Evento
import com.example.aprendizagemmobile.templates.EventoAdapter

class Home : AppCompatActivity() {

    private lateinit var spinnerCidades: Spinner
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var evento: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        evento = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Eventos-db"
        ).build()

        //Chamar o repositorio
        val eventsRepo = eventsRepo.getEventsRepo()

        listarEventos()

        // Inicialize a DrawerLayout
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        // Restante do código...

        // Adicione o seguinte trecho ao método onCreate para configurar a lista
        /*val listView: ListView = findViewById(R.id.nav_list)
        val drawerItems = arrayOf("Item 1", "Subitem 1", "Subitem 2", "Item 2", "Item 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, drawerItems)
        listView.adapter = adapter*/


        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navView.getHeaderView(0)
        val btnFechar = headerView.findViewById<ImageButton>(R.id.btn_close_drawer)
        val menu1 = headerView.findViewById<Button>(R.id.nav_item1)
        val menu2 = headerView.findViewById<Button>(R.id.nav_item2)
        val menu3 = headerView.findViewById<Button>(R.id.nav_item3)

        menu1.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
        menu2.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
        menu3.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
        btnFechar.setOnClickListener {
            drawerLayout.closeDrawer(Gravity.LEFT)
        }

        /*val btnFechar = findViewById<ImageButton>(R.id.btn_close_drawer)
        btnFechar.setOnClickListener {
            drawerLayout.closeDrawer(Gravity.LEFT)
        }*/

        val btnMenu = findViewById<ImageButton>(R.id.imageView4)
        btnMenu.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        // Referência ao Spinner no layout
        spinnerCidades = findViewById(R.id.spinner)

        // Chamada à API para obter a lista de cidades
        val call = RetrofitClient.cidadesService.getCidades()
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    // Configurar o adaptador com a lista de cidades
                    val cidadesAdapter = CidadesAdapter(this@Home, android.R.layout.simple_spinner_item, response.body()!!)
                    cidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    // Associar o adaptador ao Spinner
                    spinnerCidades.adapter = cidadesAdapter
                } else {
                    // Tratar erros de resposta
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Tratar falhas na comunicação com a API
            }

        })

    }

    private fun listarEventos() {
        lifecycleScope.launch {
            val recicleView = findViewById<RecyclerView>(R.id.recyclerView)
            val eventoDao = evento.eventoDao()
            //inserir um evento
            val novoEvento = Evento(
                nome = "Nome do Evento",
                localizacao = "Aveiro",
                dataInicio = "01 Janeiro 2024",  // Substitua com sua data real
                idHorarios = 1,  // Substitua com seu ID de horário real
                dataFim = "03 Janeiro 2024",  // Substitua com sua data real
                preco = 20.0,  // Substitua com seu preço real
                descricao = "Descrição do Evento",
                gratuito = false
            )
            eventoDao.inserir(novoEvento)
            val eventos = eventoDao.listarEventos()
            val adapter = EventoAdapter(eventos)
            recicleView.adapter = adapter
        }
    }
}
