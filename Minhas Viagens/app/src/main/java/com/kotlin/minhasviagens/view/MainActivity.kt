package com.kotlin.minhasviagens.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import com.kotlin.minhasviagens.R
import com.kotlin.minhasviagens.data.MeusLugares
import com.kotlin.minhasviagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var listaDeLugares = mutableListOf<MeusLugares>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val paris = MeusLugares("Luvre", "Visitar o quadro Monalisa")
        incluirLugares(paris)
        val barcelona = MeusLugares("Sagrada Família", "Uma igreja famosa.")
        incluirLugares(barcelona)
        val luvre = MeusLugares("Victoria Station", "É um prédio histórico")
        incluirLugares(luvre)
        val bonito = MeusLugares("Gruta Lagoa Azul", "Paraíso Ecologico do Pantanal MS")
        incluirLugares(bonito)

        //  deletarLugar(5)
        alteraLugar(3)




        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun nomeDoMetodo(): Boolean {
        return true;
    }

    fun incluirLugares(meusLugares: MeusLugares) {

        Log.e(
            "AppKotlin",
            "Objeto: Meu Lugar ${meusLugares.nomeDoLugar} ${meusLugares.justificativa}"
        )

        listaDeLugares.add(meusLugares)
        listarLugares()
    }

    fun deletarLugarByObjeto(meusLugares: MeusLugares) {
        Log.i("AppKotlin", "Item da lista #${meusLugares.nomeDoLugar} deletado com sucesso.")
        listaDeLugares.remove(meusLugares)
    }

    fun deletarLugarById(numeroItem: Int) {
        Log.i("AppKotlin", "Item da lista #$numeroItem deletado com sucesso.")
    }

    fun alteraLugar(numeroItem: Int) {
        Log.i("AppKotlin", "Item da lista #$numeroItem alterado com sucesso.")
    }

    fun listarLugares() {
        var contador = listaDeLugares.size;
        Log.i("AppKotlin", "Item da lista #$contador alterado com sucesso.")
    }


    fun showMensagem(valor:Double){
        Log.i("AppKotlin", "Valor impresso #$valor com sucesso.")
    }
}