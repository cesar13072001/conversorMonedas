package org.caz.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObtenerHora {

    public String ObtenerFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ahora.format(formato);
    }
}
