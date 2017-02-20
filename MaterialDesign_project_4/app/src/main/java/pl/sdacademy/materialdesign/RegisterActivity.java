package pl.sdacademy.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Akcja dla przycisku "Anuluj"
        // Metoda onBackPressed() odziedzicziona po AppCompatActivity -> FragmentActivity
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Ustawiamy OnClickListener dla przycisku "Załóż konto"
        // W itencie umieszczamy extra typu boolean w kluczu zdefiniowanym w polu
        // LoginActivity.KEY_ACCOUNT_CREATED
        findViewById(R.id.create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.KEY_ACCOUNT_CREATED, true);
                startActivity(intent);
            }
        });
    }
}
