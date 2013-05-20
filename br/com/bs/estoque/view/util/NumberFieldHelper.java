/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bs.estoque.view.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Misael Ferreira
 */
public class NumberFieldHelper extends PlainDocument {

    private int numero_maximo_digitos;
    
    public NumberFieldHelper(int numDigitos){
        this.numero_maximo_digitos = numDigitos;
    }

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        String textoAnt = getText(0, getLength());

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
        }
        
        if(textoAnt.equals("") || textoAnt == null)
            textoAnt = "0";
        
        if (textoAnt.charAt(0) == '0') {
            super.remove(0, getLength());            
            StringBuilder s = new StringBuilder(textoAnt + str);
            s.deleteCharAt(0);

            if (s.length() < numero_maximo_digitos) {
                int charfaltantes = numero_maximo_digitos - s.length();
                for (int i = charfaltantes; i > 0; i--) {
                    s.insert(0, "0");
                }
            }            
            super.insertString(0, s.toString(), a);
        }
    }

    public void remove(int offset, int length) throws BadLocationException {
        super.remove(offset, length);
        String texto = getText(0, getLength());                
        super.remove(0, getLength());
        insertString(0, texto, null);
    }
}
