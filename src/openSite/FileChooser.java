package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.IOException;

public class FileChooser extends JPanel {
    JFileChooser fc = new JFileChooser("C:\\Temp\\ZSchedule\\files");
    FileChooser(String[] URLs, File saveConfig, String txt, String[] subjectNames, boolean AttAble) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML File .xml", "xml");
        fc.addChoosableFileFilter(filter);

        int returnVal = fc.showOpenDialog(FileChooser.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            mkEditor.mkUI(URLs, file, saveConfig, txt, subjectNames, AttAble);
        }
    }
}
