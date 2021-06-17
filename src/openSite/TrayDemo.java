package openSite;

import java.awt.*;
import java.io.IOException;

public class TrayDemo {
    TrayDemo() throws AWTException {
        if (SystemTray.isSupported()) {
            displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void displayTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage("Hello, World", "notification demo", TrayIcon.MessageType.INFO);
        trayIcon.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("C:\\Temp\\ZSchedule\\ZSchedule.exe");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
