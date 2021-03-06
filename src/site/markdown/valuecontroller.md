# ValueController

Controller for modifying a ValueBox through UI operations. And includes a few additional operations to limit this edition.

These are meant to be used on a desktop application, where there is a close proximity between the UI and the business layer.

[![ValueController class tree][value_controller-class_tree]][value_controller-class_tree]

## Interface

The [ValueController][value_controller] wraps a ValueBox, as serves as a mediator between it and the UI.

It has a few a additional methods to set the range in which the value can move. Once it reaches one of the limits, or surpasses it, the value can't be moved further in that direction.

## Implementation

A default implementation, the [DefaultValueController][default_value_controller], takes care of all of the interface's methods.

[default_value_controller]: ./apidocs/com/wandrell/tabletop/stat/valuecontroller/DefaultValueController.html
[value_controller]: ./apidocs/com/wandrell/tabletop/stat/valuecontroller/ValueController.html
[value_controller-class_tree]: ./images/valuecontroller_class_tree.png