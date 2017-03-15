package androidinterview.com.customlistviewimagetext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Livro01 extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_main);

        button = (Button) findViewById(R.id.button);
        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent dial = new Intent();
                dial.setAction("android.intent.action.DIAL");
                dial.setData(Uri.parse("tel:12988865095"));
                startActivity(dial);
            }
        });

        Button startBtn = (Button) findViewById(R.id.button2);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });

    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"theodamata@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Quero fazer parte da sua célula.");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Olá. Eu gostaria de participar da sua célula. Como eu posso proceder?\n" +
                "Muito Obrigado, att.");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Livro01.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }


        ActionBar ab = getSupportActionBar();
        if (ab != null) ;
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) ;
        {
            finish();
            return true;

        }
    }
}
