package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private  EditText angkaInput;
	private  Button tebakButton, resetButton;
	int random;

	//  TODO: deklarasikan variabel di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initRandomNumber();
		angkaInput = findViewById(R.id.number_input);
		tebakButton = findViewById(R.id.guess_button);
	// TODO: bind layout di sini
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
	Random r = new Random();
	random = r.nextInt(  100) + 1;
	return;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int angka = Integer.parseInt(String.valueOf(angkaInput.getText()));
		if (angka > random){
			Toast.makeText( this,  "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
		}else if (angka < random){
			Toast.makeText(this, "Tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
		}else {
			tebakButton.setEnabled(false);
			Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		angkaInput.setText("");
		tebakButton.setEnabled(true);
	}
}
