package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mkEditorTap {
    static JFrame frame= new JFrame();
    static boolean[] changeAble = new boolean[15];
    static JPanel panel = new JPanel(new GridBagLayout());
    static JButton OKButton = new JButton("OK");
    static JButton CancelButton = new JButton("Cancel");
    static GridBagConstraints construe = new GridBagConstraints();
    static String[] korSubjectNames = {"조종례", "국어", "수학", "영어", "과학B", "역사", "체육", "한문", "음악", "도덕", "가정", "기술", "창체", "과학 A", "스포츠"};
    static JLabel[] subjectLabels = new JLabel[15];
    static JTextField[] subjects = new JTextField[15];
    static JCheckBox[] toChangeAtt = new JCheckBox[15];
    static File file = new File("C:\\Temp\\ZSchedule\\files\\saveConfig.xml");

    public static void mkEditor(String[] URLs, File saveConfig, String txt, String[] subjectNames, boolean AttAble) throws ParserConfigurationException, IOException, SAXException {
        frame.setTitle("link edit");
        construe.insets = new Insets(5, 5, 5, 5);
        construe.anchor = GridBagConstraints.CENTER;
        construe.gridx=0;
        construe.gridy=0;
        for (int i = 0; i < subjects.length; i++) {
            changeAble[i] = Boolean.parseBoolean(XMLManage.XMLReader(file.getPath(), URLs, i));
            toChangeAtt[i] = new JCheckBox("", changeAble[i]);
            subjects[i] = new JTextField(20);
            subjects[i].setText(URLs[i]);
            subjectLabels[i] = new JLabel(korSubjectNames[i]);
            panel.add(subjectLabels[i], construe);
            construe.gridx=1;
            panel.add(subjects[i], construe);
            construe.gridx=2;
            panel.add(toChangeAtt[i], construe);
            construe.gridx=0; construe.gridy=i+1;
        }

        OKButton.addActionListener(e -> {
            for (int i = 0; i < subjects.length; i++) {
                changeAble[i] = toChangeAtt[i].isSelected();
                URLs[i] = subjects[i].getText();
            }
            try {
                XMLManage.XMLWriter(saveConfig, txt, subjectNames, URLs, AttAble, changeAble);
            } catch (ParserConfigurationException | TransformerException e1) {
                e1.printStackTrace();
            }
            mkGUI.restart();
        });
        CancelButton.addActionListener(e -> frame.dispose());
        construe.gridx=1;
        panel.add(OKButton, construe);
        construe.gridx=2;
        panel.add(CancelButton, construe);

        frame.add(panel);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
