# ConsoleTetris
Just a console tetris project. My second one, but the first one I'm doing (mainly) myself. I think this was a good entry point. I could've done more, but that'd serve no learning purpose.

How the game works: 

Shapes, when called, only set a booleans onto CurrentField. Then noone cares, what those booleans are, they are just.. booleans. That's why adding shapes to the game is relatively easy.
(althought there are only 2), but anyway.
And these booleans, they are checked for collision and lowered each step.

There is a bit of multithreading as well, it registers the button which the player pressed
Don't forget to press Enter after each button!

The project could've been organized better, like my mentor Myron has pointed out. I'll try better next time.
