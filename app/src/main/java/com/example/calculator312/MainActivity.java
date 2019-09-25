package com.example.calculator312;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private TextView btn_0;
    private TextView btn_1;
    private TextView btn_2;
    private TextView btn_3;
    private TextView btn_4;
    private TextView btn_5;
    private TextView btn_6;
    private TextView btn_7;
    private TextView btn_8;
    private TextView btn_9;
    private TextView btn_point;
    private TextView btn_c;
    private TextView btn_change;
    private TextView btn_division;
    private TextView btn_multiplication;
    private TextView btn_minus;
    private TextView btn_plus;
    private TextView btn_equal;

    private boolean anchor = false;
    private boolean changeAnchor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult("9");
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResult(".");
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("0");
                anchor=false;
            }
        });
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultText;
                if (changeAnchor) {
                    resultText = "-" + result.getText().toString();
                    result.setText(resultText);
                    changeAnchor = false;
                }
                else {
                    resultText = result.getText().toString();
                    resultText = resultText.substring(1);
                    result.setText(resultText);
                    changeAnchor = true;
                }
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("/");
            }
        });
        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("*");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("end");
            }
        });
    }

    private void addResult(String value){
        String resultText;
        resultText = result.getText().toString();
        if(!anchor){
            resultText="";
            anchor=true;
        }
        resultText += value;
        result.setText(resultText);
    }

    private void calculate(String operation) {
        String resultText;
        resultText = result.getText().toString();

        if(!operation.equals("end")){
            resultText+=operation;
            result.setText(resultText);
        }

        String signs[] = resultText.split("([0-9]*[.])?[0-9]+");
        String figures[] = resultText.split("[\\+\\*\\-\\/]");
        double value = Double.parseDouble(figures[0]);

        if(figures.length>1){
            for (int i = 1; i < figures.length; i++) {
                switch (signs[i]) {
                    case "+":
                        value = value+Double.parseDouble(figures[i]);
                        break;
                    case "-":
                        value = value-Double.parseDouble(figures[i]);
                        break;
                    case "/":
                        value = value/Double.parseDouble(figures[i]);
                        break;
                    case "*":
                        value = value*Double.parseDouble(figures[i]);
                        break;
                }
            }
        }

        String resultString = Double.toString(value);
        if(operation.equals("end")) {
            result.setText(resultString);
        }
    }

    private void initView(){
        result = findViewById(R.id.resultPanel);
        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_point=findViewById(R.id.btn_point);
        btn_c = findViewById(R.id.btn_c);
        btn_change = findViewById(R.id.btn_change);
        btn_division = findViewById(R.id.btn_division);
        btn_multiplication= findViewById(R.id.btn_multiplication);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_equal= findViewById(R.id.btn_equal);
    }
}
