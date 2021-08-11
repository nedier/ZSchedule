package openSite;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    Sound(File file) {
        if(file.getName().endsWith("wav")) {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(file.getName().endsWith("mp3")) {
            mkGUI.mkJOptionPane("현재 mp3 파일 형식은 지원 되지 않습니다.\n wav 형식으로 변환해 주세요", "Notification");
            manyIF.desktopView("https://online-audio-converter.com/");
        }
    }
}
