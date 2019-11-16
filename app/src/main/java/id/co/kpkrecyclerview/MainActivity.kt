package id.co.kpkrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.kpkrecyclerview.model.Pelanggan
import kotlinx.android.synthetic.main.activity_main.*
import id.co.kpkrecyclerview.adapter.PelangganAdapter
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class MainActivity : AppCompatActivity() {

    //buat global variable untuk menampung data pelanggan

    var listPlg = mutableListOf<Pelanggan>()
    val adapterPlg = PelangganAdapter(listPlg)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTampilan()

        //masukan data pelanggan ke recycler view

        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterPlg
        }
    }

    fun initTampilan() {
        btnsimpan.setOnClickListener {
            database.use {
                insert(
                    "pelanggan",
                    "idpel" to idpel.text.toString(),
                    "nama" to nama.text.toString(),
                    "alamat" to alamat.text.toString(),
                    "tarif" to tarif.text.toString(),
                    "daya" to daya.text.toString()
                )
                listPlg.add(
                    Pelanggan(
                        idpel.text.toString(),
                        nama.text.toString(),
                        alamat.text.toString(),
                        tarif.text.toString(),
                        daya.text.toString()

                    )
                )
                adapterPlg.notifyDataSetChanged()
            }

        }
    }

    override fun onResume() {
        bacaDatabase()
        super.onResume()
    }


    fun bacaDatabase() {
        database.use {
            select("pelanggan").exec {
               // if (isFirst) {
                    while (this.moveToNext()) {
                        listPlg.add(
                            Pelanggan(
                                getString(getColumnIndex("idpel")),
                                getString(getColumnIndex("nama")),
                                getString(getColumnIndex("alamat")),
                                getString(getColumnIndex("tarif")),
                                getString(getColumnIndex("daya"))

                            )
                        )

                    }
                    adapterPlg.notifyDataSetChanged()
                //}

            }
        }
    }

}
