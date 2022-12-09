package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Leer entrada de datos
        Scanner leer = new Scanner(System.in);

        System.out.print("Escriba la URL de la imagen: ");
        // Almacenar la URL en la variable
        String url = leer.nextLine();
        // Llamamos al metodo guardar imagen y le pasamos la url
        new Imagen().guardarImagen(url);

        Ventana v = new Ventana(new Imagen().ObtenerCodigoImagen(url));
        v.setVisible(true);
    }

}
