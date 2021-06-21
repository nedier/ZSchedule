package openSite;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class mkGUI extends JFrame {

    static JFrame f = new JFrame("  ZSchedule ver 0.0.1");

    static ImageIcon nowClassBasic = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classes.png");
    static ImageIcon nowClassEnter = new ImageIcon("C:\\Temp\\ZSchedule\\images\\classesEnter.png");
    static ImageIcon uploadPNG = new ImageIcon("C:\\Temp\\ZSchedule\\images\\upload.png");
    static ImageIcon uploadPNGEnter = new ImageIcon("C:\\Temp\\ZSchedule\\images\\uploadEnter.png");

    static JLabel lb1 = new JLabel("", SwingConstants.CENTER);
    static JButton classes = new JButton(nowClassBasic);
    static JButton uploadButton = new JButton(uploadPNG);
    static JToolBar bar = new JToolBar();

    static String[] URLs = new String[15];
    static boolean[] changeAble = new boolean[URLs.length];

    static File file = new File("C:\\Temp\\ZSchedule\\files\\clearDay.txt");
    static File saveConfig = new File("C:\\Temp\\ZSchedule\\files\\saveConfig.xml");

    static String[] subjectNames = {"MeetEnd", "Kor", "Math", "Eng", "SinceB", "History", "PE", "Chin", "Music", "Moral", "Home", "Techno", "CEA", "SinceA", "Sports"};
    String str;

    public mkGUI() throws ParserConfigurationException, IOException, SAXException {
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

        lb1.setBounds(0, 80, 640, 50);
        lb1.setFont(new Font("", Font.PLAIN, 50));
        manyIF.nowClass(lb1);
        f.getContentPane().add(lb1);
        f.getContentPane().add(classes);
        f.getContentPane().add(uploadButton);

        f.setSize(temp1.SCREEN_W, temp1.SCREEN_H);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(245, 245, 245, 255));
        f.setVisible(true);
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
            if(e.getSource() == classes) {
                classes.setIcon(nowClassBasic);
            } else if(e.getSource() == uploadButton) {
                uploadButton.setIcon(uploadPNG);
            }
        }
        @Override
        public void mousePressed(MouseEvent e){
            if(e.getSource() == classes) {
                manyIF.manyIFNowClass(URLs);
                System.exit(0);
            } else if(e.getSource() == uploadButton) {
                try {
                    new FileChooser(URLs, changeAble);
                    XMLManage.XMLWriter(saveConfig, "saveConfig", subjectNames, URLs, true, changeAble);
                } catch (ParserConfigurationException | SAXException | IOException | TransformerException e1) {
                    e1.printStackTrace();
                }
                uploadButton.setIcon(uploadPNG);
                f.dispose();
                try {
                    new mkGUI();
                } catch (ParserConfigurationException | IOException | SAXException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}