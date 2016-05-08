/**
 * Copyright 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.stats.test.integration.valuecontroller;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.controller.DefaultValueController;
import com.wandrell.tabletop.stats.controller.ValueController;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Integration test for {@link DefaultValueController}, checking that the
 * contained {@code ValueBox} is updated correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The {@code ValueBox} is increased when it is possible to increase.</li>
 * <li>The {@code ValueBox} is not modified when the value is at the upper
 * limit.</li>
 * <li>The {@code ValueBox} is not modified when the value is over the upper
 * limit.</li>
 * <li>The {@code ValueBox} is decreased when it is possible to decrease.</li>
 * <li>The {@code ValueBox} is not modified when the value is at the lower
 * limit.</li>
 * <li>The {@code ValueBox} is not modified when the value is under the lower
 * limit.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITDefaultValueController {

    /**
     * Default constructor.
     */
    public ITDefaultValueController() {
        super();
    }

    /**
     * Tests that the {@code ValueBox} is decreased when it is possible to
     * decrease.
     */
    @Test
    public final void testDecrease_Able() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(-10, Integer.MAX_VALUE);

        controller.decreaseValue();
        Assert.assertEquals((Integer) 0, box.getValue());
    }

    /**
     * Tests that the {@code ValueBox} is not modified when the value is at the
     * lower limit.
     */
    @Test
    public final void testDecrease_Unable_AtLimit() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(1, Integer.MAX_VALUE);

        controller.decreaseValue();
        Assert.assertEquals((Integer) 1, box.getValue());
    }

    /**
     * Tests that the {@code ValueBox} is not modified when the value is under
     * the lower limit.
     */
    @Test
    public final void testDecrease_Unable_UnderLimit() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(5, Integer.MAX_VALUE);

        controller.decreaseValue();
        Assert.assertEquals((Integer) 1, box.getValue());
    }

    /**
     * Tests that the {@code ValueBox} is increased when it is possible to
     * increase.
     */
    @Test
    public final void testIncrease_Able() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(Integer.MIN_VALUE, 10);

        controller.increaseValue();
        Assert.assertEquals((Integer) 2, box.getValue());
    }

    /**
     * Tests that the {@code ValueBox} is not modified when the value is at the
     * upper limit.
     */
    @Test
    public final void testIncrease_Unable_AtLimit() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(Integer.MIN_VALUE, 1);

        controller.increaseValue();
        Assert.assertEquals((Integer) 1, box.getValue());
    }

    /**
     * Tests that the {@code ValueBox} is not modified when the value is over
     * the upper limit.
     */
    @Test
    public final void testIncrease_Unable_OverLimit() {
        final ValueController controller; // The tested controller
        final ValueBox box;               // The contained value box

        box = new DefaultValueBox(1);

        controller = new DefaultValueController(box);
        controller.setInterval(Integer.MIN_VALUE, 1);

        controller.increaseValue();
        Assert.assertEquals((Integer) 1, box.getValue());
    }

}