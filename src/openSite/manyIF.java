package openSite;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalTime;

import static openSite.mkGUI.mkJOptionPane;

public class manyIF extends JOptionPane {
    static int now = temp1.now;
    static int breakTimeReduced = 15 - mkGUI.breakTime;
    static int studyTimeReduced = 15 - mkGUI.studyTime;
    static int allReduced = breakTimeReduced + studyTimeReduced;
    static void manyIFNowClass(String[] URLs) {
        switch (temp1.date) {
            case 1 -> {
                if(now < 845 - breakTimeReduced || now > 1440 - allReduced) {
                    desktopView(URLs[0]);
                } else if(now < 930 - allReduced) {
                    desktopView(URLs[4]);
                } else if(now < 1025 - allReduced) {
                    desktopView(URLs[7]);
                } else if(now < 1120 - allReduced) {
                    desktopView(URLs[1]);
                } else if(now < 1215 - allReduced) {
                    desktopView(URLs[5]);
                } else if(now < 1340 - allReduced) {
                    desktopView(URLs[2]);
                } else if(now < 1435 - allReduced) {
                    desktopView(URLs[10]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 2 -> {
                if(now < 845 - breakTimeReduced || now > 1535 - allReduced) {
                    desktopView(URLs[0]);
                } else if(now < 930 - allReduced) {
                    desktopView(URLs[6]);
                } else if(now < 1025 - allReduced) {
                    desktopView(URLs[2]);
                } else if(now < 1120 - allReduced) {
                    desktopView(URLs[1]);
                } else if(now < 1215 - allReduced) {
                    desktopView(URLs[3]);
                } else if(now < 1340 - allReduced) {
                    desktopView(URLs[10]);
                } else if(now < 1435 - allReduced) {
                    desktopView(URLs[12]);
                } else if(now < 1530 - allReduced) {
                    desktopView(URLs[5]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 3 -> {
                if(now < 845 - breakTimeReduced || now > 1535 - allReduced) {
                    desktopView(URLs[0]);
                } else if(now < 930 - allReduced) {
                    desktopView(URLs[3]);
                } else if(now < 1025 - allReduced) {
                    desktopView(URLs[2]);
                } else if(now < 1120 - allReduced) {
                    desktopView(URLs[13]);
                } else if(now < 1215 - allReduced) {
                    desktopView(URLs[14]);
                } else if(now < 1340 - allReduced) {
                    desktopView(URLs[1]);
                } else if(now < 1435 - allReduced) {
                    desktopView(URLs[8]);
                } else if(now < 1530 - allReduced) {
                    desktopView(URLs[9]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 4 -> {
                if(now < 845 - breakTimeReduced || now > 1440 - allReduced) {
                    desktopView(URLs[0]);
                } else if(now < 930 - allReduced) {
                    desktopView(URLs[6]);
                } else if(now < 1025 - allReduced) {
                    desktopView(URLs[13]);
                } else if(now < 1120 - allReduced) {
                    desktopView(URLs[5]);
                } else if(now < 1215 - allReduced) {
                    desktopView(URLs[2]);
                } else if(now < 1340 - allReduced) {
                    desktopView(URLs[7]);
                } else if(now < 1435 - allReduced) {
                    desktopView(URLs[3]);
                } else {
                    System.out.println("BUG");
                }
            }
            case 5 -> {
                if(now > 1440 - breakTimeReduced || now < 845 - allReduced) {
                    desktopView(URLs[0]);
                } else if(now < 930 - allReduced) {
                    desktopView(URLs[1]);
                } else if(now < 1025 - allReduced) {
                    desktopView(URLs[11]);
                } else if(now < 1120 - allReduced) {
                    desktopView(URLs[9]);
                } else if(now < 1215 - allReduced) {
                    desktopView(URLs[6]);
                } else if(now < 1340 - allReduced) {
                    desktopView(URLs[8]);
                } else if(now < 1435 - allReduced) {
                    desktopView(URLs[13]);
                } else {
                    System.out.println("BUG");
                }
            }
            default -> {
                mkJOptionPane("휴일이거나 버그", "Notification");
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
        if(!(temp1.date == 0 || temp1.date == 6) && now < 845 - breakTimeReduced || now > 1535 - allReduced) {
            jL.setText("조회 종례");
        } else if(now < 930 - allReduced) {
            jL.setText("1교시");
        } else if(now < 1025 - allReduced) {
            jL.setText("2교시");
        } else if(now < 1120 - allReduced) {
            jL.setText("3교시");
        } else if(now < 1215 - allReduced) {
            jL.setText("4교시");
        } else if(now < 1259 - allReduced) {
            jL.setText("점심");
        } else if(now < 1340 - allReduced) {
            jL.setText("5교시");
        } else if(now < 1435 - allReduced) {
            jL.setText("6교시");
        } else if((temp1.date == 2 ||temp1.date == 3) && now < 1530 - allReduced) {
            jL.setText("7교시");
        } else if(!(temp1.date == 2 ||temp1.date == 3) && now < 1530 - allReduced) {
            jL.setText("조회 종례");
        }
    }
    public static boolean autoLinkingIF(String[] URLs) {
        int innerNow = Integer.parseInt(LocalTime.now().getHour()
                + (LocalTime.now().getMinute() < 10 ? "0" + LocalTime.now().getMinute() : String.valueOf(LocalTime.now().getMinute())));
        switch (temp1.date) {
            case 1 -> {
                if(innerNow == 845 - breakTimeReduced || innerNow == 1440 - allReduced) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == 930 - allReduced) {
                    desktopView(URLs[4]);
                    return true;
                } else if(innerNow == 1025 - allReduced) {
                    desktopView(URLs[7]);
                    return true;
                } else if(innerNow == 1120 - allReduced) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == 1215 - allReduced) {
                    desktopView(URLs[5]);
                    return true;
                } else if(innerNow == 1340 - allReduced) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == 1435 - allReduced) {
                    desktopView(URLs[10]);
                    return true;
                }
            }
            case 2 -> {
                if(innerNow == 845 - breakTimeReduced|| innerNow == 1535 - allReduced) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == 930 - allReduced) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == 1025 - allReduced) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == 1120 - allReduced) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == 1215 - allReduced) {
                    desktopView(URLs[3]);
                    return true;
                } else if(innerNow == 1340 - allReduced) {
                    desktopView(URLs[10]);
                    return true;
                } else if(innerNow == 1435 - allReduced) {
                    desktopView(URLs[12]);
                    return true;
                } else if(innerNow == 1530 - allReduced) {
                    desktopView(URLs[5]);
                    return true;
                }
            }
            case 3 -> {
                if(innerNow == 845 - breakTimeReduced|| innerNow == 1535 - allReduced) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == 930 - allReduced) {
                    desktopView(URLs[3]);
                    return true;
                } else if(innerNow == 1025 - allReduced) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == 1120 - allReduced) {
                    desktopView(URLs[13]);
                    return true;
                } else if(innerNow == 1215 - allReduced) {
                    desktopView(URLs[14]);
                    return true;
                } else if(innerNow == 1340 - allReduced) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == 1435 - allReduced) {
                    desktopView(URLs[8]);
                    return true;
                } else if(innerNow == 1530 - allReduced) {
                    desktopView(URLs[9]);
                    return true;
                }
            }
            case 4 -> {
                if(innerNow == 845 - breakTimeReduced|| innerNow == 1440 - allReduced) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == 930 - allReduced) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == 1025 - allReduced) {
                    desktopView(URLs[13]);
                    return true;
                } else if(innerNow == 1120 - allReduced) {
                    desktopView(URLs[5]);
                    return true;
                } else if(innerNow == 1215 - allReduced) {
                    desktopView(URLs[2]);
                    return true;
                } else if(innerNow == 1340 - allReduced) {
                    desktopView(URLs[7]);
                    return true;
                } else if(innerNow == 1435 - allReduced) {
                    desktopView(URLs[3]);
                    return true;
                }
            }
            case 5 -> {
                if(innerNow == 845 - breakTimeReduced || innerNow == 1440 - allReduced) {
                    desktopView(URLs[0]);
                    return true;
                } else if(innerNow == 930 - allReduced) {
                    desktopView(URLs[1]);
                    return true;
                } else if(innerNow == 1025 - allReduced) {
                    desktopView(URLs[11]);
                    return true;
                } else if(innerNow == 1120 - allReduced) {
                    desktopView(URLs[9]);
                    return true;
                } else if(innerNow == 1215 - allReduced) {
                    desktopView(URLs[6]);
                    return true;
                } else if(innerNow == 1340 - allReduced) {
                    desktopView(URLs[8]);
                    return true;
                } else if(innerNow == 1435 - allReduced) {
                    desktopView(URLs[13]);
                    return true;
                }
            }
            default -> {
                mkJOptionPane("휴일이거나 버그", "Notification");
                System.exit(0);
            }
        }
        return false;
    }
    public static void desktopView(String str) {
        try{
            Desktop.getDesktop().browse(new URI(str));
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}