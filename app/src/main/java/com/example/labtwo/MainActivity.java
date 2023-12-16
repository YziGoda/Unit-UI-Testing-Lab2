package com.example.labtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText edUserInput;
    Button btnCount;
    TextView tvMain;
    Spinner spSelectOption;
    TextCounter tc = new TextCounter();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.btnCount = findViewById(R.id.btnCount);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectOption = (Spinner) findViewById(R.id.spSelectOption);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectOption.setAdapter(adapter);
    }

    public void onBtnCountClick(View view)
    {

        if (this.edUserInput.getText().toString().equals(""))
        {
            Toast.makeText(this,"No words or symbols detected.", Toast.LENGTH_LONG).show();
        }
        else
        {
            if (this.spSelectOption.getSelectedItem().toString().equals("Symbols"))
            {
                int result = tc.countSymbols(this.edUserInput.getText().toString());
                this.tvMain.setText("Symbols: "+ String.valueOf(result));
            }
            else if (this.spSelectOption.getSelectedItem().toString().equals("Words"))
            {
                int result = tc.countWords(this.edUserInput.getText().toString());
                this.tvMain.setText("Words: " + String.valueOf(result));
            }
        }

        // int result = TextCounter.countSymbols(this.edUserInput.getText().toString());
        // Log.i("CountResult", String.valueOf(result)); //consoleje pasiziurime ar veikia
        // this.tvMain.setText(String.valueOf(result)); // isprintina rezultata i tvMain

    }
}