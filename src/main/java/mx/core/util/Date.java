/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Date {

    public static java.sql.Date getSqlDate(){
         java.sql.Date sql = null;
        try {
            Calendar hoy = GregorianCalendar.getInstance();
            java.sql.Date date = new java.sql.Date(hoy.getTimeInMillis());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(date.toString());
            sql = new java.sql.Date(parsed.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sql;
    }
    public static java.sql.Date getSqlDate(String date,String mask){
        java.sql.Date sql = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(mask);
            java.util.Date parsed = format.parse(date);
            sql = new java.sql.Date(parsed.getTime());
            
        } catch (ParseException ex) {
            Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sql;
    }
    public static String getToDay(){
        Calendar hoy = GregorianCalendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(hoy.getTime());
    }
    public static String getDateTime(){
        Calendar hoy = GregorianCalendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        return format.format(hoy.getTime());
    }
    
    public static XMLGregorianCalendar parseXMLDate(String date) throws CoreException {       
        XMLGregorianCalendar dateFormat = null; 
        try {                        
            dateFormat = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
        } catch (DatatypeConfigurationException ex) {
            throw new CoreException("Fecha incorrecta");
        }
        return dateFormat;        
    }
    
    public static String Format(String mask,String fecha){
        Calendar cal = GregorianCalendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(mask);
        String []datos = {"2000","01","01"};
        int anio;
        int mes;
        int dia;
        if(fecha != null){
            if(fecha.contains("-")){
                datos = fecha.split("-");
            } else if(fecha.contains("/")){
                datos = fecha.split("/");
            }
            if(datos[0].length() == 4){
                anio = Integer.parseInt(datos[0]);
                mes = Integer.parseInt(datos[1])-1;
                dia = Integer.parseInt(datos[2]);
            }else{
                anio = Integer.parseInt(datos[2]);
                mes = Integer.parseInt(datos[1])-1;
                dia = Integer.parseInt(datos[0]);
                }
            cal.set(anio,mes,dia);
        }
        return format.format(cal.getTime());
    }
    public static String getMonth(int month){
        String monthtxt="";
        switch(month){
            case 1: monthtxt = "Enero"; break;
            case 2: monthtxt = "Febrero"; break;
            case 3: monthtxt = "Marzo"; break;
            case 4: monthtxt = "Abril"; break;
            case 5: monthtxt = "Mayo"; break;
            case 6: monthtxt = "Junio"; break;
            case 7: monthtxt = "Julio"; break;
            case 8: monthtxt = "Agosto"; break;
            case 9: monthtxt = "Septiembre"; break;
            case 10: monthtxt = "Octubre"; break;
            case 11: monthtxt = "Noviembre"; break;
            case 12: monthtxt = "Diciembre"; break;
        }
        return monthtxt;
    }
    public static String getYear(Integer num){
        String txt = "Dos mil dieciocho";
        switch(num){
            case 2019: txt = "Dos mil diecinueve"; break;
            case 2020: txt = "Dos mil veinte"; break;
            case 2021: txt = "Dos mil veintiuno"; break;
            case 2022: txt = "Dos mil veintidos"; break;
            case 2023: txt = "Dos mil veintitres"; break;
            case 2024: txt = "Dos mil veinticuatro"; break;
            case 2025: txt = "Dos mil veinticinco"; break;
            case 2026: txt = "Dos mil veintiseis"; break;
            case 2027: txt = "Dos mil veintisiete"; break;
            case 2028: txt = "Dos mil veintiocho"; break;
            case 2029: txt = "Dos mil veintinueve"; break;
            case 2030: txt = "Dos mil treinta"; break;
        }
        return txt;
    }
    
    public static XMLGregorianCalendar fechaXML(String fecha) {       
        XMLGregorianCalendar formatFecha = null; 
        try {                        
            formatFecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha);            
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo parser al calendario");
        }
        return formatFecha;        
    }
}
