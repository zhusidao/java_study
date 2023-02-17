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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PotionFactory is the Flyweight in this example. It minimizes memory use by sharing object
 * instances. It holds a map of potion instances and new potions are created only when none of the
 * type already exists.
 * 模式分类
 * 享元模式分为单存享元模式和复合享元模式
 * <p>
 * 1.可以共享的内容称为内部状态(Intrinsic State)，需要外部环境设置的不能共享的内容称为外部状态(Extrinsic State)。享元模式需要创建一个享元工厂负责维护享元池(Flyweight Pool)，享元池用于存储具有相同内部状态的享元对象。
 * <p>
 * 2.享元模式中共享的仅仅是享元对象，外部状态是需要通过环境类设置的，在实际使用中，能共享的内部状态不是很多的，所以设计享元对象是比较小的，也就是细粒度对象，所以说享元模式就是通过共享技术实现大量细粒度对象的复用
 * <p>
 * 3.创建大量对象会一定程度影响系统性能，不方便程序阅读，使用享元模式可以减少对象使用。
 * <p>
 * 单纯享元模式：在单纯享元模式中不存在非共享具体单元，所有的具体享元类对象都是可以共享的。
 * 复合享元模式：通过复合模式将单纯享元模式进行组合，形成复合享元对象
 */
public class PotionFactory {

    private final Map<PotionType, Potion> potions = new ConcurrentHashMap<>();

    Potion createPotion(PotionType type) {
        Potion potion = potions.get(type);
        if (potion == null) {
            switch (type) {
                case HEALING:
                    potion = new HealingPotion();
                    potions.put(type, potion);
                    break;
                case HOLY_WATER:
                    potion = new HolyWaterPotion();
                    potions.put(type, potion);
                    break;
                case INVISIBILITY:
                    potion = new InvisibilityPotion();
                    potions.put(type, potion);
                    break;
                case POISON:
                    potion = new PoisonPotion();
                    potions.put(type, potion);
                    break;
                case STRENGTH:
                    potion = new StrengthPotion();
                    potions.put(type, potion);
                    break;
                default:
                    break;
            }
        }
        return potion;
    }
}
