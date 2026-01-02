package com.ikernell.config;

import com.ikernell.model.Rol;
import com.ikernell.repository.RolRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Order(1)
public class DataInitializer implements CommandLineRunner {

    private final RolRepositorio rolRepositorio;

    public DataInitializer(RolRepositorio rolRepositorio) {
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    public void run(String... args) {
        try {
            List<Rol> roles = List.of(
                new Rol(1, "Lider"),
                new Rol(2, "Coordinador"),
                new Rol(3, "Desarrollador")
            );

            for (Rol rol : roles) {
                if (!rolRepositorio.existsById(rol.getId())) {
                    rolRepositorio.save(rol);
                }
            }

            System.out.println("Roles verificados e insertados si no existían.");
        } catch (Exception e) {
            System.err.println("Error inicializando roles: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
