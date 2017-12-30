package mx.com.clupp.llenado_datos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MyDatePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }

    DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    ClasePrueba.setVerificadorFecha(true);
                    ClasePrueba.setFecha(view.getDayOfMonth()+"/"+(view.getMonth()+1)+"/"+view.getYear());
                    Toast.makeText(getActivity(), "La fecha seleccionada es: "+ClasePrueba.getFecha(), Toast.LENGTH_LONG).show();
                }
            };




}
