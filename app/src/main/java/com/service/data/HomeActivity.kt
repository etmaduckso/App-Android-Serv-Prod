package com.service.data

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.service.data.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar ActionBar
        supportActionBar?.apply {
            title = getString(R.string.app_name)
        }

        // Adicionar informações sobre o AgroService
        binding.agroServiceInfo.text = "Bem-vindo ao AgroService! Aqui você encontra informações sobre nossos serviços e produtos."

        setupButton()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar o menu explicitamente
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupButton() {
binding.calculateButton.setOnClickListener {
    // Ação removida para a MainActivity
}

        binding.buttonServicos.setOnClickListener {
            startActivity(Intent(this, ServicosActivity::class.java))
        }

        binding.buttonProdutos.setOnClickListener {
            startActivity(Intent(this, ProdutosActivity::class.java))
        }
    }

    private fun logout() {
        // Limpa a pilha de atividades e volta para o login
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
} 