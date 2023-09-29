package nio.notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FileText implements I_File {

    private File file;

    public FileText(File file) {
        this.file = file;
    }
    
    public FileText(String file){
        this.file=new File(file);
    }

    public File getFile() {
        return file;
    }
    
    @Override public void print() {
        int car;
        //Try with resources jdk 7 o superior
        //solo es valido para implementaciones de AutoCloseable
        try (FileReader in=new FileReader(file)){
           while((car=in.read())!=-1){
               System.out.print((char)car);
           }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println();
    }

    @Override public String getText() {
        StringBuilder sb=new StringBuilder();
        int car;
        try (FileReader in=new FileReader(file)) {
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    @Override public void setText(String text) {
        try (FileWriter out=new FileWriter(file)) {
            out.write(text);
        } catch (Exception e) { System.out.println(e); }
    }

    @Override public void appendText(String text) {
        try (FileWriter out=new FileWriter(file,true)) {
            out.write(text);
        } catch (Exception e) { System.out.println(e); }
    }

    @Override public void addLine(String line) {
        try (BufferedWriter out=new BufferedWriter(new FileWriter(file,true))){
            out.write(line);
            out.newLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override public List<String> getLines() {
        List<String> lineas=new ArrayList();
        try (BufferedReader in=new BufferedReader(new FileReader(file))){
            in.lines().forEach(lineas::add);
        } catch (Exception e) { System.out.println(e); }
        return lineas;
    }

    @Override public Set<String> getLinkedHashSetLines() {
        Set<String> lines=new LinkedHashSet();
        lines.addAll(getLines());
        return lines;
    }

    @Override public Set<String> getTreeSetLines() {
        Set<String> lines=new TreeSet();
        lines.addAll(getLines());
        return lines;
    }

    @Override public void addLines(List<String> lines) {
        try(BufferedWriter out=new BufferedWriter(new FileWriter(file,true))){
            for(String st:lines){
                out.write(st);
                out.newLine();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override public void removeLine(String line) {
        List<String>lista=getLines();
        lista.remove(line);
        setText("");
        addLines(lista);
    }
    
}
