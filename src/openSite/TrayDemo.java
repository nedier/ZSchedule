package openSite;

import javax.swing.*;
import java.awt.*;

public class TrayDemo {
    static SystemTray tray = SystemTray.getSystemTray();
    static Image image = Toolkit.getDefaultToolkit().createImage("");
    static TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");

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
        trayIcon.setPopupMenu(createPopupMenu());
        tray.add(trayIcon);
        trayIcon.displayMessage(txt, "알림", TrayIcon.MessageType.INFO);
        trayIcon.addActionListener(e -> {
            f.setVisible(false);
            if(onlyTray) {
                tray.remove(trayIcon);
            }
        });
    }
    protected static PopupMenu createPopupMenu() {
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("About");
        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
        Menu displayMenu = new Menu("Display");
        MenuItem errorItem = new MenuItem("Error");
        MenuItem warningItem = new MenuItem("Warning");
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
        // Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
        popup.add(cb2);
        popup.addSeparator();
        popup.add(displayMenu);
        displayMenu.add(errorItem);
        displayMenu.add(warningItem);
        displayMenu.add(infoItem);
        displayMenu.add(noneItem);
        popup.add(exitItem);
        return popup;
    }
}
