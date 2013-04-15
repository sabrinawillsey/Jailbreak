/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jailbreak;

import environment.ApplicationStarter;
import environment.Environment;
import image.ResourceTools;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Sabrina
 */
public class JailBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        String[] args = new String[0];
        String appName = "Prisoner 60241 has escaped!";
        Dimension appSize = new Dimension(1775, 644);

        Image background = ResourceTools.loadImageFromResource("resources/jailcell.jpg");
        Environment environment = new JailBreakEnvironment(background);
        ApplicationStarter.run(args, appName, appSize, environment);
    }
}
