package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView input, result;
    String inputt = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        result = findViewById(R.id.result);


    }

    public void setInput(String givenValue){
        inputt = inputt + givenValue;
        input.setText(inputt);
    }

    public void clearClicked(View view) {
        input.setText("");
        inputt = "";
        result.setText("0");

    }

    public void plusMinusClicked(View view) {

        String num = input.getText().toString();
        int number = Integer.parseInt(num);
        if (number > 0){
            input.setText("-" .concat(num));
        } else if (number < 0){
            input.setText(Math.abs(number));
        }
    }

    public void modClicked(View view) {
        setInput("^");
    }

    public void divideClicked(View view) {
        setInput("/");
    }

    public void sevenClicked(View view) {
        setInput("7");
    }

    public void eightClicked(View view) {
        setInput("8");
    }

    public void nineClicked(View view) {
        setInput("9");
    }

    public void multiplyClicked(View view) {
        setInput("*");
    }

    public void fourClicked(View view) {
        setInput("4");
    }

    public void fiveClicked(View view) {
        setInput("5");
    }

    public void sixClicked(View view) {
        setInput("6");
    }

    public void minusClicked(View view) {
        setInput("-");
    }

    public void twoClicked(View view) {
        setInput("2");
    }

    public void oneClicked(View view) {
        setInput("1");
    }

    public void threeClicked(View view) {
        setInput("3");
    }

    public void plusClicked(View view) {
        setInput("+");
    }

    public void zeroClicked(View view) {
        setInput("0");
    }

    public void dotClicked(View view) {
        setInput(".");
    }

    public void backClicked(View view) {
        String res = input.getText().toString();
        int range = res.length();
        if (range > 0){
            input.setText(res.substring(0, range-1));
        }
    }

    public void equalClicked(View view) {
        Double resultt = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            resultt = (double)engine.eval(inputt);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (resultt != null){
            result.setText(String.valueOf(resultt.doubleValue()));
        }
    }
}