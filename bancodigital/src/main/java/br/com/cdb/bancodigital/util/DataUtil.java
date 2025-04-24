package br.com.cdb.bancodigital.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatarData(LocalDate data) {
        return data.format(formatter);
    }

    public static LocalDate converterStringParaData(String data) {
        return LocalDate.parse(data, formatter);
    }
}

