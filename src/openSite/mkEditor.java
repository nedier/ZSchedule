package openSite;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mkEditor {
    public static void mkUI(String[] URLs, File file, File saveConfig, String txt, String[] subjectNames, boolean AttAble) throws ParserConfigurationException, IOException, SAXException {
        JFrame frame= new JFrame();
        JPanel mainPanel = new JPanel();
        boolean[] changeAble = new boolean[15];
        JPanel headingPanel = new JPanel();
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        String[] korSubjectNames = {"조종례", "국어", "수학", "영어", "과학B", "역사", "체육", "한문", "음악", "도덕", "가정", "기술", "창체", "과학 A", "스포츠"};
        JLabel[] subjectLabels = new JLabel[15];
        JTextField[] subjects = new JTextField[15];
        JCheckBox[] toChangeAtt = new JCheckBox[15];

        frame.setTitle("file editor");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;
        constr.gridx=0;
        constr.gridy=0;
        for (int i = 0; i < subjects.length; i++) {
            changeAble[i] = Boolean.parseBoolean(XMLManage.XMLReader(file.getPath(), URLs, i));
            toChangeAtt[i] = new JCheckBox("", changeAble[i]);
            subjects[i] = new JTextField(20);
            subjects[i].setText(URLs[i]);
            subjectLabels[i] = new JLabel(korSubjectNames[i]);
            panel.add(subjectLabels[i], constr);
            constr.gridx=1;
            panel.add(subjects[i], constr);
            constr.gridx=2;
            panel.add(toChangeAtt[i], constr);
            constr.gridx=0; constr.gridy=i+1;
        }
        constr.anchor = GridBagConstraints.CENTER;

        JButton OKButton = new JButton("OK");
        JButton CancelButton = new JButton("Cancel");
        OKButton.addActionListener(e -> {
            for (int i = 0; i < subjects.length; i++) {
                URLs[i] = subjects[i].getText();
            }
            try {
                XMLManage.XMLWriter(saveConfig, txt, subjectNames, URLs, AttAble, changeAble);
            } catch (ParserConfigurationException | TransformerException parserConfigurationException) {
                parserConfigurationException.printStackTrace();
            }
            frame.dispose();
        });
        CancelButton.addActionListener(e -> frame.dispose());
        panel.add(OKButton, constr);
        constr.gridx=1;
        panel.add(CancelButton, constr);
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        frame.add(mainPanel);
        frame.pack();
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
