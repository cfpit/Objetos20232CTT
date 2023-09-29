package nio.lector;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        
        Path ruta = Paths.get("src/nio/lector/usuarios.txt");
        
        Charset conjuntoCaracteres = Charset.forName("ISO-8859-1");
        
        try (BufferedReader lector = Files.newBufferedReader(ruta,
                conjuntoCaracteres)) {
            String linea = null;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
