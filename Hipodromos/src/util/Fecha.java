package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

    public static Date fechaActual() {
        return Calendar.getInstance().getTime();
    }

    public static String formatearFecha(Date d, String formato) {
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(d);
    }

    public static String formatearFecha(Date d) {
        return formatearFecha(d, null);
    }

    public static Date stringAfecha(String fecha, String formato) {
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        SimpleDateFormat fSimple = new SimpleDateFormat(formato);
        fSimple.setLenient(false);

        Date retorno = null;
        try {
            retorno = fSimple.parse(fecha);
        } catch (ParseException e) {
        }
        return retorno;
    }

    public static Date stringAfecha(String fecha) {
        return stringAfecha(fecha, null);
    }

    public static Date crearFecha(int dia, int mes, int anio) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
}