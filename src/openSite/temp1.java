package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class temp1 extends JFrame{

    public static final int SCREEN_W = 640;
    public static final int SCREEN_H = 360;

    public static int date = dateCalc.DayOfDate(
            Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())),
            Integer.parseInt(new SimpleDateFormat("MM").format(new Date())),
            Integer.parseInt(new SimpleDateFormat("dd").format(new Date()))
    );
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new mkGUI();

    }
}
