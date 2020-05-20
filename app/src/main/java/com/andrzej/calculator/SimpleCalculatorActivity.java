package com.andrzej.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleCalculatorActivity extends AppCompatActivity
{

    TextView editText;
    double numberOne;
    double numberTwo;
    char operation;
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator_layout);
        editText = (TextView) findViewById(R.id.textView);
        setUpButtons();
    }


    private void setUpButtons()
    {
        onClickOne();
        onClickTwo();
        onClickThree();
        onClickFour();
        onClickFive();
        onClickSix();
        onClickSeven();
        onClickEight();
        onClickNine();
        onClickZero();

        onClickDot();
        onClickPlus();
        onClickMinus();
        onClickDivide();
        onClickMultiply();
        onClickEquals();

    }

    private void onClickDot(){
        Button button = (Button) findViewById(R.id.buttonDot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append(".");
            }
        });
    }

    private void onClickPlus()
    {
        Button button = (Button) findViewById(R.id.buttonPlus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(editText.getText());
                if(operation != ' ' && flag!= 0) Calculate();
                numberOne = Double.parseDouble(editText.getText().toString());
                operation = '+';
                editText.append(" + ");
                flag = 1;
            }
        });
    }
    private void onClickOne() {
        Button button = (Button) findViewById(R.id.buttonOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("1");
            }
        });
    }

    private void onClickTwo() {
        Button button = (Button) findViewById(R.id.buttonTwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("2");
            }
        });
    }

    private void onClickThree() {
        Button button = (Button) findViewById(R.id.buttonThree);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("3");
            }
        });
    }

    private void onClickFour() {
        Button button = (Button) findViewById(R.id.buttonFour);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("4");
            }
        });
    }

    private void onClickFive() {
        Button button = (Button) findViewById(R.id.buttonFive);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("5");
            }
        });
    }

    private void onClickSix() {
        Button button = (Button) findViewById(R.id.buttonSix);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("6");
            }
        });
    }

    private void onClickSeven() {
        Button button = (Button) findViewById(R.id.buttonSeven);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("7");
            }
        });
    }

    private void onClickEight() {
        Button button = (Button) findViewById(R.id.buttonEight);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("8");
            }
        });
    }

    private void onClickNine() {
        Button button = (Button) findViewById(R.id.buttonNine);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("9");
            }
        });
    }

    private void onClickZero() {
        Button button = (Button) findViewById(R.id.buttonZero);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("0");
            }
        });
    }

    private void onClickEquals()
    {
        Button button = (Button) findViewById(R.id.buttonEquals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
    }

    private void onClickMinus()
    {
        Button button = (Button) findViewById(R.id.buttonMinus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation != ' ' && flag!= 0) Calculate();
                numberOne = Double.parseDouble(editText.getText().toString());
                operation = '-';
                editText.append(" - ");
                flag = 1;
            }
        });
    }

    private void onClickMultiply()
    {
        Button button = (Button) findViewById(R.id.buttonMultiply);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operation != ' ' && flag!= 0) Calculate();
                numberOne = Double.parseDouble(editText.getText().toString());
                operation = '*';
                editText.append(" * ");
                flag = 1;
            }
        });
    }

    private void onClickDivide()
    {
        Button button = (Button) findViewById(R.id.buttonDivide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation != ' ' && flag!= 0) Calculate();
                numberOne = Double.parseDouble(editText.getText().toString());
                operation = '/';
                editText.append(" / ");
                flag = 1;
            }
        });
    }



    private void Calculate()
    {
        switch(operation) {
            case '+':
                String res = editText.getText().toString();
                String numbers = res.substring(res.lastIndexOf(" "));
                numberTwo = Double.parseDouble(numbers);
                double result = numberOne + numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '-':
                res = editText.getText().toString();
                numbers = res.substring(res.lastIndexOf(" "));
                numberTwo = Double.parseDouble(numbers);
                result = numberOne - numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '*':
                res = editText.getText().toString();
                numbers = res.substring(res.lastIndexOf(" "));
                numberTwo = Double.parseDouble(numbers);
                result = numberOne * numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '/':
                res = editText.getText().toString();
                numbers = res.substring(res.lastIndexOf(" "));
                numberTwo = Double.parseDouble(numbers);
                result = numberOne / numberTwo;
                editText.setText(Double.toString(result));
                break;

        }
        operation = ' ';
    }



}
