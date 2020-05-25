package com.andrzej.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Character.isDigit;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    TextView editText,numberText;
    double numberOne = 0;
    double numberTwo = 0;
    boolean secondDigit= false;
    boolean cleared=false;
    char operation = ' ';
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_calculator_layout);
        editText = (TextView) findViewById(R.id.textView);
        numberText = (TextView) findViewById(R.id.textView2);

        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("1");
            }
        });

        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("2");
            }
        });

        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("3");
            }
        });

        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("4");
            }
        });

        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("5");
            }
        });

        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("6");
            }
        });

        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("7");
            }
        });

        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("8");
            }
        });

        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("9");
            }
        });

        Button buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if(operation != ' ') secondDigit =true;
                editText.append("0");
            }
        });

        onClickSign();
        onClickMultiply();
        onClickDivide();
        onClickEquals();
        onClickDot();
        onClickMinus();
        onClickPlus();
        onClickSinus();
        onClickCosinus();
        onClickTangens();
        onClickSqrt();
        onClickPower();
    }

    private void onClickSinus()
    {
        Button button = (Button) findViewById(R.id.buttonSin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                Calculate('s');
            }
        });
    }

    private void onClickCosinus()
    {
        Button button = (Button) findViewById(R.id.buttonCos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                Calculate('c');
            }
        });
    }

    private void onClickTangens()
    {
        Button button = (Button) findViewById(R.id.buttonTan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                Calculate('t');
            }
        });
    }

    private void onClickSqrt()
    {
        Button button = (Button) findViewById(R.id.buttonSqrt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                Calculate('r');
            }
        });
    }

    private void onClickPower()
    {
        Button button = (Button) findViewById(R.id.buttonPower2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                Calculate('p');
            }
        });
    }

    private void onClickDot(){
        Button button = (Button) findViewById(R.id.buttonDot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                String text = editText.getText().toString();
                if(text.contains(".")) return;
                editText.append(".");
            }
        });
    }

    private void onClickEquals()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonEquals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(operation);
            }
        });
    }

    private void onClickSign()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonSign);
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
        Button button = (Button) findViewById(R.id.buttonPlus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleared=false;
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate(operation);
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
        Button button = (Button) findViewById(R.id.buttonMinus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate(operation);
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
        Button button = (Button) findViewById(R.id.buttonMultiply);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate(operation);
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
        Button button = (Button) findViewById(R.id.buttonDivide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != ' ' ) {
                    if(flag!=0 && secondDigit == true) {
                        Calculate(operation);
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



    private void Calculate(char op)
    {
        switch(op) {
            case '+':
                String number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                double result = numberOne + numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '-':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                result = numberOne - numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '*':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                result = numberOne * numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '/':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                result = numberOne / numberTwo;
                editText.setText(Double.toString(result));
                break;
            case 's':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                numberTwo = Math.sin(Math.toRadians(numberTwo));
                editText.setText(Double.toString(numberTwo));
                return;
            case 'c':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                numberTwo = Math.cos(Math.toRadians(numberTwo));
                editText.setText(Double.toString(numberTwo));
                return;
            case 't':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                numberTwo = Math.tan(Math.toRadians(numberTwo));
                editText.setText(Double.toString(numberTwo));
                return;
            case 'r':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                numberTwo = Math.sqrt(numberTwo);
                editText.setText(Double.toString(numberTwo));
                return;
            case 'p':
                number = editText.getText().toString();
                numberTwo = Double.parseDouble(number);
                numberTwo = Math.pow(numberTwo,2);
                editText.setText(Double.toString(numberTwo));
                return;

        }
        operation = ' ';
        numberOne=0;
        numberTwo=0;
        flag = 2;
        secondDigit = false;
        numberText.setText("");
    }
}
