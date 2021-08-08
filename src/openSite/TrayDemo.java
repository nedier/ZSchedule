package openSite;

import javax.swing.*;
import java.awt.*;

public class TrayDemo {

    static SystemTray tray = SystemTray.getSystemTray();
    static Image image = Toolkit.getDefaultToolkit().getImage("C:\\Temp\\ZSchedule\\images\\zoom.ico");
    static TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");

    static void TrayDemoDefault() throws AWTException {
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("ZSchedule");
        trayIcon.setPopupMenu(mkGUI.createPopupMenu());
        tray.add(trayIcon);
    }

    TrayDemo(String txt, boolean onlyTray, JFrame f) throws AWTException {
        if (SystemTray.isSupported()) {
            TrayIconMessage(txt, onlyTray, f);
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void TrayIconMessage(String txt, boolean onlyTray, JFrame f) throws AWTException {
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("ZSchedule");
        trayIcon.setPopupMenu(mkGUI.createPopupMenu());
        tray.add(trayIcon);
        trayIcon.displayMessage(txt, "알림", TrayIcon.MessageType.INFO);
        trayIcon.addActionListener(e -> {
            f.setVisible(false);
            if(onlyTray) {
                tray.remove(trayIcon);
            }
        });
    }
}
