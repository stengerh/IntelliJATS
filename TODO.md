* generate jflex and bnf through the build system. (and in the correct directories)
  * https://github.com/jprante/gradle-plugin-jflex
  * what does the BNF project?

* standardize the new line encoding

* icons for the different file types, also higher resolution versions
---
* check out kotlin


* how Faithful is the BNF? not really.
* project structure
* ATS what is the getCharset?
* can we get at the ATS lexer, parser, type checker?
* find another plugin that must call out to the command line...
* com.intellij.psi.PsiNamedElement

* formalize ATS enhancements
  * seperate language enhancements from IDE enhancements
  * review the wrapper around the compiler
* build a corpus of all valid ATS code on the latest version
* if we are using code generation the code needs to be part of the build process. Java code generators are very brittle


Low priority:
* Live Templates
* annotators for ATS? the polygolt interop could be good for ATS, like this method called ats or somethong
* build numbers http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/build_number_ranges.html
* someday the plugin itself could be written in ATS
