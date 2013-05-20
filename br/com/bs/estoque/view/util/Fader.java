package br.com.bs.estoque.view.util;

import java.util.TimerTask;
import javax.swing.JDialog;
import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;
import javax.swing.JWindow;

public class Fader extends TimerTask {

    private JWindow window;

    public Fader(JWindow jDialog) {
        this.window = jDialog;
    }
    //As Fader extends from Timer, it's the run() method which does the main job
    @Override public void run() {
        //The opacity is reduced by 0,01f steps
        //If this value equals 0 (invisible), we close the JDialog with dispose()
    if(AWTUtilities.getWindowOpacity(window) > 0.01f){
        AWTUtilities.setWindowOpacity(window,
        AWTUtilities.getWindowOpacity(window)-0.01f);
    }
    else {
        window.dispose();
    }
    }
}