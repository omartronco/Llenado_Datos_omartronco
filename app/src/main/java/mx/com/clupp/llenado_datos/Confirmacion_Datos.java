package mx.com.clupp.llenado_datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;

public class Confirmacion_Datos extends AppCompatActivity {

    private TextView tvNombreIngresado;
    private TextView tvFechaIngresada;
    private TextView tvTelefonoIngresado;
    private TextView tvCorreoIngresado;

    public void llenarDatos(String nombre){
        this.parametros[0] = nombre;
    }

    public String[] getParametros() {
        return parametros;
    }

    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }

    private String[] parametros = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion__datos);

        Bundle datos = getIntent().getExtras();
        parametros[0]   = datos.getString("nombre");
        parametros[1]   = datos.getString("fecha");
        parametros[2]   = datos.getString("telefono");
        parametros[3]   = datos.getString("correo");

        tvNombreIngresado   = (TextView) findViewById(R.id.tvNombreFinal);
        tvFechaIngresada    = (TextView) findViewById(R.id.tvFechaFinal);
        tvTelefonoIngresado = (TextView) findViewById(R.id.tvTelefonoFinal);
        tvCorreoIngresado   = (TextView) findViewById(R.id.tvCorreoFinal);

        tvNombreIngresado.setText(parametros[0]);
        tvFechaIngresada.setText(parametros[1]);
        tvTelefonoIngresado.setText(parametros[2]);
        tvCorreoIngresado.setText(parametros[3]);

        Button miBoton = (Button) findViewById(R.id.btnEditarDatos);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Confirmacion_Datos.this,
                        MainActivity.class);
                intent.putExtra("nombre", parametros[0]);
                intent.putExtra("fecha", parametros[1]);
                intent.putExtra("telefono", parametros[2]);
                intent.putExtra("correo", parametros[3]);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Confirmacion_Datos.this, MainActivity.class);
            intent.putExtra("nombre", parametros[0]);
            intent.putExtra("fecha", parametros[1]);
            intent.putExtra("telefono", parametros[2]);
            intent.putExtra("correo", parametros[3]);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}