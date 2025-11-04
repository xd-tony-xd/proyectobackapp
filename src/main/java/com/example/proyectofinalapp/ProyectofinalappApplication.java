package com.example.proyectofinalapp;

import com.example.proyectofinalapp.entity.*;
import com.example.proyectofinalapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class ProyectofinalappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectofinalappApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            UsuarioRepository usuarioRepo,
            ProductoRepository productoRepo,
            CategoriaRepository categoriaRepo,
            MensajeRepository mensajeRepo,
            FavoritoRepository favoritoRepo,
            CalificacionRepository calificacionRepo,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            // =====================
            // Crear Usuarios
            // =====================
            Usuario u1 = new Usuario();
            u1.setNombre("Juan");
            u1.setApellido("Perez");
            u1.setEmail("juan@example.com");
            u1.setPassword(passwordEncoder.encode("123456"));
            u1.setTelefono("999111222");
            u1.setDni("12345678");
            u1.setDireccion("Av. Siempre Viva 123");
            u1.setCiudad("Lima");
            u1.setFechaNacimiento(Date.from(LocalDate.of(1990,1,1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            u1.setFotoPerfil("https://example.com/foto1.jpg");
            u1.setReputacion(4.8);
            u1.setFechaRegistro(new Date());
            usuarioRepo.save(u1);

            Usuario u2 = new Usuario();
            u2.setNombre("Maria");
            u2.setApellido("Lopez");
            u2.setEmail("maria@example.com");
            u2.setPassword(passwordEncoder.encode("123456"));
            u2.setTelefono("988777666");
            u2.setDni("87654321");
            u2.setDireccion("Calle Falsa 456");
            u2.setCiudad("Lima");
            u2.setFechaNacimiento(Date.from(LocalDate.of(1995,5,15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            u2.setFotoPerfil("https://example.com/foto2.jpg");
            u2.setReputacion(5.0);
            u2.setFechaRegistro(new Date());
            usuarioRepo.save(u2);

            // =====================
            // Crear Categorías
            // =====================
            Categoria c1 = new Categoria();
            c1.setNombre("Electrónica");
            c1.setDescripcion("Dispositivos electrónicos");
            categoriaRepo.save(c1);

            Categoria c2 = new Categoria();
            c2.setNombre("Ropa");
            c2.setDescripcion("Prendas de vestir");
            categoriaRepo.save(c2);

            // =====================
            // Crear Productos
            // =====================
            Producto p1 = new Producto();
            p1.setUsuario(u1);
            p1.setCategoria(c1);
            p1.setTitulo("Smartphone Xiaomi");
            p1.setDescripcion("Xiaomi Redmi Note 12");
            p1.setPrecio(1200.0);
            p1.setStock(5);
            p1.setImagenUrl("https://example.com/smartphone.jpg");
            p1.setLatitud(-12.0464);
            p1.setLongitud(-77.0428);
            p1.setDireccion("Lima, Perú");
            p1.setEstado(Producto.EstadoProducto.DISPONIBLE);
            p1.setFechaPublicacion(new Date());
            productoRepo.save(p1);

            Producto p2 = new Producto();
            p2.setUsuario(u2);
            p2.setCategoria(c2);
            p2.setTitulo("Camisa");
            p2.setDescripcion("Camisa de algodón");
            p2.setPrecio(50.0);
            p2.setStock(10);
            p2.setImagenUrl("https://example.com/camisa.jpg");
            p2.setLatitud(-12.0464);
            p2.setLongitud(-77.0428);
            p2.setDireccion("Lima, Perú");
            p2.setEstado(Producto.EstadoProducto.DISPONIBLE);
            p2.setFechaPublicacion(new Date());
            productoRepo.save(p2);

            // =====================
            // Crear Mensajes
            // =====================
            Mensaje m1 = new Mensaje();
            m1.setRemitente(u1);
            m1.setReceptor(u2);
            m1.setContenido("Hola Maria, estoy interesado en tu camisa.");
            m1.setFechaEnvio(new Date());
            m1.setLeido(false);
            mensajeRepo.save(m1);

            // =====================
            // Crear Favoritos
            // =====================
            Favorito f1 = new Favorito();
            f1.setUsuario(u2);
            f1.setProducto(p1);
            f1.setFechaAgregado(new Date());
            favoritoRepo.save(f1);

            // =====================
            // Crear Calificaciones
            // =====================
            Calificacion cal1 = new Calificacion();
            cal1.setCalificador(u2);
            cal1.setCalificado(u1);
            cal1.setProducto(p1);
            cal1.setPuntuacion(4.5);
            cal1.setComentario("Buen vendedor y producto conforme.");
            cal1.setFecha(new Date());
            calificacionRepo.save(cal1);

            System.out.println("Datos iniciales creados correctamente.");
        };
    }
}
