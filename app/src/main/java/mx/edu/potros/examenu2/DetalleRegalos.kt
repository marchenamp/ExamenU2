package mx.edu.potros.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val iv_detalles_image: ImageView = findViewById(R.id.iv_regalo_imagen)
        val tv_precio: TextView = findViewById(R.id.tv_regalo_precio)

        val bundle=intent.extras
        if(bundle!=null){
            iv_detalles_image.setImageResource(bundle.getInt("imagen"))
            tv_precio.setText(bundle.getString("precio"))
        }
    }
}