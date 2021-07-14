package openSite;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser extends JPanel {
    JFileChooser fc = new JFileChooser("C:\\Temp\\ZSchedule\\files");
    FileChooser(String[] URLs, File saveConfig, String txt, String[] subjectNames, boolean AttAble, JFrame f) {
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML File .xml", "xml");
        fc.addChoosableFileFilter(filter);

        int returnVal = fc.showOpenDialog(FileChooser.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
        }
    }
}
