package by.epam.lw01.dto;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.Iterator;

/**
 * Created by aleh on 06.03.14.
 */
public class CaveDTO extends GeneralDTO {
    public Cave cave;
    public Iterator<Treasure> iterator;
    public String name;
}
