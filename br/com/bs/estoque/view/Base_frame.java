/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Misael
 */
public class Base_frame extends javax.swing.JFrame implements FocusListener{
    public Base_frame(){
        centerFrameOnScreen();
    }

    protected void centerFrameOnScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation((screenWidth - this.getSize().width)/2, (screenHeight - this.getSize().height)/2);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() instanceof JFormattedTextField){
            JFormattedTextField tf = ((JFormattedTextField)e.getSource());
            tf.setCaretPosition(tf.getText().length());
        }else
            if(e.getSource() instanceof JTextField){
                ((JTextField)e.getSource()).selectAll();
            }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
