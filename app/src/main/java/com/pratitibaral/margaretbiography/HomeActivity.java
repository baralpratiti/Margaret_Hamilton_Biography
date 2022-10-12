package com.pratitibaral.margaretbiography;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.pratitibaral.margaretbiography.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    public static final int FROM_DONATE_ACTIVITY = 1;
    private ActivityHomeBinding binding;


    private View.OnClickListener textView_location_ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent theIntent = new Intent();
            theIntent.setAction(Intent.ACTION_VIEW);
            theIntent.setData(Uri.parse("geo:0,0?q=paoli+in"));
            if (theIntent.resolveActivity(getPackageManager()) != null) {

                startActivity(theIntent);
            }
        }

    };

    private View.OnClickListener textView_location_text_ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent theIntent = new Intent();
            theIntent.setAction(Intent.ACTION_VIEW);
            theIntent.setData(Uri.parse("geo:0,0?q=usa"));
            if (theIntent.resolveActivity(getPackageManager()) != null) {

                startActivity(theIntent);
            }
        }

    };




    private View.OnClickListener button_info_ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent theIntent = new Intent();
            theIntent.setAction(Intent.ACTION_VIEW);
            theIntent.setData(Uri.parse("https://en.wikipedia.org/wiki/Margaret_Hamilton_(software_engineer)"));
            if (theIntent.resolveActivity(getPackageManager()) != null) {

                startActivity(theIntent);
            }

        }
    };

    private View.OnClickListener button_biography_ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent theIntent = new Intent(HomeActivity.this, BiographyActivity.class);
            startActivity(theIntent);

        }
    };


    private View.OnClickListener button_donate_ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent theIntent = new Intent(HomeActivity.this, DonateActivity.class);
            startActivityForResult(theIntent, FROM_DONATE_ACTIVITY);


        }
    };


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FROM_DONATE_ACTIVITY && resultCode == Activity.RESULT_OK) {

            boolean receipt = data.getBooleanExtra(DonateActivity.EXTRA_RECEIVE_RECEIPT, false);
            if (receipt) {
                String fullName = data.getStringExtra(DonateActivity.EXTRA_FULL_NAME);
                String phone = data.getStringExtra(DonateActivity.EXTRA_PHONE_NUMBER);
                String creditCard = data.getStringExtra(DonateActivity.EXTRA_CREDIT_CARD_NUMBER);
                int cvc = data.getIntExtra(DonateActivity.EXTRA_CVC, 0);
                float amount = data.getFloatExtra(DonateActivity.EXTRA_AMOUNT, 0f);


                Intent msgIntent = new Intent();
                msgIntent.setAction(Intent.ACTION_SENDTO);
                msgIntent.setData(Uri.parse("sms:" + phone));
                msgIntent.putExtra("sms_body", "Thank you " + fullName + " for" +
                        " your donation of $ " + String.valueOf(amount) + " using card number" +
                        " ending in " + creditCard.substring(15, 19));

                if (msgIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(msgIntent);
                }

            }

        }}
        ;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            binding = ActivityHomeBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            binding.buttonInfo.setOnClickListener(button_info_ClickListener);
            binding.buttonBiography.setOnClickListener(button_biography_ClickListener);
            binding.buttonDonate.setOnClickListener(button_donate_ClickListener);
            binding.textViewLocation.setOnClickListener(textView_location_ClickListener);
            binding.textViewLocationText.setOnClickListener(textView_location_text_ClickListener);

        }


    }








