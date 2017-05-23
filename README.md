IntelliJATS
===========

An ATS Plugin for IntelliJ IDEA.

![Image of IntelliJATS](http://i.imgur.com/sfqAJcG.png)

## Current Features
* Complete JFlex lexer based on the ATS2 lexer definition
* Customizable syntax highlighting
* Building ATS programs (with the [makefile support plugin](https://plugins.jetbrains.com/plugin/9333-makefile-support))
* An icon for the various ATS files

## Important Notes for Development

This project is now build using gradle.  Intellij has very good gradle support.

To experiment wih the plugin from sources run

```
$ gradle runIde
```
(warning it will download an entire development copy of IntelliJ, this can be very large)

To regenerate the lexer and parser run

```
$ gradle generateATSLexer
$ gradle generateATSParser
```