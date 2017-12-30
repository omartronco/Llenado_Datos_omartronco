package mx.com.clupp.llenado_datos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText nombreIngresado;
    EditText fechaIngresada;
    EditText telefonoIngresado;
    EditText correoIngresado;

    public boolean verificadorFinal = false;
    String getEditText;

    public boolean verificadorDatos (){

        // Verifica que la entrada Nombre no esté vacía
        if (TextUtils.isEmpty(nombreIngresado.getText().toString())) {
            ClasePrueba.setVerificadorNombre(false);
            Toast.makeText(this, "Falta el nombre", Toast.LENGTH_SHORT).show();
        } else { ClasePrueba.setVerificadorNombre(true);}

        // Verifica que la fecha sea correcta
        if(ClasePrueba.isVerificadorFecha()) {}
        else {
            Toast.makeText(this, "Falta la fecha", Toast.LENGTH_SHORT).show();
        }

        // Verifica que el teléfono no esté vacío, que sean puros dígitos y que conste de 10 dígitos
        if (TextUtils.isEmpty(telefonoIngresado.getText().toString())) {
            ClasePrueba.setVerificadorTelefono(false);
            Toast.makeText(this, "Falta el teléfono", Toast.LENGTH_SHORT).show();
        } else {
            if(TextUtils.isDigitsOnly(telefonoIngresado.getText().toString())){
                if(telefonoIngresado.length()==10){
                    ClasePrueba.setVerificadorTelefono(true);
                } else {
                    Toast.makeText(this, "Teléfono debe ser de 10 dígitos", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(this, "Teléfono deben ser puros dígitos", Toast.LENGTH_SHORT).show();
            }
        }

        // Valida que el correo no esté vacío y que tenga un formato válido
        if (TextUtils.isEmpty(correoIngresado.getText().toString())){
            ClasePrueba.setVerificadorCorreo(false);
            Toast.makeText(this, "Falta el correo", Toast.LENGTH_SHORT).show();;
        } else {
           if (Patterns.EMAIL_ADDRESS.matcher(correoIngresado.getText().toString()).matches()) {
                ClasePrueba.setVerificadorCorreo(true);
            } else {
               Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show();
            }
        }

        if (ClasePrueba.isVerificadorNombre()){
            if (ClasePrueba.isVerificadorFecha()){
                if (ClasePrueba.isVerificadorTelefono()){
                    if (ClasePrueba.isVerificadorCorreo()){
                        verificadorFinal=true;
                    }
                }
            }
        }

        return verificadorFinal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle datosIncorrectos = getIntent().getExtras();
            EditText tvNombreACorregir      = (EditText) findViewById(R.id.tvNombre);
            EditText tvFechaACorregir       = (EditText) findViewById(R.id.tvFecha);
            EditText tvTelefonoACorregir    = (EditText) findViewById(R.id.tvTelefono);
            EditText tvCorreoACorregir      = (EditText) findViewById(R.id.tvCorreo);

            tvNombreACorregir.setText(datosIncorrectos.getString("nombre"));
            tvFechaACorregir.setText(datosIncorrectos.getString("fecha"));
            tvTelefonoACorregir.setText(datosIncorrectos.getString("telefono"));
            tvCorreoACorregir.setText(datosIncorrectos.getString("correo"));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        nombreIngresado     = (EditText) findViewById(R.id.tvNombre);
        fechaIngresada      = (EditText) findViewById(R.id.tvFecha);
        telefonoIngresado   = (EditText) findViewById(R.id.tvTelefono);
        correoIngresado     = (EditText) findViewById(R.id.tvCorreo);

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(nombreIngresado.getText()==null){
                    ClasePrueba.setVerificadorNombre(true);}else{ClasePrueba.setVerificadorNombre(false);}

                if (verificadorDatos()){
                    Intent intent = new Intent(MainActivity.this, Confirmacion_Datos.class);
                    intent.putExtra("nombre", nombreIngresado.getText().toString());
                    intent.putExtra("fecha", fechaIngresada.getText().toString());
                    intent.putExtra("telefono", telefonoIngresado.getText().toString());
                    intent.putExtra("correo", correoIngresado.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void showDatePicker(View v) {
        DialogFragment newFragment = new MyDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "date picker");
        fechaIngresada.setText(ClasePrueba.getFecha());
    }
}