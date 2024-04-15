package org.konna.engine.graphic.tables;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderUnit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class KImageTable extends KBaseTable{

    public HashMap<Integer, String> images;
    public HashMap<Integer, BufferedImage> loaded;

    public KImageTable(HashMap<Integer, String> imagePathTable) {
        this.images = imagePathTable;
    }

    @Override
    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {
        if (this.loaded.containsKey(unit.id)) {
            return this.loaded.get(unit.id);
        } else {
            if (!this.images.containsKey(unit.id)) {
                throw new KNotFoundException(String.format("No image in the image table with id %d", unit.id));
            } else {

                try {
                    BufferedImage loadedImage = ImageIO.read(
                        new File(
                            this.images.get(unit.id)
                        )
                    );

                    for (int i = 0; i < loadedImage.getHeight(); i++) {
                        for (int j = 0; j < loadedImage.getWidth(); j++) {
                            KColor newPixColor = new KColor(loadedImage.getRGB(j, i));
                            newPixColor.multiply(unit.color); //TODO do nothinng if white
                            loadedImage.setRGB(
                                j,
                                i,
                                newPixColor.getConvertedToInt()
                            );

                        }
                    }

                    this.loaded.put(unit.id, loadedImage);

                    return loadedImage;
                } catch (IOException e) {
                    throw new KNotFoundException(e); //so genius
                }
            }
        }
    }
}
