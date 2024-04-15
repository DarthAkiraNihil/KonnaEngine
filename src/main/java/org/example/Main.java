package org.example;

import org.konna.engine.common.KSize;
import org.konna.engine.common.KVector2;
import org.konna.engine.common.except.KGraphicException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderMachine;
import org.konna.engine.graphic.render.KTileRenderAttributes;
import org.konna.engine.graphic.render.KUnitRenderer;
import org.konna.engine.graphic.semiconsole.KSemiConsole;
import org.konna.engine.graphic.tables.KImageTable;
import org.konna.engine.graphic.tables.KSpriteTable;
import org.konna.engine.graphic.tables.KTileSheet;
import org.konna.engine.graphic.tables.KTileTable;

import javax.imageio.ImageIO;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //System.out.println(10  / 3);

        TestRenderable test = new TestRenderable();

        try {

            KTileTable ktt = new KTileTable();
            KTileSheet kts = new KTileSheet(ImageIO.read(new File("cp437_16x16.png")));

            kts.addTile(new KTileRenderAttributes(
                4,
                true,
                new KColor(0, 255, 0, 255),
                0,
                new KVector2(32,16),
                new KSize(16, 16)
            ));

            kts.addTile(new KTileRenderAttributes(
                5,
                true,
                new KColor(0, 255, 255, 255),
                0,
                new KVector2(32,16),
                new KSize(16, 16)
            ));

            ktt.addTileSheet(kts);

            KUnitRenderer ur = new KUnitRenderer(
                ktt,
                new KSpriteTable(),
                new KImageTable()
                );

            KRenderMachine krm = new KRenderMachine(ur, null);
            KSemiConsole ksc = new KSemiConsole(krm);
            //ksc.render(test, new KVector2(1, 2));
        }
        catch (Exception k) {
            k.printStackTrace();
        }
    }
}