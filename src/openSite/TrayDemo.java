package openSite;

import java.awt.*;
import java.io.IOException;

public class TrayDemo {
    TrayDemo(String txt, boolean action, boolean onlyTray) throws AWTException {
        if (SystemTray.isSupported()) {
            TrayIconMessage(txt, action, onlyTray);
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void TrayIconMessage(String txt, boolean action, boolean onlyTray) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("ZSchedule");
        tray.add(trayIcon);
        trayIcon.displayMessage(txt, "알림", TrayIcon.MessageType.INFO);
        if(action) {
            trayIcon.addActionListener(e -> {
                try {
                    Runtime.getRuntime().exec("C:\\Temp\\ZSchedule\\ZSchedule.exe");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        if(onlyTray) {
            tray.remove(trayIcon);
        }
    }
}
