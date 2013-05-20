/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bs.estoque.view.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *
 * @author Misael Ferreira
 */
public class SplashWindow extends JWindow {
    String filename;
    Frame f;
    private static SplashWindow instance;
    
    
    public SplashWindow(String fileName, Frame f) {
        super(f);
        instance = this;
        this.f = f;
        this.filename = fileName;
        JLabel l = new JLabel(new ImageIcon(fileName));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
        Dimension lsize = l.getSize();
        setLocation(screenSize.width / 2 - (lsize.width / 2), screenSize.height / 2 - (lsize.height / 2));
        setVisible(true);
        this.setAlwaysOnTop(true);
        screenSize = null;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //setVisible(false);
                Timer timer = new Timer();
                timer.schedule(new Fader(instance), 500,5);                
                //dispose();
            }
        });
    }
}
