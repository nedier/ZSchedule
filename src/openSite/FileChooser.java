package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.IOException;

public class FileChooser extends JPanel {
    JFileChooser fc = new JFileChooser();
    FileChooser(String[] URLs, boolean[] changeAble) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML File .xml", "xml");
        fc.addChoosableFileFilter(filter);

        int returnVal = fc.showOpenDialog(FileChooser.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            for (int i = 0; i < URLs.length; i++) {
                changeAble[i] = Boolean.parseBoolean(XMLManage.XMLReader(file.getPath(), URLs, i));
            }
        }
    }
}
