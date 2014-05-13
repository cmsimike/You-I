# You I
A space exploration game

### Goals 
1. Explore space, obv. Because, who doesn't?
2. Give players an idea of how long space travel takes.
3. The game basically plays itself. You program units to do missions and they do that. With space travel taking so long, it wouldn't make sense to have manned space ships. (Thanks @notch for the idea!)
4. The game plays even if it is off. The last thing I wanted is to have the user sit around and wait around for ships to find new planets. (more on that in the technology section
5. Awesome upgrade system. Do small time missions to get science and mine planets for resources to UPGRAYDD.
6. Sci fi - The point I want ot get to in the game is that, without more research into the space program that it will be impossible to go anywhere in the solar system, let alone anything else. So I want getting upgraded parts to mean that you can go out further, faster and what not.
7. Tons of different space units - different types of ships, satalites to aid in communication and monitoring of locations of things. 
8. I want transmission of new instructions to space units to take time.
9. MAYBE planets and stars that form over time if i can scale it correctly?
10. You are sitting in NASA-type room monitoring all your space ships. Maybe, as an upgrade through the game, we expose the openGL portion of it again as relays from space.

The game, based on orbit time, scales in game day to one real life minute. So setting Mercury to have a rotational period of 88 days means it will take 88 seconds in real life.

I am using long to store coordinates of the entire universe in km. At the scales i'm talking about, km is granular enough I think.

I'm not married to any of the current values for anything.

### What's currently working
1. A basic idea of a unit in the universe, from each everything else is derrived.
2. A Star and Ship that don't currently do anything. A planet that orbits a sun in N days.
3. A very very raw graphics engine because, well, seeing a planet orbit is exciting. Seeing 232737823,187391312 isn't.


### Keys
1. Up/down/left/right - move the view port to see more of th solar system.
2. [ and ] - zoom in and out. Basically useless at the scales i'm talking about now.
3. e - center and scale around earth and start tracking. You can zoom out and see the moon. You will not be able to move around anymore though.


### Technology
1. Game time progression - Since the game is currently based on millisecond deltas, we can save the System.currentTimeMillis to the save file and, on load, if we detect a save is there, run the simulation for that much time.
2. Since the scale we're talking about here is Long.MIN_LONG to Long.MAX_LONG in x and y (in km), the only way anything like sensors on ships and satalights seems to make any sense is with an implementation of a spaical index. A really quick search lead me http://jsi.sourceforge.net/


### To run:
1. Java 8 won't work because how I'm loading native libraries out of the classpath. Use Java 7.
2. Maven
3. git clone the repo. cd into it. maven package. java -jar target/BLAHBLAHBL.jar

### To dev:
Load the POM file up in any useful Java IDE. All of the requirements are taken care of through maven.
