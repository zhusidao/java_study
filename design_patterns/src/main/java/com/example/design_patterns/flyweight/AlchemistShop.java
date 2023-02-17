/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.design_patterns.flyweight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 炼金术士商店
 * AlchemistShop holds potions on its shelves. It uses PotionFactory to provide the potions.
 */
public class AlchemistShop {


    private final List<Potion> topShelf;
    private final List<Potion> bottomShelf;

    /**
     * Constructor.
     */
    public AlchemistShop() {
        PotionFactory factory = new PotionFactory();
        topShelf = Arrays.asList(
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.HEALING)
        );
        bottomShelf = Arrays.asList(
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.HOLY_WATER),
                factory.createPotion(PotionType.HOLY_WATER)
        );
    }

    /**
     * Get a read-only list of all the items on the top shelf.
     *
     * @return The top shelf potions
     */
    public final List<Potion> getTopShelf() {
        return Arrays.asList(this.topShelf.toArray(new Potion[0]));
    }

    /**
     * Get a read-only list of all the items on the bottom shelf.
     *
     * @return The bottom shelf potions
     */
    public final List<Potion> getBottomShelf() {
        return Arrays.asList(this.topShelf.toArray(new Potion[0]));
    }

    /**
     * Enumerate potions.
     */
    public void enumerate() {
        System.out.println("Enumerating top shelf potions\n");
        topShelf.forEach(Potion::drink);
        System.out.println("Enumerating bottom shelf potions\n");
        bottomShelf.forEach(Potion::drink);
    }
}
