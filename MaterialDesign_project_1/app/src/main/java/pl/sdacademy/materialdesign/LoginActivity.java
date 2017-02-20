package pl.sdacademy.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_ACCOUNT_CREATED = "pl.sdacademy.materialdesign.LoginActivity.KEY_ACCOUNT_CREATED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final FrameLayout container = (FrameLayout) findViewById(R.id.activity_login);
        final TextInputLayout loginInputLayout = (TextInputLayout) findViewById(R.id.email_layout);
        final TextInputLayout passwordInputLayout = (TextInputLayout) findViewById(R.id.password_layout);
        final TextInputEditText emailInput = (TextInputEditText) findViewById(R.id.email_edit);
        final TextInputEditText passwordInput = (TextInputEditText) findViewById(R.id.password_edit);

        //TextWatcher nasłuchuje zmian i jeśli coś piszemy, to chowa komunikat o błędzie
        //Podajemy w nim najpierw EditText a potem odpowiadający mu text

        setTextWatcher(emailInput, loginInputLayout);
        setTextWatcher(passwordInput, passwordInputLayout);

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Jeśli w EditTextach są błędy, to je wyświetla

                if (TextUtils.isEmpty(emailInput.getText().toString())) {
                    loginInputLayout.setError(getString(R.string.empty_email_error));
                }

                if (TextUtils.isEmpty(passwordInput.getText().toString())) {
                    passwordInputLayout.setError(getString(R.string.empty_password_error));
                }
            }
        });

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        boolean accountCreated = getIntent().getBooleanExtra(KEY_ACCOUNT_CREATED, false);

        if (accountCreated) {
            Snackbar.make(container, R.string.account_created, Snackbar.LENGTH_LONG).show();
        }
    }

    private void setTextWatcher(final TextInputEditText editText, final TextInputLayout inputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (inputLayout.isErrorEnabled()) {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
