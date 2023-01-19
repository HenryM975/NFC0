//ntag213+
package com.example.nfc0

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.*
import android.nfc.tech.NfcA
import android.nfc.tech.NfcF
import android.os.Bundle
import android.os.Trace.isEnabled
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.TraceCompat.isEnabled


class MainActivity : AppCompatActivity() {


    private var nfcAdapter: NfcAdapter? = null//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CheckNFC = findViewById<TextView>(R.id.CheckNFC)

        var nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter==null) {
            CheckNFC.setText("no nfc");
        } else {
            CheckNFC.setText("NFC");
        }


        val tag: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        val InfoNFC0 = findViewById<TextView>(R.id.InfoNFC0)
        InfoNFC0.setText(tag.toString())


        val InfoNFC1 = findViewById<TextView>(R.id.InfoNFC1)
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) { //?
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                // Process the messages array.
                InfoNFC1.setText(messages.toString())
            }
        }
        //2
        //val tagID: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_ID)
        val tag2: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        val InfoNFC2 = findViewById<TextView>(R.id.InfoNFC2)
        InfoNFC2.setText(tag2.toString())

        //3
        val InfoNFC3 = findViewById<TextView>(R.id.InfoNFC3)
        val tag3: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_ID)
        InfoNFC3.setText(tag3.toString())
        //4
        val InfoNFC4 = findViewById<TextView>(R.id.InfoNFC4)
        val tag4: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_DATA)
        InfoNFC4.setText(tag4.toString())











        //диспетчеризации переднего плана https://developer.android.com/guide/topics/connectivity/nfc/advanced-nfc.html#foreground-dispatch
        val intent = Intent(this, javaClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_MUTABLE)
        val ndef = IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED).apply {
            try {
                addDataType("*/*")    /* Handles all MIME based dispatches.
                                 You should specify only the ones that you need. */
            } catch (e: IntentFilter.MalformedMimeTypeException) {
                throw RuntimeException("fail", e)
            }
        }
        var intentFiltersArray = arrayOf(ndef)
        var techListsArray = arrayOf(arrayOf<String>(NfcF::class.java.name))


    }
}