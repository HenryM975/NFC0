package com.example.nfc0

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.*
import android.nfc.tech.NfcA
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
        val InfoNFC = findViewById<TextView>(R.id.InfoNFC)
        InfoNFC.setText(tag.toString())





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

    /*override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                // Process the messages array
            }
        }
    }*/
    /*override fun onNewIntent(intent: Intent?)
    {
        super.onNewIntent(intent)
        var tagFromIntent: Tag? = intent?.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        val nfc = NfcA.get(tagFromIntent)

        val atqa: ByteArray = nfc.getAtqa()
        val sak: Short = nfc.getSak()
        nfc.connect()
        val isConnected= nfc.isConnected()

        if(isConnected)
        {
            val receivedData:ByteArray= nfc.transceive(NFC_READ_COMMAND)
            //code to handle the received data
            // Received data would be in the form of a byte array that can be converted to string
            //NFC_READ_COMMAND would be the custom command you would have to send to your NFC Tag in order to read it
        }
        else{
            Log.e("ans", "Not connected")
        }

    }
    private fun enableForegroundDispatch(activity: AppCompatActivity, adapter: NfcAdapter?) {
        val intent = Intent(activity.applicationContext, activity.javaClass)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(activity.applicationContext, 0, intent, 0)
        val filters = arrayOfNulls<IntentFilter>(1)
        val techList = arrayOf<Array<String>>()
        filters[0] = IntentFilter()
        with(filters[0]) {
            this?.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED)
            this?.addCategory(Intent.CATEGORY_DEFAULT)
            try {
                this?.addDataType("text/plain")
            } catch (ex: IntentFilter.MalformedMimeTypeException) {
                throw RuntimeException()
            }
        }
        adapter?.enableForegroundDispatch(activity, pendingIntent, filters, techList)
    }
    override fun onResume() {
        super.onResume()
        enableForegroundDispatch(this, this.nfcAdapter)
    }*/



}