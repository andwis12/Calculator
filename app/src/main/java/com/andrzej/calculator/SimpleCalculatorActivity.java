package com.andrzej.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import static java.lang.Character.isDigit;

public class SimpleCalculatorActivity extends AppCompatActivity
{

    TextView editText,numberText;
    double numberOne = 0;
    double numberTwo = 0;
    boolean secondDigit= false;
    boolean cleared=false;
    char operation = ' ';
    int flag=0;
    DecimalFormat decimalFormat = new DecimalFormat("#.##########");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator_layout);
        editText = (TextView) findViewById(R.id.textView);
        numberText = (TextView) findViewById(R.id.textView2);

        Button buttonOne = (Button) findViewById(R.id.buttonAdvOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("1");
            }
        });

        Button buttonTwo = (Button) findViewById(R.id.buttonAdvTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("2");
            }
        });

        Button buttonThree = (Button) findViewById(R.id.buttonAdvThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("3");
            }
        });

        Button buttonFour = (Button) findViewById(R.id.buttonAdvFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("4");
            }
        });

        Button buttonFive = (Button) findViewById(R.id.buttonAdvFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("5");
            }
        });

        Button buttonSix = (Button) findViewById(R.id.buttonAdvSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("6");
            }
        });

        Button buttonSeven = (Button) findViewById(R.id.buttonAdvSeven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("7");
            }
        });

        Button buttonEight = (Button) findViewById(R.id.buttonAdvEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("8");
            }
        });

        Button buttonNine = (Button) findViewById(R.id.buttonAdvNine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("9");
            }
        });

        Button buttonZero = (Button) findViewById(R.id.buttonAdvZero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber("0");
            }
        });

        onClickCE();
        onClickAC();
        onClickSign();
        onClickMultiply();
        onClickDivide();
        onClickEquals();
        onClickDot();
        onClickMinus();
        onClickPlus();
    }



    private void printNumber(String number)
    {
        cleared = false;
        if (operation != ' ') secondDigit = true;
        editText.append(number);
    }


    private void onClickCE(){
        Button button = (Button) findViewById(R.id.buttonAdvCE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cleared)
                {
                    clear();
                }else
                {
                    cleared=true;
                    if(editText.getText().toString().length() == 0) return;
                    String screen = editText.getText().toString();
                    editText.setText(screen.substring(0,screen.length()-1));

                }
            }
        });
    }

    private void onClickAC(){
        Button button = (Button) findViewById(R.id.buttonAdvAC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }

    private void clear()
    {
        numberOne = 0;
        numberTwo = 0;
        secondDigit= false;
        cleared=false;
        operation = ' ';
        flag=0;
        editText.setText("");
        numberText.setText("");
    }

    private void onClickDot(){
        Button button = (Button) findViewById(R.id.buttonAdvDot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                String text = editText.getText().toString();
                if(text.contains(".")) return;

                if(editText.getText().toString().length() == 0) editText.append("0.");
                else editText.append(".");
            }
        });
    }

    private void onClickEquals()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvEquals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
    }

    private void onClickSign()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvSign);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentNumber = editText.getText().toString();
                if(currentNumber.length() > 0)
                {
                    if(currentNumber.equals("0")) return;

                    if(currentNumber.charAt(0) == '-')
                        currentNumber = currentNumber.substring(1);
                    else currentNumber = "-" + currentNumber;

                    editText.setText(currentNumber);
                }
            }
        });
    }

    private void onClickPlus()
    {
        Button button = (Button) findViewById(R.id.buttonAdvPlus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate();
                    }
                }

                if (operation != '+' && flag != 1) {

                    numberOne = Double.parseDouble(editText.getText().toString());
                    operation = '+';
                    numberText.setText(editText.getText()+" + ");
                    editText.setText("");
                    flag = 1;
                }

            }
        });
    }

    private void onClickMinus()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvMinus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate();
                    }
                }

                if(editText.length() == 0)
                {
                    editText.append("-");
                    return;
                }

                if (operation != '-' && flag != 1) {
                    numberOne = Double.parseDouble(editText.getText().toString());
                    operation = '-';
                    numberText.setText(editText.getText()+" - ");
                    editText.setText("");
                    flag = 1;
                }


            }
        });
    }

    private void onClickMultiply()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvMultiply);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate();
                    }
                }

                if (operation != '*' && flag != 1) {

                    numberOne = Double.parseDouble(editText.getText().toString());
                    operation = '*';
                    numberText.setText(editText.getText()+" * ");
                    editText.setText("");
                    flag = 1;
                }
            }
        });
    }

    private void onClickDivide()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvDivide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate();
                    }
                }

                if (operation != '/' && flag != 1) {
                    numberOne = Double.parseDouble(editText.getText().toString());
                    operation = '/';
                    numberText.setText(editText.getText()+" / ");
                    editText.setText("");
                    flag = 1;
                }
            }
        });
    }



    private void Calculate()
    {
        switch(operation) {
            case '+':
                String number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                double result = numberOne + numberTwo;
                if (Double.isInfinite(result) || Double.isNaN(result)) editText.setText("Aaaaaaaaaaa");
                    else{
                editText.setText(decimalFormat.format(result));
                }
                break;
            case '-':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                result = numberOne - numberTwo;
                editText.setText(decimalFormat.format(result));
                break;
            case '*':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                result = numberOne * numberTwo;
                if (Double.isInfinite(result) || Double.isNaN(result)) {
                    Toast.makeText(getApplicationContext(), "Wrong input", Toast.LENGTH_SHORT).show();
                }
                else{
                    editText.setText(decimalFormat.format(result));
                }
                break;
            case '/':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                if (numberTwo == 0) {
                    Toast.makeText(getApplicationContext(), "Division by 0 not allowed", Toast.LENGTH_SHORT).show();
                    clear();
                    return;
                }
                result = numberOne / numberTwo;
                editText.setText(decimalFormat.format(result));
                break;
            case ' ':
                editText.setText(decimalFormat.format(numberOne));


        }
        operation = ' ';
        numberOne=0;
        numberTwo=0;
        flag = 2;
        secondDigit = false;
        numberText.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("editText",editText.getText().toString());
        outState.putString("numberText",numberText.getText().toString());
        outState.putDouble("numberOne",numberOne);
        outState.putDouble("numberTwo",numberTwo);
        outState.putBoolean("secondDigit",secondDigit);
        outState.putBoolean("cleared",cleared);
        outState.putChar("operation",operation);
        outState.putInt("flag",flag);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState)
    {
        editText.setText(savedInstanceState.getString("editText"));
        numberText.setText(savedInstanceState.getString("numberText"));
        numberOne = savedInstanceState.getDouble("numberOne");
        numberTwo = savedInstanceState.getDouble("numberTwo");
        secondDigit = savedInstanceState.getBoolean("secondDigit");
        cleared = savedInstanceState.getBoolean("cleared");
        operation = savedInstanceState.getChar("operation");
        flag = savedInstanceState.getInt("flag");
    }
}
