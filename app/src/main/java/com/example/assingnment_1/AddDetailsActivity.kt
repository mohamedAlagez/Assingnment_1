package com.example.assingnment_1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_details.*

class AddDetailsActivity : AppCompatActivity() {
    var database = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_details)

        btnSaveData.setOnClickListener {
            var details = Model(
                System.currentTimeMillis().toString(),
                nameEd.text.toString(),
                addressEd.text.toString(),
                phoneEd.text.toString()
            )

            database.collection("userDetails").document("${details.id}").set(details)
                .addOnFailureListener {
                    Toast.makeText(
                        applicationContext,
                        "Fail to add data",
                        Toast.LENGTH_LONG
                    ).show()
                }.addOnSuccessListener {
                    nameEd.setText("")
                    addressEd.setText("")
                    phoneEd.setText("")
                    Toast.makeText(applicationContext, "Data add successfully", Toast.LENGTH_LONG)
                        .show()
                }

            startActivity(Intent(applicationContext, MainActivity::class.java))

        }

    }
}