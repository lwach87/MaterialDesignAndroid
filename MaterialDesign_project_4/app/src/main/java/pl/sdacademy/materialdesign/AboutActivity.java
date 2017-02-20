package pl.sdacademy.materialdesign;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    private CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        layout = (CoordinatorLayout) findViewById(R.id.activity_about);

        // Poniżej ustawiamy Toolbar osadzony w pliku XML jako systemowy ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Kliknięcie przycisku FAB przenosi nas o ekranu "Rejestracja"
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutActivity.this, RegisterActivity.class));
            }
        });
    }

    /**
     * Wskazujemy zasób typu menu jako opcje w ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toolbar, menu);
        return true;
    }

    /**
     * Tutaj przechwytujemy kliknięcia w pozycje menu w ActionBar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_send_email:
                Snackbar.make(layout, "Wysyłamy e-maila", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_create_account:
                Snackbar.make(layout, "Tworzymy konto", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Snackbar.make(layout, "Otwieramy ustawienia", Snackbar.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}