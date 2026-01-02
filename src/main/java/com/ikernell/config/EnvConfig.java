package com.ikernell.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

/**
 * Carga las variables de entorno del archivo .env
 * Se ejecuta automáticamente al iniciar la aplicación
 */
@Configuration
public class EnvConfig {

    public EnvConfig() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // Cargar variables del .env en las propiedades del sistema
        dotenv.entries().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            if (System.getProperty(key) == null) {
                System.setProperty(key, value);
            }
        });
    }
}

