package id.co.kpkrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.kpkrecyclerview.model.Pelanggan
import kotlinx.android.synthetic.main.activity_main.*
import id.co.kpkrecyclerview.adapter.PelangganAdapter

class MainActivity : AppCompatActivity() {

    //buat global variable untuk menampung data pelanggan

    var listPlg = mutableListOf<Pelanggan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tambahkan data kedalam variable pelanggan
        listPlg.add(Pelanggan("441102949294", "Samsul1", "Jl. Sesama  1", "R1", "900"))
        listPlg.add(Pelanggan("441102949233", "Samsul2", "Jl. Sesama2", "R1", "900"))
        listPlg.add(Pelanggan("441102949292", "Samsul3", "Jl. Sesama3", "R1", "900"))
        listPlg.add(Pelanggan("441102949291", "Samsul4", "Jl. Sesama4", "R1", "900"))
        listPlg.add(Pelanggan("441102949290", "Samsul5", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949290", "Samsul6", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949232", "Samsul7", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949216", "Samsul8", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949234", "Samsul9", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949283", "Samsul10", "Jl. Sesama5", "R1", "900"))
        listPlg.add(Pelanggan("441102949226", "Samsul11", "Jl. Sesama5", "R1", "900"))

        //masukan data pelanggan ke recycler view

        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PelangganAdapter(listPlg)
        }
    }
}
