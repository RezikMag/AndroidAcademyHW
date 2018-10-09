package com.rezikmag.androidacademyhw2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class BuisnessCardActivity extends AppCompatActivity {

    EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buisness_card);

        message = findViewById(R.id.edit_text_message);
        Button send = findViewById(R.id.btn_send_message);
        final ImageButton vk = findViewById(R.id.btn_vk);
        ImageButton fb = findViewById(R.id.btn_fb);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(getString(R.string.subject));
            }
        });

        vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkOpen(getString(R.string.vk_url));
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkOpen(getString(R.string.fb_url));
            }
        });
    }

    private void linkOpen(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }


    private void sendMail(String subject) {

        String messageText = message.getText().toString();
        if (messageText.isEmpty()){
            Toast.makeText(this,getString(R.string.enter_a_message), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{getString(R.string.adress)});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
            startActivity(intent);

    }
}
