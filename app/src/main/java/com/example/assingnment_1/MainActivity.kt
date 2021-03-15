package com.example.assingnment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var database = FirebaseFirestore.getInstance()
    var detailslist = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database.collection("userDetails")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {

                        var userId = document["id"].toString()
                        var userName = document["name"].toString()
                        var userAddress = document["address"].toString()
                        var userPhoneNum = document["phone"].toString()

                        detailslist.add(Model(userId, userName, userAddress, userPhoneNum))
                    }

                    rvDetails.layoutManager = LinearLayoutManager(applicationContext)
                    rvDetails.adapter = DetailsAdapter(this, detailslist)
                }
            }

        myFAB.setOnClickListener {
            startActivity(Intent(applicationContext, AddDetailsActivity::class.java))
        }
    }

    override fun onRestart() {
        super.onRestart()
        recreate()
    }
}