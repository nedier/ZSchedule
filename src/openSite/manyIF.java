package openSite;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static openSite.mkGUI.mkJOptionPane;

public class manyIF extends JOptionPane {
    static String nowH = new SimpleDateFormat("HH").format(new Date());
    static String nowM = new SimpleDateFormat("mm").format(new Date());
    static int now = Integer.parseInt(nowH + nowM);
    static void manyIFNowClass(String[] URLs) {
        switch (temp1.date) {
            case 1 -> {
                if(now > 1440 || now < 845) {
                    desktopView(URLs[0]);
                } else if(now < 930) {
                    desktopView(URLs[4]);
                } else if(now < 1025) {
                    desktopView(URLs[7]);
                } else if(now < 1120) {
                    desktopView(URLs[1]);
                } else if(now < 1215) {
                    desktopView(URLs[5]);
                } else if(now < 1340) {
                    desktopView(URLs[2]);
                } else if(now < 1435) {
                    desktopView(URLs[10]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 2 -> {
                if(now < 845 || now > 1535) {
                    desktopView(URLs[0]);
                } else if(now < 930) {
                    desktopView(URLs[6]);
                } else if(now < 1025) {
                    desktopView(URLs[2]);
                } else if(now < 1120) {
                    desktopView(URLs[1]);
                } else if(now < 1215) {
                    desktopView(URLs[3]);
                } else if(now < 1340) {
                    desktopView(URLs[10]);
                } else if(now < 1435) {
                    desktopView(URLs[12]);
                } else if(now < 1530) {
                    desktopView(URLs[5]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 3 -> {
                if(now < 845 || now > 1535) {
                    desktopView(URLs[0]);
                } else if(now < 930) {
                    desktopView(URLs[3]);
                } else if(now < 1025) {
                    desktopView(URLs[2]);
                } else if(now < 1120) {
                    desktopView(URLs[13]);
                } else if(now < 1215) {
                    desktopView(URLs[14]);
                } else if(now < 1340) {
                    desktopView(URLs[1]);
                } else if(now < 1435) {
                    desktopView(URLs[8]);
                } else if(now < 1530) {
                    desktopView(URLs[9]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 4 -> {
                if(now < 845 || now > 1440) {
                    desktopView(URLs[0]);
                } else if(now < 930) {
                    desktopView(URLs[6]);
                } else if(now < 1025) {
                    desktopView(URLs[13]);
                } else if(now < 1120) {
                    desktopView(URLs[5]);
                } else if(now < 1215) {
                    desktopView(URLs[2]);
                } else if(now < 1340) {
                    desktopView(URLs[7]);
                } else if(now < 1435) {
                    desktopView(URLs[3]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 5 -> {
                if(now > 1440 || now < 845) {
                    desktopView(URLs[0]);
                } else if(now < 930) {
                    desktopView(URLs[1]);
                } else if(now < 1025) {
                    desktopView(URLs[11]);
                } else if(now < 1120) {
                    desktopView(URLs[9]);
                } else if(now < 1215) {
                    desktopView(URLs[6]);
                } else if(now < 1340) {
                    desktopView(URLs[8]);
                } else if(now < 1435) {
                    desktopView(URLs[13]);
                } else {
                    System.out.println("BUG");
                }
            }
            default -> mkJOptionPane("휴일이거나 버그", null, 0);
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
        if(!(temp1.date == 0 ||temp1.date == 6) && now < 845 || now > 1535) {
            jL.setText("조회 종례");
        } else if(now < 930) {
            jL.setText("1교시");
        } else if(now < 1025) {
            jL.setText("2교시");
        } else if(now < 1120) {
            jL.setText("3교시");
        } else if(now < 1215) {
            jL.setText("4교시");
        } else if(now < 1259) {
            jL.setText("점심");
        } else if(now < 1340) {
            jL.setText("5교시");
        } else if(now < 1435) {
            jL.setText("6교시");
        } else if((temp1.date == 2 ||temp1.date == 3) && now < 1530) {
            jL.setText("7교시");
        } else if(!(temp1.date == 2 ||temp1.date == 3) && now < 1530) {
            jL.setText("조회 종례");
        }
    }

    public static void desktopView(String str) {
        try{
            Desktop.getDesktop().browse(new URI(str));
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}