# Stats on tabletop games

It is common for tabletop games to give a representation of the characters as a series of numerical statistics, linked to the mechanics of the game.

These are those values you see in the character sheet, such as the strength and the constitution you noted on their small boxes. But also those other less direct values, such as the hitpoints that you have to recalculate each time those two attributes change.

Or the points you have to distribute during character creation, or the unit's valoration in a wargame, or the skills tree.

---

## What is this library for?

As part of the Tabletop Toolkits project, this library is used to represent the stats, attributes and skills used on tabletop games.

Not all the cases are covered here, actually it is encouraged to avoid most of these classes in favor of simple integers as much as possible.

If you are going to use this library, it will be for the most complex cases, such as handling skills, or values with dependencies, like derived attributes.

## An overview

A series of small patterns for representing tabletop statistics are included on this library, such as:

- [Event-based observable wrappers for values][valuebox], so dependencies and derived values can be built.
- [A controller for editing said wrappers through an UI][valuecontroller].
- Skills.

[valuebox]: ./valuebox.html
[valuecontroller]: ./valuecontroller.html