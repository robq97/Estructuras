/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.Color;

/**
 *
 * @author Bryan Corrales M
 */
public class Info {
    
    private static Color frameBackground = new Color(166, 166, 166);
    private static Color btnBackground = new Color(128, 128, 128);

    public static Color getFrameBackground() {
        return frameBackground;
    }

    public static void setFrameBackground(Color frameBackground) {
        Info.frameBackground = frameBackground;
    }

    public static Color getBtnBackground() {
        return btnBackground;
    }

    public static void setBtnBackground(Color btnBackground) {
        Info.btnBackground = btnBackground;
    }
}
