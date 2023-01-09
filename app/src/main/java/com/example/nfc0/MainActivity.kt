package com.example.nfc0

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.NfcEvent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //проверка наличия и включённости
        /*
        /*private*/ var nfcAdapter: NfcAdapter? = null//private val isNfcSupported: Boolean = this.nfcAdapter != null
        /*private*/ val isNfcSupported: Boolean = this.NfcAdapter != null//private val isNfcSupported: Boolean = this.nfcAdapter != null

        if (!isNfcSupported) {
            Toast.makeText(this, "Nfc is not supported on this device", Toast.LENGTH_SHORT).show()
            finish()
        }
        if (!nfcAdapter?.isEnabled!!) {
            Toast.makeText(
                this,
                "NFC disabled on this device. Turn on to proceed",
                Toast.LENGTH_SHORT
            ).show()
        }
        */

    }
}