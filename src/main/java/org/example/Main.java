package org.example;

import org.konna.engine.common.except.KGraphicException;
import org.konna.engine.graphic.semiconsole.KSemiConsole;

public class Main {
    public static void main(String[] args) {
        try {
            KSemiConsole ksc = new KSemiConsole("D:\\CodeShit\\Java\\KonnaEngine\\cp437_16x16.png");
        }
        catch (KGraphicException k) {
            System.out.println("Fuck");
        }
    }
}