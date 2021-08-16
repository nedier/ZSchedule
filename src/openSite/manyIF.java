package openSite;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;

import static openSite.mkGUI.mkJOptionPane;

public class manyIF extends JOptionPane {
    static int now = temp1.now;
    static int breakTimeReduced = 15 - Integer.parseInt(mkGUI.times[0]);
    static int studyTimeReduced = 40 - Integer.parseInt(mkGUI.times[1]);
    static int allReduced = breakTimeReduced + studyTimeReduced;
    static int[] allTimes = new int[]{845 - breakTimeReduced, 930, 1025, 1120, 1215, 1305, 1340, 1435, 1440, 1530, 1535};
    static int[] shorterAllTimes = new int[10];
    static boolean[] isClass7 = new boolean[5];
    static String[] saveTimetable = new String[mkGUI.timetable.length];
    static String[] URLs = new String[mkGUI.timetable.length];
    manyIF(int shortenedTime, String[] timetable, Map<String, String> nameURL) {
        saveTimetable = timetable;
        for (int i = 0; i < isClass7.length; i++) {
            isClass7[i] = !(timetable[((i + 1) * 7) - 1].equals(""));
        }
        for (int i = 0; i < saveTimetable.length; i++) {
            URLs[i] = nameURL.get(saveTimetable[i]);
        }
        for (int i = 1; i < allTimes.length; i++) {
            String[] strArray = new String[]{
                    String.valueOf(allTimes[i]-allReduced),
                    String.valueOf(allTimes[i]).substring(0,1),
                    String.valueOf(allTimes[i]).substring(0,2)};
            if(!strArray[0].substring(0,1).equals(strArray[1]) || !strArray[0].substring(0,2).equals(strArray[2])) {
                allTimes[i] -= allReduced + 40;
            } else {
                allTimes[i] -= allReduced;
            }
        }
        shorterAllTimes[0] = allTimes[0];
        for (int i = 1; i < shorterAllTimes.length; i++) {
            shorterAllTimes[i]= allTimes[i];
            String[] strArray = new String[]{
                    String.valueOf(shorterAllTimes[i]-allReduced-shortenedTime),
                    String.valueOf(shorterAllTimes[i]).substring(0,1),
                    String.valueOf(shorterAllTimes[i]).substring(0,2)};
            if(!strArray[0].substring(0,1).equals(strArray[1]) || !strArray[0].substring(0,2).equals(strArray[2])) {
                shorterAllTimes[i] -= allReduced + shortenedTime + 40;
            } else {
                shorterAllTimes[i] -= allReduced + shortenedTime;
            }
        }
    }
    static void manyIFNowClass() {
        switch (temp1.date) {
            case 1 -> {
                if(now < allTimes[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now < allTimes[1]) {
                    desktopView(URLs[0]);
                } else if(now < allTimes[2]) {
                    desktopView(URLs[1]);
                } else if(now < allTimes[3]) {
                    desktopView(URLs[2]);
                } else if(now < allTimes[5]) {
                    desktopView(URLs[3]);
                } else if(now < allTimes[6]) {
                    desktopView(URLs[4]);
                } else if(now < allTimes[7]) {
                    desktopView(URLs[5]);
                } else if(now < allTimes[9] && isClass7[0]) {
                    desktopView(URLs[6]);
                } else if(now > allTimes[8] && !isClass7[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now > allTimes[10] && isClass7[0]) {
                    desktopView(mkGUI.URLs[0]);
                }
            }
            case 2 -> {
                if(now < allTimes[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now < allTimes[1]) {
                    desktopView(URLs[7]);
                } else if(now < allTimes[2]) {
                    desktopView(URLs[8]);
                } else if(now < allTimes[3]) {
                    desktopView(URLs[9]);
                } else if(now < allTimes[5]) {
                    desktopView(URLs[10]);
                } else if(now < allTimes[6]) {
                    desktopView(URLs[11]);
                } else if(now < allTimes[7]) {
                    desktopView(URLs[12]);
                } else if(now < allTimes[9] && isClass7[1]) {
                    desktopView(URLs[13]);
                } else if(now > allTimes[8] && !isClass7[1]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now > allTimes[10] && isClass7[1]) {
                    desktopView(mkGUI.URLs[0]);
                }
            }
            case 3 -> {
                if(now < allTimes[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now < allTimes[1]) {
                    desktopView(URLs[14]);
                } else if(now < allTimes[2]) {
                    desktopView(URLs[15]);
                } else if(now < allTimes[3]) {
                    desktopView(URLs[16]);
                } else if(now < allTimes[5]) {
                    desktopView(URLs[17]);
                } else if(now < allTimes[6]) {
                    desktopView(URLs[18]);
                } else if(now < allTimes[7]) {
                    desktopView(URLs[19]);
                } else if(now < allTimes[9] && isClass7[2]) {
                    desktopView(URLs[20]);
                } else if(now > allTimes[8] && !isClass7[2]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now > allTimes[10] && isClass7[2]) {
                    desktopView(mkGUI.URLs[0]);
                }
            }
            case 4 -> {
                if(now < allTimes[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now < allTimes[1]) {
                    desktopView(URLs[21]);
                } else if(now < allTimes[2]) {
                    desktopView(URLs[22]);
                } else if(now < allTimes[3]) {
                    desktopView(URLs[23]);
                } else if(now < allTimes[5]) {
                    desktopView(URLs[24]);
                } else if(now < allTimes[6]) {
                    desktopView(URLs[25]);
                } else if(now < allTimes[7]) {
                    desktopView(URLs[26]);
                } else if(now < allTimes[9] && isClass7[3]) {
                    desktopView(URLs[27]);
                } else if(now > allTimes[8] && !isClass7[3]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now > allTimes[10] && isClass7[3]) {
                    desktopView(mkGUI.URLs[0]);
                }
            }
            case 5 -> {
                if(now < allTimes[0]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now < allTimes[1]) {
                    desktopView(URLs[28]);
                } else if(now < allTimes[2]) {
                    desktopView(URLs[29]);
                } else if(now < allTimes[3]) {
                    desktopView(URLs[30]);
                } else if(now < allTimes[5]) {
                    desktopView(URLs[31]);
                } else if(now < allTimes[6]) {
                    desktopView(URLs[32]);
                } else if(now < allTimes[7]) {
                    desktopView(URLs[33]);
                } else if(now < allTimes[9] && isClass7[4]) {
                    desktopView(URLs[35]);
                } else if(now > allTimes[8] && !isClass7[4]) {
                    desktopView(mkGUI.URLs[0]);
                } else if(now > allTimes[10] && isClass7[4]) {
                    desktopView(mkGUI.URLs[0]);
                }
            }
            default -> {
                mkJOptionPane("휴일이거나 버그", "Notification", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
    static void manyIFToday(boolean b, int i, String[] URLs) {
        if (b) {
            switch (i) {
                case 0 -> {
                    if(temp1.date == 1 || temp1.date == 2 || temp1.date == 3 || temp1.date == 4 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 조종례가 들어있습니다 \n 링크를 입력해 주세요", URLs, 0);
                    }
                }
                case 1 -> {
                    if(temp1.date == 1 || temp1.date == 2 || temp1.date == 3 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 국어가 들어있습니다 \n 링크를 입력해 주세요", URLs, 1);
                    }
                }
                case 2 -> {
                    if(temp1.date == 1 || temp1.date == 2 || temp1.date == 3 || temp1.date == 4) {
                        mkJOptionPane("오늘 수업에 수학이 들어있습니다 \n 링크를 입력해 주세요", URLs, 2);
                    }
                }
                case 3 -> {
                    if(temp1.date == 2 || temp1.date == 3 || temp1.date == 4) {
                        mkJOptionPane("오늘 수업에 영어가 들어있습니다 \n 링크를 입력해 주세요", URLs, 3);
                    }
                }
                case 4 -> {
                    if(temp1.date == 1) {
                        mkJOptionPane("오늘 수업에 과학 B 가 들어있습니다 \n 링크를 입력해 주세요", URLs, 4);
                    }
                }
                case 5 -> {
                    if(temp1.date == 1 || temp1.date == 2 || temp1.date == 4) {
                        mkJOptionPane("오늘 수업에 역사가 들어있습니다 \n 링크를 입력해 주세요", URLs, 5);
                    }
                }
                case 6 -> {
                    if(temp1.date == 2 || temp1.date == 3 || temp1.date == 4 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 체육이 들어있습니다 \n 링크를 입력해 주세요", URLs, 6);
                    }
                }
                case 7 -> {
                    if(temp1.date == 1 || temp1.date == 4) {
                        mkJOptionPane("오늘 수업에 한문이 들어있습니다 \n 링크를 입력해 주세요", URLs, 7);
                    }
                }
                case 8 -> {
                    if(temp1.date == 3 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 음악 들어있습니다 \n 링크를 입력해 주세요", URLs, 8);
                    }
                }
                case 9 -> {
                    if(temp1.date == 3 ||temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 도덕이 들어있습니다 \n 링크를 입력해 주세요", URLs, 9);
                    }
                }
                case 10 -> {
                    if(temp1.date == 1 || temp1.date == 2) {
                        mkJOptionPane("오늘 수업에 가정이 들어있습니다 \n 링크를 입력해 주세요", URLs, 10);
                    }
                }
                case 11 -> {
                    if(temp1.date == 2 || temp1.date == 3 || temp1.date == 4 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 기술이 들어있습니다 \n 링크를 입력해 주세요", URLs, 11);
                    }
                }
                case 12 -> {
                    if(temp1.date == 2) {
                        mkJOptionPane("오늘 수업에 창체가 들어있습니다 \n 링크를 입력해 주세요", URLs, 12);
                    }
                }
                case 13 -> {
                    if(temp1.date == 3 || temp1.date == 4 || temp1.date == 5) {
                        mkJOptionPane("오늘 수업에 과학 A 가 들어있습니다 \n 링크를 입력해 주세요", URLs, 13);
                    }
                }
                case 14 -> {
                    if(temp1.date == 3) {
                        mkJOptionPane("오늘 수업에 스포츠가 들어있습니다 \n 링크를 입력해 주세요", URLs, 14);
                    }
                }
            }
        }
    }
    public static void nowClass(JLabel jL) {
        if(!(temp1.date == 0 || temp1.date == 6) && now < allTimes[0] || now > allTimes[10]) {
            jL.setText("조회 종례");
        } else if(now < allTimes[1]) {
            jL.setText("1교시");
        } else if(now < allTimes[2]) {
            jL.setText("2교시");
        } else if(now < allTimes[3]) {
            jL.setText("3교시");
        } else if(now < allTimes[4]) {
            jL.setText("4교시");
        } else if(now < allTimes[5]) {
            jL.setText("점심");
        } else if(now < allTimes[6]) {
            jL.setText("5교시");
        } else if(now < allTimes[7]) {
            jL.setText("6교시");
        } else if((temp1.date == 2 ||temp1.date == 3) && now < allTimes[9]) {
            jL.setText("7교시");
        } else if(!(temp1.date == 2 ||temp1.date == 3) && now < allTimes[9]) {
            jL.setText("조회 종례");
        }
    }
    public static boolean autoLinkingIF(String[] URLs, int shortenedTime) {
        int min = LocalTime.now().getMinute();
        int hour = LocalTime.now().getHour();
        int innerNow = Integer.parseInt((hour == 0 ? "12" : hour) + (min < 10 ? "0" + min : String.valueOf(min)));
        switch (temp1.date) {
            case 1 -> {
                if(innerNow == shorterAllTimes[0] || innerNow == 1440 - allReduced - shortenedTime) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == shorterAllTimes[1]) {
                    desktopView(URLs[4]);
                    return true;
                } else if(innerNow == shorterAllTimes[2]) {
                    desktopView(URLs[7]);
                    return true;
                } else if(innerNow == shorterAllTimes[3]) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == shorterAllTimes[5]) {
                    desktopView(URLs[5]);
                    return true;
                } else if(innerNow == shorterAllTimes[6]) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == shorterAllTimes[7]) {
                    desktopView(URLs[10]);
                    return true;
                }
            }
            case 2 -> {
                if(innerNow == shorterAllTimes[0] || innerNow == shorterAllTimes[10]) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == shorterAllTimes[1]) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == shorterAllTimes[2]) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == shorterAllTimes[3]) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == shorterAllTimes[5]) {
                    desktopView(URLs[3]);
                    return true;
                } else if(innerNow == shorterAllTimes[6]) {
                    desktopView(URLs[10]);
                    return true;
                } else if(innerNow == shorterAllTimes[7]) {
                    desktopView(URLs[12]);
                    return true;
                } else if(innerNow == shorterAllTimes[9]) {
                    desktopView(URLs[5]);
                    return true;
                }
            }
            case 3 -> {
                if(innerNow == shorterAllTimes[0] || innerNow == shorterAllTimes[10]) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == shorterAllTimes[1]) {
                    desktopView(URLs[3]);
                    return true;
                } else if(innerNow == shorterAllTimes[2]) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == shorterAllTimes[3]) {
                    desktopView(URLs[13]);
                    return true;
                } else if(innerNow == shorterAllTimes[5]) {
                    desktopView(URLs[14]);
                    return true;
                } else if(innerNow == shorterAllTimes[6]) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == shorterAllTimes[7]) {
                    desktopView(URLs[8]);
                    return true;
                } else if(innerNow == shorterAllTimes[9]) {
                    desktopView(URLs[9]);
                    return true;
                }
            }
            case 4 -> {
                if(innerNow == shorterAllTimes[0] || innerNow == 1440 - allReduced - shortenedTime) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == shorterAllTimes[1]) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == shorterAllTimes[2]) {
                    desktopView(URLs[13]);
                    return true;
                } else if(innerNow == shorterAllTimes[3]) {
                    desktopView(URLs[5]);
                    return true;
                } else if(innerNow == shorterAllTimes[5]) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == shorterAllTimes[6]) {
                    desktopView(URLs[7]);
                    return true;
                } else if(innerNow == shorterAllTimes[7]) {
                    desktopView(URLs[3]);
                    return true;
                }
            }
            case 5 -> {
                if(innerNow == shorterAllTimes[0] || innerNow == 1440 - allReduced - shortenedTime) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == shorterAllTimes[1]) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == shorterAllTimes[2]) {
                    desktopView(URLs[11]);
                    return true;
                } else if(innerNow == shorterAllTimes[3]) {
                    desktopView(URLs[9]);
                    return true;
                } else if(innerNow == shorterAllTimes[5]) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == shorterAllTimes[6]) {
                    desktopView(URLs[8]);
                    return true;
                } else if(innerNow == shorterAllTimes[7]) {
                    desktopView(URLs[13]);
                    return true;
                }
            }
            default -> {
                mkJOptionPane("휴일이거나 버그", "Notification", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        return false;
    }
    public static void desktopView(String str) {
        try{
            Desktop.getDesktop().browse(new URI(str));
        } catch(IOException | URISyntaxException e) {
            mkJOptionPane("주소가 잘못 되었습니다", "Notification", JOptionPane.ERROR_MESSAGE);
        }
    }
}