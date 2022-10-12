package com.pratitibaral.margaretbiography;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pratitibaral.margaretbiography.databinding.ActivityDonateBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DonateActivity extends AppCompatActivity {

    private ActivityDonateBinding binding;

    public static final String EXTRA_FULL_NAME = "com.pratitibaral.margaretbiography.EXTRA_FULL_NAME";
    public static final String EXTRA_PHONE_NUMBER = "com.pratitibaral.margaretbiography.EXTRA_PHONE_NUMBER";
    public static final String EXTRA_CREDIT_CARD_NUMBER = "com.pratitibaral.margaretbiography.EXTRA_CREDIT_CARD_NUMBER";
    public static final String EXTRA_CVC = "com.pratitibaral.margaretbiography.EXTRA_CVC";
    public static final String EXTRA_AMOUNT = "com.pratitibaral.margaretbiography.EXTRA_AMOUNT";
    public static final String EXTRA_RECEIVE_RECEIPT = "com.pratitibaral.margaretbiography.EXTRA_RECEIVE_RECEIPT";



    private View.OnClickListener button_donate_clickListener = new View.OnClickListener(){

        @Override
        public void onClick (View v)
        {
            Intent returnIntent = new Intent();
            String fullName = binding.editTextName.getText().toString ();
            String phone = binding.editTextPhone.getText().toString ();
            String credit_card = (binding.editTextCredit.getText().toString ());
            int cvc = Integer.valueOf(binding.editTextCvc.getText().toString ());
            float amount = Float.valueOf (binding.editTextAmount.getText().toString ());
            boolean receipt = binding.switch1.isChecked();

            Log.d("bio", String.valueOf(credit_card.indexOf("-")));
            Log.d("bio", String.valueOf(credit_card.indexOf("-", credit_card.indexOf("-"))));
            Log.d("bio", String.valueOf(credit_card.lastIndexOf("-")));


            if(!(credit_card.indexOf("-") == 4
                    && credit_card.indexOf("-", credit_card.indexOf("-")) == 4
                    && credit_card.lastIndexOf("-") == 14))
            {
               alertMethod();
            }

            else{

            returnIntent.putExtra(EXTRA_FULL_NAME, fullName);
            returnIntent.putExtra(EXTRA_PHONE_NUMBER, phone);
            returnIntent.putExtra(EXTRA_CREDIT_CARD_NUMBER, credit_card);
            returnIntent.putExtra(EXTRA_CVC, cvc);
            returnIntent.putExtra(EXTRA_AMOUNT, amount);
            returnIntent.putExtra(EXTRA_RECEIVE_RECEIPT, binding.switch1.isChecked());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();


        }

        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDonateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent myIntent = getIntent();

        binding.buttonDonate.setOnClickListener(button_donate_clickListener);



    }

public void alertMethod ()
        {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setTitle("Invalid Credit Card Number")
                    .setMessage("Please enter your 16 digit credit card number in this format 0000-0000-0000-0000 ")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();

        }
}
