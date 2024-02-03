package org.konna.engine.graphic;

import org.konna.engine.common.KSize;
import org.konna.engine.common.except.KGraphicException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class KRenderUnitList {
    private ArrayList<BufferedImage> renderUnitList;

    public KRenderUnitList(String pathToTable, KSize tableUnitSize) throws KGraphicException{
        this.renderUnitList = new ArrayList<>();
        try {
            if (pathToTable == null) {
                throw new KGraphicException("Error while creating render unit list: blank path passed, use another constructor");
            } else {
                BufferedImage table = ImageIO.read(new File(pathToTable));
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        this.renderUnitList.add(
                            table.getSubimage(16*j, 16*i, tableUnitSize.w, tableUnitSize.h)
                        );
                    }
                }
            }
        } catch (IOException e) {
            throw new KGraphicException("Error while loading the render unit base table. Maybe doesn't exist?");
        }

    }

    public KRenderUnitList() {
        this.renderUnitList = new ArrayList<>();
    }

    public BufferedImage getUnit(int unitID, KColor color) {
        //BufferedImage sub;
        BufferedImage temp = this.renderUnitList.get(unitID);
        for (int i = 0; i < temp.getHeight(); i++) {
            for (int j = 0; j < temp.getWidth(); j++) {
                KColor unitPixelColor = new KColor(temp.getRGB(j, i));
                unitPixelColor.multiply(color);
                temp.setRGB(j, i, unitPixelColor.getConvertedToInt());
            }
        }
        return temp;
    }
}
