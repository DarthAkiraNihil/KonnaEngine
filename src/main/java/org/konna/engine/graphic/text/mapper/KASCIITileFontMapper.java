package org.konna.engine.graphic.text.mapper;

import org.konna.engine.common.KVector2;
import org.konna.engine.common.except.KOutOfRangeException;

public class KASCIITileFontMapper extends KTileFontMapper{

    @Override
    public KVector2 getSymbolCoordinates(char symbol) {
        if ((int) symbol > 255) {
            throw new KOutOfRangeException(String.format("Invalid character for ASCII mapper: %c", symbol));
        } else {
            return new KVector2(
                (int) symbol % 255,
                (int) symbol / 255
            );
        }
    }

}
