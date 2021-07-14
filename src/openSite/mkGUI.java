package openSite;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.time.LocalTime;

public class mkGUI extends JFrame {

    static JFrame f = new JFrame("  ZSchedule ver 0.0.3");

    static ImageIcon nowClassBasic = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classes.png");
    static ImageIcon nowClassEnter = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classesEnter.png");
    static ImageIcon uploadPNG = new ImageIcon("C:\\Temp\\ZSchedule\\images\\upload.png");
    static ImageIcon uploadPNGEnter = new ImageIcon("C:\\Temp\\ZSchedule\\images\\uploadEnter.png");

    static File file = new File("C:\\Temp\\ZSchedule\\files\\clearDay.txt");
    static File saveConfig = new File("C:\\Temp\\ZSchedule\\files\\saveConfig.xml");
    static File autoLinkingFile = new File("C:\\Temp\\ZSchedule\\files\\autoLinkConfig.txt");

    static JLabel lb1 = new JLabel("", SwingConstants.CENTER);
    static JButton classes = new JButton(nowClassBasic);
    static JButton uploadButton = new JButton(uploadPNG);
    static JToolBar bar = new JToolBar();
    static JCheckBox autoLinking = new JCheckBox("자동 연결", Boolean.parseBoolean(fileRead(autoLinkingFile)));

    static String[] URLs = new String[15];
    static boolean[] changeAble = new boolean[URLs.length];


    static String[] subjectNames = {"MeetEnd", "Kor", "Math", "Eng", "SinceB", "History", "PE", "Chin", "Music", "Moral", "Home", "Techno", "CEA", "SinceA", "Sports"};
    String str;

    public mkGUI() throws ParserConfigurationException, IOException, SAXException {
        Thread thread = new Thread(new ThreadWithRunnable());
        for (int i = 0; i < URLs.length; i++) {
            changeAble[i] = Boolean.parseBoolean(XMLManage.XMLReader(saveConfig.getPath(), URLs, i));
            XMLManage.XMLReader(saveConfig.getPath(), URLs, i);
        }
        str = fileRead(file);
        if(!str.equals(Integer.toString(temp1.date))) {
            for (int i = 0; i < changeAble.length; i++) {
                manyIF.manyIFToday(changeAble[i], i, URLs);
            }
            BufferWriteTry(Integer.toString(temp1.date), file);
        }
        ButtonDefaultSet(140, 160, 350, 40, classes, "linking");
        ButtonDefaultSet(0, 0, 48, 48, uploadButton, "open file");
        lb1.setFont(new Font("", Font.PLAIN, 50));
        autoLinking.setBounds(540, 0, 100, 15);

        setFrameOptions(f);

        manyIF.nowClass(lb1);
        autoLinking.addItemListener(new ItemEvents());
        if(autoLinking.isSelected()) {
            lb1.setBounds(0, 130, 640, 50);
            classes.setVisible(false);
            try {
                new TrayDemo("자동연결이 활성화 되었습니다 (클릭하여 숨기기)", true, f);
            } catch (AWTException awtException) {
                awtException.printStackTrace();
            }
        } else {
            lb1.setBounds(0, 80, 640, 50);
            classes.setVisible(true);
        }
        thread.start();
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
        if(target == null) {
            JOptionPane.showMessageDialog(null, showMsg, "Notification", JOptionPane.ERROR_MESSAGE);
        }else {
            String index = JOptionPane.showInputDialog(showMsg);
            URLs[i] = index;
            if (index == null) {
                manyIF.desktopView("https://rang.edunet.net/main.do");
                mkJOptionPane(showMsg, target, i);
            } else {
                try {
                    XMLManage.XMLWriter(saveConfig, "saveConfig", subjectNames, URLs, true, changeAble);
                } catch (ParserConfigurationException | TransformerException e) {
                    e.printStackTrace();
                }
            }
        }
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
        f.getContentPane().add(autoLinking);
        f.getContentPane().add(lb1);
        f.getContentPane().add(classes);
        f.getContentPane().add(uploadButton);
        f.setSize(temp1.SCREEN_W, temp1.SCREEN_H);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(245, 245, 245, 255));
        f.setVisible(true);
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
            } else if(e.getSource() == uploadButton) {
                uploadButton.setIcon(uploadPNGEnter);
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == uploadButton) {
                uploadButton.setIcon(uploadPNG);
            }
            if (!autoLinking.isSelected() && e.getSource() == classes) {
                classes.setIcon(nowClassBasic);
            }
        }
        @Override
        public void mousePressed(MouseEvent e){
            if(e.getSource() == classes) {
                manyIF.manyIFNowClass(URLs);
                System.exit(0);
            } else if(e.getSource() == uploadButton) {
                try {
                    mkEditor.mkUI(URLs, saveConfig, "saveConfig", subjectNames, true, f);
                } catch (ParserConfigurationException | SAXException | IOException e1) {
                    e1.printStackTrace();
                }
                uploadButton.setIcon(uploadPNG);
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
                f.invalidate();
            }
        }
    }
    public static class ThreadWithRunnable implements Runnable {
        public void run() {
            while(autoLinking.isSelected()) {
                temp1.now = Integer.parseInt(Integer.toString(LocalTime.now().getHour()) + LocalTime.now().getMinute());
                manyIF.autoLinkingIF(URLs);
            }
            Thread.currentThread().interrupt();
        }
    }
}
