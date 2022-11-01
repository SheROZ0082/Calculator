package com.example.w;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second;
    private boolean isOperationClick;
    private String operation;
    private Integer result;
    private Button btn_next;
    private Button backspace;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.zero);
        btn_next = findViewById(R.id.btn_next);
        backspace = findViewById(R.id.btn_backspace);
        backspaceLogic();
        showNext();
        clickNext();
    }

    private void showNext() {
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    if (result > 0) {
                        btn_next.setVisibility(View.VISIBLE);
                    } else {
                        btn_next.setVisibility(View.GONE);
                    }
                } catch (NullPointerException nullPointerException) {
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void clickNext() {
        btn_next.setOnClickListener(view1 -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String text = textView.getText().toString();
            intent.putExtra("nextbtn", text);
            startActivity(intent);
            finish();
        });
    }

    private void backspaceLogic() {
        backspace.setOnClickListener(v -> {


            String str = textView.getText().toString();
            if (str.length() >= 1) {
                str = str.substring(0, str.length() - 1);
                textView.setText(str);
            } else if (str.length() <= 1) {
                textView.setText("0");
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void OnNumberClick(View view) {

        switch (view.getId()) {
            case R.id.btn_one:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("1");
                } else if (isOperationClick) {
                    textView.setText("1");
                } else {
                    textView.append("1");
                }
                break;

            case R.id.btn_two:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("2");
                } else if (isOperationClick) {
                    textView.setText("2");
                } else {
                    textView.append("2");
                }
                break;

            case R.id.btn_3:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("3");
                } else if (isOperationClick) {
                    textView.setText("3");
                } else {
                    textView.append("3");
                }
                break;

            case R.id.btn_4:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("4");
                } else if (isOperationClick) {
                    textView.setText("4");
                } else {
                    textView.append("4");
                }
                break;

            case R.id.btn_5:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("5");
                } else if (isOperationClick) {
                    textView.setText("5");
                } else {
                    textView.append("5");
                }
                break;

            case R.id.btn_6:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("6");
                } else if (isOperationClick) {
                    textView.setText("6");
                } else {
                    textView.append("6");
                }
                break;

            case R.id.btn_7:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("7");
                } else if (isOperationClick) {
                    textView.setText("7");
                } else {
                    textView.append("7");
                }
                break;

            case R.id.btn_8:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("8");
                } else if (isOperationClick) {
                    textView.setText("8");
                } else {
                    textView.append("8");
                }
                break;

            case R.id.btn_9:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("9");
                } else if (isOperationClick) {
                    textView.setText("9");
                } else {
                    textView.append("9");
                }
                break;

            case R.id.zero:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("0");
                } else if (isOperationClick) {
                    textView.setText("0");
                } else {
                    textView.append("0");
                }
                break;

            case R.id.btn_clear:
                textView.setText("0");
                break;
        }
        isOperationClick = false;
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Integer.parseInt(textView.getText().toString());
                operation = "+";
                break;

            case R.id.btn_minus:
                first = Integer.parseInt(textView.getText().toString());
                operation = "-";
                break;

            case R.id.btn_multiply:
                first = Integer.parseInt(textView.getText().toString());
                operation = "*";
                break;
            case R.id.btn_divide:
                first = Integer.parseInt(textView.getText().toString());
                operation = "/";
                break;

            case R.id.btn_equal:
                second = Integer.parseInt(textView.getText().toString());

                second = Integer.parseInt(textView.getText().toString());
                Integer result = 0;
                isOperationClick = true;
                if (isOperationClick = true)
                    findViewById(R.id.btn_next).setVisibility(View.VISIBLE);

                switch (operation) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                textView.setText(result.toString());

                break;

            case R.id.btn_clear:
                textView.setText("0");
                btn_next.setVisibility(View.GONE);
                break;
        }
        isOperationClick = true;
    }


}
