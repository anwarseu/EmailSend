package com.tricktech.emailsend;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText edtTo,edtSuject,edtBody;
    public Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTo = (EditText) findViewById(R.id.edtTO);
        edtSuject = (EditText) findViewById(R.id.edtSuject);
        edtBody = (EditText) findViewById(R.id.edtBody);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSend){
            String TO = edtTo.getText().toString();
            String subject = edtSuject.getText().toString();
            String message = edtBody.getText().toString();


            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("text/plain");

            intent.putExtra(Intent.EXTRA_EMAIL, TO);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            try {
                startActivity(Intent.createChooser(intent,"Send mail..."));
            }catch (Exception e){
                Toast.makeText(this, "There is no email client installed!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
