I think of ATS being broken up into 
syntaxtic glue
sort declaations, sorts, 
type declarations, types, 
term declarations, terms

these should all be highlighted fdifferently

It's not clear where costum fixity falls into this model, also macros




Current plan, roughly aproximate the lexer and the parser(?) from the ATS compiler.
Can then aproximate anylisis in the IDE.

Next step: run everything through the full jsonize, mock a fake lexer out of it.  but will need to find a way to deal with partyly incorrect files (we could fall back to the jflex)


Long term: use the ats source to run faithful ats functions and generate kotlin algebriaic data types
this will ensure a more exact representation.



  
auto commenter annoyingly jumps lines
* this seems standard (the java plugin does it) perhaps there is a global setting that handles that somewhere

integrating with the clion pugin would be ideal, but it hasn't been released yet
* https://intellij-support.jetbrains.com/hc/en-us/articles/206558629-Is-there-a-community-edition-for-CLion-Is-CLion-available-as-a-plugin-for-IntelliJ-IDEA-
* when clion is usable linking to the emmitted comments is possible (ideally collaps the comments and then link the actual generated line)

/*
emit_instr: loc0 = /cygdrive/c/Users/Mark/IdeaProjectsgit/cs320-2017-summer/lectures/lecture-05-23/hello.dats: 106(line=16, offs=1) -- 151(line=17, offs=35)
*/


the lexer goes (pats_lexing.sats) undergoes frequent enough changes that some more direct way to test should be employed.  prehaps checkout the the file and jsonized and then staticly confirm it is accurite 

It would be good to start a convention such that generated files go into a "gen" directory and exicutables go to a "build" directory

Intellij is less agressive about showing inferred types?  how does the scala plugin handle this?