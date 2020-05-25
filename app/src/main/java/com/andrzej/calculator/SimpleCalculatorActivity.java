package com.andrzej.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator_layout);
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

        onClickCE();
        onClickSign();
        onClickMultiply();
        onClickDivide();
        onClickEquals();
        onClickDot();
        onClickMinus();
        onClickPlus();
    }





    private void onClickCE(){
        Button button = (Button) findViewById(R.id.buttonCE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(cleared)
               {
                   numberOne = 0;
                   numberTwo = 0;
                   secondDigit= false;
                   cleared=false;
                   operation = ' ';
                   flag=0;
                   editText.setText("");
               }else
               {
                   String screen = editText.getText().toString();
                   boolean isDigit = isDigit(screen.charAt(screen.length()-1));
                   if(isDigit)
                       editText.setText(screen.substring(0,screen.length()-1));

                   cleared=true;
               }
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
                Calculate();
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
        Button button = (Button) findViewById(R.id.buttonMinus);
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
        Button button = (Button) findViewById(R.id.buttonMultiply);
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
        Button button = (Button) findViewById(R.id.buttonDivide);
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

        }
        operation = ' ';
        numberOne=0;
        numberTwo=0;
        flag = 2;
        secondDigit = false;
        numberText.setText("");
    }
}
