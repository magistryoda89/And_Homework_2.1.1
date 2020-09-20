package com.kolomiytsev.and_homework_211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMoney;
    private EditText etInfo;
    private Button btnOk;
    private CheckBox cbCard;
    private CheckBox cbMobile;
    private CheckBox cbCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        confirmTransfer();
    }

    private void initViews() {
        etMoney = findViewById(R.id.et_money);
        etInfo = findViewById(R.id.et_info);
        btnOk = findViewById(R.id.btn_ok);
        cbCard = findViewById(R.id.cb_card);
        cbMobile = findViewById(R.id.cb_mobile);
        cbCash = findViewById(R.id.cb_cash);
        cbCard.setOnCheckedChangeListener(checkedChangeListener);
        cbMobile.setOnCheckedChangeListener(checkedChangeListener);
        cbCash.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes() {
        cbCard.setChecked(false);
        cbMobile.setChecked(false);
        cbCash.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.cb_card:
                        resetCheckBoxes();
                        cbCard.setChecked(true);
                        etInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.cb_mobile:
                        resetCheckBoxes();
                        cbMobile.setChecked(true);
                        etInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.cb_cash:
                        resetCheckBoxes();
                        cbCash.setChecked(true);
                        etInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }
            }
        }
    };

    private void confirmTransfer() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbCard.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.btn_ok_card_text), Toast.LENGTH_LONG).show();
                } else if(cbMobile.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.btn_ok_mobile_text), Toast.LENGTH_LONG).show();
                } else if(cbCash.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.btn_ok_cash_text), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.btn_ok_none_text), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
