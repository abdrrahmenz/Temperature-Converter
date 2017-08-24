package id.or.qodr.temperatureconverter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    Button btn_to_celcius, btn_to_fahrenheit;
    EditText edt_input_suhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");

        btn_to_celcius = (Button) findViewById(R.id.btn_celcius);
        btn_to_celcius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rumus Celcius
                double suhu = Integer.parseInt(edt_input_suhu.getText().toString());
                double rumus_celcius = (100.0 * suhu) / 100.0;
                final String hasil_celcius = rumus_celcius + "\u00b0C";

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("Hasil Convert !");
                dialog.setMessage(hasil_celcius);
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Hello klik To Celcius", Toast.LENGTH_SHORT).show();
                        // Pindah Halaman
                        Intent pindahActivity = new Intent(MainActivity.this, HasilActivity.class);
                        // Mengirim data hasil celcius
                        pindahActivity.putExtra("kirimdata",hasil_celcius);
                        // Mengeksekusi ke Halaman lain
                        startActivity(pindahActivity);
                    }
                });
                dialog.show();
            }
        });
        btn_to_fahrenheit = (Button) findViewById(R.id.btn_fahrenheit);

        edt_input_suhu = (EditText) findViewById(R.id.edt_input);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
