package openSite;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class mkGUI extends JFrame {

    static JFrame f = new JFrame("  ZSchedule ver 0.0.3");

    static ImageIcon nowClassBasic = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classes.png");
    static ImageIcon nowClassEnter = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classesEnter.png");

    static File file = new File("C:\\Temp\\ZSchedule\\files\\clearDay.txt");
    static File saveConfig = new File("C:\\Temp\\ZSchedule\\files\\saveConfig.xml");
    static File autoLinkingFile = new File("C:\\Temp\\ZSchedule\\files\\autoLinkConfig.txt");
    static File shortSchoolFile = new File("C:\\Temp\\ZSchedule\\files\\shortSchool.xml");
    static File ringingFile = new File("C:\\Temp\\ZSchedule\\files\\ringing.wav");

    static JLabel lb1 = new JLabel("", SwingConstants.CENTER);
    static JButton classes = new JButton(nowClassBasic);
    static JToolBar bar = new JToolBar();
    static JCheckBox autoLinking = new JCheckBox("자동 연결", Boolean.parseBoolean(fileRead(autoLinkingFile)));
    static JMenuBar mb = new JMenuBar();
    static JMenu menu = new JMenu("Edit");
    static JMenu shortDay = new JMenu("단축수업");
    static JMenuItem edit = new JMenuItem("링크");
    static JMenuItem shortDayBreakTime = new JMenuItem("쉬는시간");
    static JMenuItem shortDayStudyTime = new JMenuItem("수업시간");

    static String[] URLs = new String[15];
    static boolean[] changeAble = new boolean[URLs.length];
    static String[] subjectNames = {"MeetEnd", "Kor", "Math", "Eng", "SinceB", "History", "PE", "Chin", "Music", "Moral", "Home", "Techno", "CEA", "SinceA", "Sports"};

    static String[] times = new String[2]; // break,study

    static MenuItem openItem = new MenuItem("Open");
    static MenuItem hideItem = new MenuItem("Hide");
    static MenuItem exitItem = new MenuItem("Exit");

    final static PopupMenu popup = new PopupMenu();
    static Thread thread = new Thread(new ThreadWithRunnable());

    public mkGUI() throws ParserConfigurationException, IOException, SAXException, AWTException {
        for (int i = 0; i < times.length; i++) {
            XMLManage.XMLReader(shortSchoolFile.getPath(), times, i);
            System.out.println(times[i]);
        }
        for (int i = 0; i < URLs.length; i++) {
            changeAble[i] = Boolean.parseBoolean(XMLManage.XMLReader(saveConfig.getPath(), URLs, i));
            XMLManage.XMLReader(saveConfig.getPath(), URLs, i);
        }
        if(!fileRead(file).equals(Integer.toString(temp1.date))) {
            for (int i = 0; i < changeAble.length; i++) {
                manyIF.manyIFToday(changeAble[i], i, URLs);
            }
            BufferWriteTry(Integer.toString(temp1.date), file);
        }
        setFrameOptions(f);
        manyIF.nowClass(lb1);
        autoLinking.addItemListener(new ItemEvents());
        if(autoLinking.isSelected()) {
            lb1.setBounds(0, 130, 640, 50);
            classes.setVisible(false);
            TrayDemo.TrayDemoDefault();
            // new TrayDemo("자동연결이 활성화 되었습니다 (클릭하여 숨기기)", false, f);
        } else {
            lb1.setBounds(0, 80, 640, 50);
            classes.setVisible(true);
        }
        if(autoLinking.isSelected()) {
            thread.start();
        }
    }

    public static void BufferWriteTry(String index, File target) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target));
            if(target.isFile() && target.canWrite()){
                try {
                    bufferedWriter.write(index);
                } catch (NullPointerException e) {
                    System.exit(0);
                }
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkJOptionPane(String showMsg, String[] target, int i) {
        String index = JOptionPane.showInputDialog(showMsg);
        if (index == null) {
            manyIF.desktopView("https://rang.edunet.net/main.do");
            mkJOptionPane(showMsg, target, i);
        } else {
            if(index.contains(" ")) {
                index = index.replace(" ", "");
            }
            target[i] = index;
            try {
                XMLManage.XMLWriter(saveConfig, "saveConfig", subjectNames, URLs, true, changeAble);
            } catch (ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }
        }
    }
    public static void mkJOptionPane(String showMsg, String title) {
        JOptionPane.showMessageDialog(null, showMsg, title, JOptionPane.ERROR_MESSAGE);
    }
    public static int mkJOptionPane(String showMsg) {
        String result = JOptionPane.showInputDialog(showMsg);
        if(result == null) {
            mkJOptionPane(showMsg);
        } else {
            if (result.matches("-?\\d+")) {
                return Integer.parseInt(result);
            } else {
                mkJOptionPane("숫자를 입력해 주세요", "Notification");
                mkJOptionPane(showMsg);
            }
        }
        return 0;
    }
    public static void ButtonDefaultSet(int x, int y, int width, int height, JButton btn, String toolTipText) {
        btn.setBounds(x, y ,width, height);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setToolTipText(toolTipText);
        btn.addMouseListener(new MouseEvents());
        bar.add(btn);
    }
    public static String fileRead(File path) {
        String str = "";
        try{
            FileReader filereader = new FileReader(path);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line;
            while((line = bufReader.readLine()) != null){
                str = line;
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void setFrameOptions(JFrame f) {
        shortDay.setMargin(new Insets(2, -25, 2, 2));
        edit.setMargin(new Insets(2, -25, 2, 2));
        shortDayBreakTime.setMargin(new Insets(2, -25, 2, 2));
        shortDayStudyTime.setMargin(new Insets(2, -25, 2, 2));
        shortDay.add(shortDayBreakTime);
        shortDay.add(shortDayStudyTime);
        menu.add(edit);
        menu.add(shortDay);
        mb.add(menu);
        edit.addMouseListener(new MouseEvents());
        shortDayBreakTime.addMouseListener(new MouseEvents());
        shortDayStudyTime.addMouseListener(new MouseEvents());
        ButtonDefaultSet(140, 160, 350, 40, classes, "linking");
        lb1.setFont(new Font("", Font.PLAIN, 50));
        autoLinking.setBounds(540, 0, 100, 15);
        f.getContentPane().add(autoLinking);
        f.getContentPane().add(lb1);
        f.getContentPane().add(classes);
        f.setSize(temp1.SCREEN_W, temp1.SCREEN_H);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(245, 245, 245, 255));
        f.setJMenuBar(mb);
        f.setVisible(true);
    }
    public static void shortSchoolXmlWrite() {
        try {
            XMLManage.XMLWriter(shortSchoolFile,
                    "shortSchool",
                    new String[]{"breakTime", "studyTime"},
                    times,
                    false, null);
        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
    }
    public static class MouseEvents implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == classes) {
                classes.setIcon(nowClassEnter);
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if (!autoLinking.isSelected() && e.getSource() == classes) {
                classes.setIcon(nowClassBasic);
            }
        }
        @Override
        public void mousePressed(MouseEvent e){
            if(e.getSource() == classes) {
                manyIF.manyIFNowClass(URLs);
                System.exit(0);
            } else if(e.getSource() == edit) {
            try {
                mkEditor.mkUI(URLs, saveConfig, "saveConfig", subjectNames, true, f);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                e1.printStackTrace();
            }
            } else if(e.getSource() == shortDayBreakTime) {
                times[0] = String.valueOf(mkJOptionPane("쉬는시간이 몇 분인지 입력해 주세요"));
                shortSchoolXmlWrite();
                try {
                    Runtime.getRuntime().exec("C:\\Temp\\ZSchedule\\ZSchedule.exe");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            } else if(e.getSource() == shortDayStudyTime) {
                times[1] = String.valueOf(mkJOptionPane("수업시간이 몇 분인지 입력해 주세요"));
                shortSchoolXmlWrite();
                try {
                    Runtime.getRuntime().exec("C:\\Temp\\ZSchedule\\ZSchedule.exe");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        }
    }
    public static class ItemEvents implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == autoLinking) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    BufferWriteTry("true", autoLinkingFile);
                } else {
                    BufferWriteTry("false", autoLinkingFile);
                }
                try {
                    Runtime.getRuntime().exec("C:\\Temp\\ZSchedule\\ZSchedule.exe");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                TrayDemo.tray.remove(TrayDemo.trayIcon);
                System.exit(0);
            }
        }
    }
    public static class ThreadWithRunnable implements Runnable {
        @Override
        public void run() {
            while (true){
                if(manyIF.autoLinkingIF(URLs)) {
                    break;
                }
            }
            new Sound(ringingFile);
            Thread.currentThread().interrupt();
        }
    }
    protected static PopupMenu createPopupMenu() {
        openItem.addActionListener(new ActionListeners());
        hideItem.addActionListener(new ActionListeners());
        exitItem.addActionListener(new ActionListeners());

        popup.add(openItem);
        popup.add(hideItem);
        popup.addSeparator();
        popup.add(exitItem);
        return popup;
    }
    public static class ActionListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == openItem) {
                f.setVisible(true);
            }
            if(e.getSource() == hideItem) {
                f.setVisible(false);
            }
            if(e.getSource() == exitItem) {
                System.exit(0);
            }
        }
    }
}
