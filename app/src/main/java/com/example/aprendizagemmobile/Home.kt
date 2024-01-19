package com.example.aprendizagemmobile
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

import com.example.aprendizagemmobile.adapter.EventoAdapter
import com.example.aprendizagemmobile.model.Evento

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


        // Inicialize a DrawerLayout
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Chama a função para ir buscar dados da API
        fetchData()


        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navView.getHeaderView(0)
        val btnFechar = headerView.findViewById<ImageButton>(R.id.btn_close_drawer)

        val menu = navView.menu

        val menu1 = menu.findItem(R.id.nav_item1)
        val menu2 = menu.findItem(R.id.nav_item2)
        val menu3 = menu.findItem(R.id.nav_item3)

        menu1.setOnMenuItemClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
            true
        }

        menu2.setOnMenuItemClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
            true
        }

        menu3.setOnMenuItemClickListener {
            val intent = Intent(this, Config::class.java)
            startActivity(intent)
            true
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

    private fun fetchData() {
        val eventosadapter = EventoAdapter(emptyList())
        lifecycleScope.launch {
            val eventos = evento.eventoDao().listarEventos()
            val adapter = EventoAdapter(eventos)
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = adapter
            eventosadapter.updateEventos(eventos)

            


            //Colocar um eventListner em cada botão para ir para o ecrã de detalhes
            //Inserir um evento
            //evento.eventoDao().inserir(Evento(nome = "Evento 1", localizacao = "Porto", dataInicio = "2021-05-05", idHorarios = 1, dataFim = "2021-05-05", preco = 0.0, descricao = "Evento 1", gratuito = true))
        }
    }
    private fun abrirProximaPagina(id: Int) {
        /*val intent = Intent(this, ::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)*/
    }
}
