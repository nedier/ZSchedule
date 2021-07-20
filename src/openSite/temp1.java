package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class temp1 extends JFrame{

    public static final int SCREEN_W = 640;
    public static final int SCREEN_H = 360;

    public static int date = LocalDate.now().getDayOfWeek().getValue();
    public static int now =  Integer.parseInt(LocalTime.now().getHour()
            + (LocalTime.now().getMinute() < 10 ? "0" + LocalTime.now().getMinute() : String.valueOf(LocalTime.now().getMinute())));
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new mkGUI();
    }
}
