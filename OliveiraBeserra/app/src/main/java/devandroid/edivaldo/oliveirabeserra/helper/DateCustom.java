package devandroid.edivaldo.oliveirabeserra.helper;

import java.text.SimpleDateFormat;

public class DateCustom {
    public  static  String dataAtual(){
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyyd");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }
}
