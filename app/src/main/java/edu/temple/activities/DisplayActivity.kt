package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    private val textSizeLauncher = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selectedTextSize = result.data?.getFloatExtra("SELECTED_TEXT_SIZE", 16f) ?: 16f
            // TODO Step 3: Use returned value for lyricsDisplayTextView text size
            lyricsDisplayTextView.textSize = selectedTextSize
        }
    }

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {

            val intent = Intent(this, TextSizeActivity::class.java)
            textSizeLauncher.launch(intent)
        }
    }
}
