/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque;

import br.com.bs.estoque.view.util.SplashWindow;
import java.awt.Frame;

/**
 *
 * @author Misael Ferreira
 */
public class Estoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SplashWindow("imgs/logo.jpg", new Frame());
        new br.com.bs.estoque.view.LoginForm().setVisible(true);
    }
    
}
