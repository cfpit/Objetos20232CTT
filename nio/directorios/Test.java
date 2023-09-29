package nio.directorios;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        try {
                Path Path = Paths.get("src/nio/directorios/curso");

                Path directorio = Files.createDirectory(Path);

                System.out.println("¡Se creó satisfactoriamente el directorio!");

                Path rutaArchivo = FileSystems.getDefault().getPath(
                        "src/nio/directorios/curso/miArchivo.txt");

                Path archivoDePrueba = Files.createFile(rutaArchivo);

                System.out.println("¡Se creó satisfactoriamente el archivo!");
            } 
        catch (IOException ex) 
            {
                    ex.printStackTrace();
            }

    }
}
