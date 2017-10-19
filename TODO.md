* get myatscc to compile on cygwin without errors

* run button!
    * compile run button in the context menu of the files (could analyze when it has a main)
    * make the ats executable configurable

* merge with official IDE
* publish to the official jetbrains repo

* doesn't support syntax highlighting for %{
                                          // ...
                                          %} blocks

* comments
    * multiline (* *) style comments not being properly highlighted
    * /* */ not working
    * Bug: (* *) style comments should nest
    * TODO: a test of all the ways comments and string literals can nest

* identifiers like "list0_length(xs)-2-helper" incorrectly highlight the number 2
* identifiers like xs' misparse in |cons0(x, xs') => let as a tuple

* make package names match the official ATS website
    
* parser to support the syntax of the intro class we have reached

* make the hardcoded commandline calls configurable in the UI (see the makefile plugin)


* typedef, datatype, dataprop should have syntax coloring
* make sure sort constructors, type constructors, and term constructors can get different coloring (color them different by default)

* will probly need to rely on the lexer/internal prarser for friendly errors, the compiler warnings are not great for those

* go through old course repo and make sure at least there are no errors there



* TODO: add support for cats

"jsonize as lexer" (?)


make sure "associate with file type" works correctly


* icons for the different file types, also higher resolution versions
---


* how Faithful is the BNF? not really.
* project structure
* ATS what is the getCharset?
* can we get at the ATS lexer, parser, type checker?
* find another plugin that must call out to the command line...
* com.intellij.psi.PsiNamedElement

* formalize ATS enhancements
  * separate language enhancements from IDE enhancements
  * review the wrapper around the compiler
* build a corpus of all valid ATS code on the latest version
* if we are using code generation the code needs to be part of the build process. Java code generators are very brittle


Low priority:
* Live Templates
* annotators for ATS? the polygolt interop could be good for ATS, like this method called ats or something
* build numbers http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/build_number_ranges.html
* someday the plugin itself could be written in ATS
