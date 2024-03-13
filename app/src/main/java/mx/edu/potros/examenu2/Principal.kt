package mx.edu.potros.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class Principal : AppCompatActivity() {
    var detalles = ArrayList<Detalles>()
    var globos = ArrayList<Detalles>()
    var peluches = ArrayList<Detalles>()
    var regalos = ArrayList<Detalles>()
    var tazas = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        cargarDetalles()
        cargarGlobos()
        cargarPeluches()
        cargarRegalos()
        cargarTazas()


        val btnDetalles = findViewById<Button>(R.id.btn_detalles)
        val btnGlobos = findViewById<Button>(R.id.btn_globos)
        val btnPeluches = findViewById<Button>(R.id.btn_peluches)
        val btnRegalos = findViewById<Button>(R.id.btn_regalos)
        val btnTazas = findViewById<Button>(R.id.btn_tazas)



        btnDetalles.setOnClickListener {
            mostrarProductos(detalles, "Detalles")
        }
        btnGlobos.setOnClickListener {
            mostrarProductos(globos, "Globos")
        }
        btnPeluches.setOnClickListener {
            mostrarProductos(peluches, "Peluches")
        }
        btnRegalos.setOnClickListener {
            mostrarProductos(regalos, "Regalos")
        }
        btnTazas.setOnClickListener {
            mostrarProductos(tazas, "Tazas")
        }
    }

    private fun mostrarProductos(productos: ArrayList<Detalles>, tipo: String) {
        val intent = Intent(this, Regalos::class.java)
        intent.putExtra("productos", productos.toTypedArray())
        intent.putExtra("tipo", tipo)
        startActivity(intent)
    }

    fun cargarDetalles(){
        detalles.add(Detalles(R.drawable.cumplebotanas,"$280"))
    }

    fun cargarGlobos(){
        globos.add(Detalles(R.drawable.globos,"$280"))
    }

    fun cargarPeluches(){
        peluches.add(Detalles(R.drawable.peluches,"$280"))
    }

    fun cargarRegalos(){
        regalos.add(Detalles(R.drawable.regalos,"$280"))
    }

    fun cargarTazas(){
        tazas.add(Detalles(R.drawable.tazas,"$280"))
    }

}




class ProductosAdapter(private val context: Context, private val productos: ArrayList<Detalles>) : BaseAdapter() {

    override fun getCount(): Int {
        return productos.size
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var detalles=productos[p0]
        var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var vista=inflator.inflate(R.layout.activity_detalle_regalos,null)
        var image: ImageView =vista.findViewById(R.id.iv_regalo_imagen)
        var title: TextView =vista.findViewById(R.id.tv_regalo_precio)

        image.setImageResource(detalles.image)
        title.setText(detalles.precio)

        image.setOnClickListener(){
            val intento = Intent(context,DetalleRegalos::class.java)
            intento.putExtra("imagen",detalles.image)
            intento.putExtra("precio",detalles.precio)
            context!!.startActivity(intento)
        }
        return vista
    }
}