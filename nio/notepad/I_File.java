package nio.notepad;
import java.util.List;
import java.util.Set;
public interface I_File {
    void print();
    String getText();
    void setText(String text);
    void appendText(String text);
    void addLine(String line);
    List<String>getLines();
    Set<String>getLinkedHashSetLines();
    Set<String>getTreeSetLines();
    void addLines(List<String>lines);
    void removeLine(String line);
}