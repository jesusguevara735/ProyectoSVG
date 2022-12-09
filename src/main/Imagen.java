package main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Imagen {

    public String ObtenerCodigoImagen(String url) {
        String html = "";
        try {
            URL pagina = new URL(url);
            HttpURLConnection con = (HttpURLConnection) pagina.openConnection();
            con.connect();
            InputStreamReader in = new InputStreamReader((InputStream) con.getContent());
            BufferedReader buff = new BufferedReader(in);
            String linea = buff.readLine();
            while (linea != null) {
                html += linea + "\n";
                linea = buff.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }

    public void guardarImagen(String imagenUrl) {
        try {
            // Url con la imagen svg
            URL url = new URL(imagenUrl);

            URLConnection urlCon = url.openConnection();

            InputStream is = urlCon.getInputStream();
            // Nombre de la imagen con extension
            String nombreImagen[] = imagenUrl.split("/");

            FileOutputStream fos = new FileOutputStream(nombreImagen[nombreImagen.length - 1]);
            // Lectura de la foto de la web y escritura en fichero local
            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
            }
            // cierre de conexion y fichero.
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
