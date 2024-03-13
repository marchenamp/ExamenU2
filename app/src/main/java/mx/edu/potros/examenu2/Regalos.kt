package mx.edu.potros.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class Regalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        val productos = intent.getSerializableExtra("productos") as Array<Detalles>
        val tipo = intent.getStringExtra("tipo")

        title = tipo

        val gridView = findViewById<GridView>(R.id.regalos_catalogo)
        val adapter = ProductosAdapter(this, productos.toList())
        gridView.adapter = adapter
    }
}