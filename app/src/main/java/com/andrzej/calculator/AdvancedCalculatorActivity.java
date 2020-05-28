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
    String function = "";
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_calculator_layout);
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
        onClickLog();
        onClickLn();
        onClickPowY();
        onClickCE();
    }

    private void printNumber(String number)
    {
        if(function == "") {
            cleared = false;
            if (operation != ' ') secondDigit = true;
            editText.append(number);
        }
    }

    private boolean validateFunction()
    {
        if(editText.getText().toString().length() == 0) return false;

        if(editText.getText().toString().length() == 1 && editText.getText().toString().charAt(0) == '-') return false;

        if(function!="") return false;
        cleared=false;
        if(!secondDigit) numberOne = Double.parseDouble(editText.getText().toString());
        else numberTwo = Double.parseDouble(editText.getText().toString());

        return true;
    }

    private void onClickSinus()
    {
        Button button = (Button) findViewById(R.id.buttonAdvSin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateFunction()) return;
                editText.setText("sin("+editText.getText().toString()+")");
                function = "sin";
            }
        });
    }

    private void onClickCE(){
        Button button = (Button) findViewById(R.id.buttonAdvCE);
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
                    if(editText.getText().toString().length() == 0) return;
                    String screen = editText.getText().toString();
                    editText.setText(screen.substring(0,screen.length()-1));
                    cleared=true;
                }
            }
        });
    }

    private void onClickCosinus()
    {
        Button button = (Button) findViewById(R.id.buttonAdvCos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText("cos("+editText.getText().toString()+")");
                function = "cos";
            }
        });
    }

    private void onClickTangens()
    {
        Button button = (Button) findViewById(R.id.buttonAdvTan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText("tg("+editText.getText().toString()+")");
                function = "tg";
            }
        });
    }

    private void onClickSqrt()
    {
        Button button = (Button) findViewById(R.id.buttonAdvSqrt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText("sqrt("+editText.getText().toString()+")");
                function = "sqrt";
            }
        });
    }

    private void onClickPower()
    {
        Button button = (Button) findViewById(R.id.buttonAdvPower2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText(editText.getText().toString()+"^2");
                function = "x^2";
            }
        });
    }

    private void onClickDot(){
        Button button = (Button) findViewById(R.id.buttonAdvDot);
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
        Button button = (Button) findViewById(R.id.buttonAdvEquals);
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
                        if(function != "") calculateAdvanced();
                        Calculate(operation);
                    }
                }

                if (operation != '+' && flag != 1) {
                    if(function != "") calculateAdvanced();
                    else numberOne = Double.parseDouble(editText.getText().toString());
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
        Button button = (Button) findViewById(R.id.buttonAdvMultiply);
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
        Button button = (Button) findViewById(R.id.buttonAdvDivide);
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

    private void onClickLog()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvLog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText("log("+editText.getText().toString()+")");
                function = "log";
            }
        });

    }

    private void onClickLn()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvLn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText("ln("+editText.getText().toString()+")");
                function = "ln";
            }
        });
    }

    private void onClickPowY()
    {
        cleared=false;
        Button button = (Button) findViewById(R.id.buttonAdvPowerY);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFunction();
                editText.setText(editText.getText().toString()+"^");
                function = "x^y";
            }
        });
    }

    private void calculateAdvanced()
    {
        switch(function)
        {
            case "log":
                if(!secondDigit) numberOne = Math.log10(numberOne);
                else numberTwo = Math.log10(numberTwo);
                break;
            case "ln":
                if(!secondDigit) numberOne = Math.log(numberOne);
                else numberTwo = Math.log(numberTwo);
                break;
            case "x^y":
                int id = editText.getText().toString().indexOf("^");
                int length = editText.getText().length();
                double index = Double.parseDouble(editText.getText().toString().substring(id + 1, length));
                if(!secondDigit) numberOne = Math.pow(numberOne,index);
                else numberTwo = Math.pow(numberTwo,index);
                break;
            case "x^2":
                if(!secondDigit) numberOne = Math.pow(numberOne,2);
                else numberTwo = Math.pow(numberTwo,2);
                break;
            case "sin":
                if(!secondDigit) numberOne = Math.sin(numberOne);
                else numberTwo = Math.sin(numberTwo);
                break;
            case "cos":
                if(!secondDigit) numberOne = Math.cos(numberOne);
                else numberTwo = Math.cos(numberTwo);
                break;
            case "tg":
                if(!secondDigit) numberOne = Math.tan(numberOne);
                else numberTwo = Math.tan(numberTwo);
                break;
            case "sqrt":
                if(!secondDigit) numberOne = Math.sqrt(numberOne);
                else numberTwo = Math.sqrt(numberTwo);
                break;
        }
        function = "";
    }

    private void Calculate(char op)
    {

        if(function != "") calculateAdvanced();
        else {
            String number = editText.getText().toString();
            numberTwo = Double.parseDouble(number);
        }

        switch(op) {
            case '+':
                double result = numberOne + numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '-':
                result = numberOne - numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '*':
                result = numberOne * numberTwo;
                editText.setText(Double.toString(result));
                break;
            case '/':
                result = numberOne / numberTwo;
                editText.setText(Double.toString(result));
                break;
            case ' ':
                editText.setText(Double.toString(numberOne));

        }
        operation = ' ';
        numberOne=0;
        numberTwo=0;
        flag = 2;
        secondDigit = false;
        numberText.setText("");
        function = "";
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("editText",editText.getText().toString());
        outState.putString("numberText",numberText.getText().toString());
        outState.putString("function",function);
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
        function = savedInstanceState.getString("function");
        secondDigit = savedInstanceState.getBoolean("secondDigit");
        cleared = savedInstanceState.getBoolean("cleared");
        operation = savedInstanceState.getChar("operation");
        flag = savedInstanceState.getInt("flag");
    }
}
