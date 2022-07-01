package com.matrix_maeny.morsecodeconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnShare, btnConvert;
    private EditText editTextInput;
    private TextView textViewOutput;

    private String currentMorseCode = "";

    final MorseCodeConverter morseCodeConverter = new MorseCodeConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        btnShare = findViewById(R.id.btnShare);
        btnConvert = findViewById(R.id.btnConvert);
        editTextInput = findViewById(R.id.editTextInput);
        textViewOutput = findViewById(R.id.textViewOutput);

        btnConvert.setOnClickListener(btnConvertListener);
        btnShare.setOnClickListener(btnShareListener);
    }

    View.OnClickListener btnConvertListener = v -> {
        String msgTxt = "";
        try {
            msgTxt = editTextInput.getText().toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }

        convertInstantData(msgTxt);
    };

    View.OnClickListener btnShareListener = v -> {
        shareText();
    };

    private void shareText() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, currentMorseCode);

        startActivity(intent);
    }


    @SuppressLint("SetTextI18n")
    private void convertInstantData(String msgTxt) {

        this.currentMorseCode = morseCodeConverter.getMorseCodeFromMessage(msgTxt);

        if (!currentMorseCode.equals(""))
            textViewOutput.setText(currentMorseCode);
        else
            textViewOutput.setText("Morse code appears here!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        startActivity(new Intent(MainActivity.this, AboutActivity.class));

        return super.onOptionsItemSelected(item);
    }
}