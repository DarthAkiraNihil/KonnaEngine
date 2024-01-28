package org.konna.engine.common;

/**
 * <h1>KEntity class</h1>
 * <p>An abstract class that contains common values of any entity
 * such as Player, NPC, Enemy etc.</p>
 * <h2>Class fields</h2>
 * <ul>
 *    <li>name [String type]</li>
 *    <li>species [Species type]</li>
 * </ul>
 * @see org.konna.engine.common.KSpecies;
 */
public abstract class KEntity {
    private String name;
    private KSpecies species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KSpecies getSpecies() {
        return species;
    }

    public void setSpecies(KSpecies species) {
        this.species = species;
    }
}
