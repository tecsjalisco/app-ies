
package mx.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    
    public static String getRoman(Integer num){
        List<String> array = new ArrayList();
        array.add("Primero");
        array.add("Segundo");
        array.add("Tercero");
        array.add("Cuarto");
        array.add("Quinto");
        array.add("Sexo");
        array.add("Septimo");
        array.add("Ocatvo");
        array.add("Noveno");
        array.add("Decimo");
        array.add("Onceavo");
        array.add("Doceavo");
        return array.get(num-1);
    }
    public static String getText(Integer num){
        List<String> array = new ArrayList();
        array.add("Uno");
        array.add("Dos");
        array.add("Tres");
        array.add("Cuatro");
        array.add("Cinco");
        array.add("Seis");
        array.add("Siete");
        array.add("Ocho");
        array.add("Nueve");
        array.add("Diez");
        array.add("Once");
        array.add("Doce");
        array.add("Trece");
        array.add("Catorce");
        array.add("Quince");
        array.add("Dieciseis");
        array.add("Diecisiete");
        array.add("Diesciocho");
        array.add("Diescinueve");
        array.add("Veinte");
        array.add("Veintiuno");
        array.add("Veintidos");
        array.add("Veintitres");
        array.add("Veinticuatro");
        array.add("Veinticinco");
        array.add("Veintisesis");
        array.add("Veintisiete");
        array.add("Veintiocho");
        array.add("Veintinueve");
        array.add("Treinta");
        array.add("Treintaiuno");
        array.add("Treintaidos");
        array.add("Treintaitres");
        array.add("Treintaicuatro");
        array.add("Treintaicinco");
        array.add("Treintaiseis");
        array.add("Treintaisiete");
        array.add("Treintaiocho");
        array.add("Treintainueve");
        array.add("Cuarenta");
        array.add("Cuarentaiuno");
        array.add("Cuarentaidos");
        array.add("Cuarentaitres");
        array.add("Cuarentaicuatro");
        array.add("Cuarentaicinco");
        array.add("Cuarentaiseis");
        array.add("Cuarentaisiete");
        array.add("Cuarentaiocho");
        array.add("Cuarentainueve");
        array.add("Cincuenta");
        array.add("Cincuentaiuno");
        array.add("Cincuentaidos");
        return array.get(num-1);
    }
    
    public static boolean alfanumericos(String cad)
    {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(cad);
        return matcher.matches();
    }
}
