package br.com.emmanuelneri.interfaces;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface Constantes {

    String WS_EMAIL = "ws@gmail.com";
    String WS_SENHA = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

    String DATE_PATTERN_DEFAULT = "dd/MM/yyyy";
    DateTimeFormatter DATE_TIME_FORMAT_DEFAULT = DateTimeFormatter.ofPattern(DATE_PATTERN_DEFAULT);

    Locale PT_BR = new Locale("pt", "BR");
}
