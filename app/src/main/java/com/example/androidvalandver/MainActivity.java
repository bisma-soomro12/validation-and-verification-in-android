package com.example.androidvalandver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn;
    //TextInputEditText txt1;
    TextInputLayout txt1, txt2, txt3, txt4, txt5,dropdown;
    AutoCompleteTextView dropdown_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.submit);
        txt1 = findViewById(R.id.fullName);
        txt2 = findViewById(R.id.contactNo);
        txt3 = findViewById(R.id.address);
        txt4 = findViewById(R.id.salary);
        txt5 = findViewById(R.id.salary1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "register", Toast.LENGTH_LONG).show();
                validateName();
                validateContact();
                validateAdd();
                validateSalary();

            }
        });


    }

    public Boolean validateName() {
        String name = txt1.getEditText().getText().toString();
        String regexStr = "^[a-zA-z]$";
        if (name.isEmpty()) {
            txt1.setError("Empty field not allowd");
            return false;
        } else if (name.length() > 20) {
            txt1.setError("Name should be not greater than 20 characters");
            return false;
        }

        else {
            txt1.setError(null);
            txt1.setErrorEnabled(false);
            return true;
        }
    }

    public Boolean validateContact() {
        String regexStr = "^[+923][0-9]{9}$";
        String phone = txt2.getEditText().getText().toString();
        if (phone.isEmpty()) {
            txt2.setError("Empty field not allowd");
            return false;
        }
        else if(!phone.matches(regexStr)){
            txt2.setError("enter valid number");
            return false;
        }
       else if(phone.length()<10)
        {
         txt2.setError("enter valid no");
            return false;
        }

        else {
            txt2.setError(null);
            txt2.setErrorEnabled(false);
            return true;
        }

    }

    public Boolean validateAdd() {
        String add = txt3.getEditText().getText().toString();
        if (add.isEmpty()) {
            txt3.setError("Empty field not allowd");
            return false;}
            else if(add.length()>50)
            {
                txt3.setError("address not allowd greater than 50 charachters");
                return false;
            }
        else {
            txt3.setError(null);
            txt3.setErrorEnabled(false);
            return true;
        }
    }

    public Boolean validateSalary() {
        String salary1 = txt4.getEditText().getText().toString();
        String salary2 = txt5.getEditText().getText().toString();
        int s1=Integer.parseInt(salary1);
        int s2=Integer.parseInt(salary2);

        if (salary1.isEmpty()&&salary2.isEmpty()) {
            txt4.setError("Empty field not allowd");
            txt5.setError("Empty field not allowd");
            return false;
        }
        else if(s1>s2){
           txt4.setError("starting salary should not be greater than ending salary");
          txt5.setError("starting salary should not be greater than ending salary");
            return false;
        }
        else if(s1<0||s2<0){
            txt4.setError("values in minus are not allowed");
            txt5.setError("values in minus are not allowed");
            return false;
        }
        else{
            txt4.setError(null);
            txt4.setErrorEnabled(false);
            txt5.setError(null);
            txt5.setErrorEnabled(false);
            return true;

        }
    }
    public Boolean validateService(){
        String service=dropdown.getEditText().getText().toString();
        if(service.isEmpty()){
            dropdown.setError("Empty field not allowd");
            return false;
        }
        else{
            dropdown.setError(null);
            dropdown.setErrorEnabled(false);
            return true;
        }
    }
}
