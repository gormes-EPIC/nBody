## Objective
Write a program to simulate the motion of _n_ particles in the plane, mutually affected by gravitational forces, and animate the results. Such methods are widely used in cosmology, semiconductors, and fluid dynamics to study complex physical systems.
## Program specifications
- Write 2 classes, *Planet.java* and *NBody.java* that work together to simulate the rotation of the planets in the solar system in a plane
- Use the provided *StdLib* library *jar* file to animate your simulation with *StdDraw* and play music with *StdAudio*
- Write comments and generate a HTML report using Javadoc for your program
- Write another class, *NBodyTest.java*, which implements at least 5 JUnit tests to test the accuracy of your program via the command line output. These test cases should include appropriate edge cases.
### Planet.java
- Design and implement a class to represent a planet.  Use the text file below as a guide.  Be sure to have fields for all the planet data.  Include a *constructor*,  *getters and setters*, *addTo* methods for coordinates, velocity and force and a *toString* Method.   Please note, you will need to store more information than is given in the text file.
### NBody.java 
- Takes two double _arguments_—the **duration of the** **simulation (_Τ_)** and the simulation **time increment (Δ*t*).**
- Reads in the details of the universe to be simulated from _a text file_ and stores the information in an _array of Planet objects_.  (see above)
- Simulates the universe, starting at time _t_ = 0.0, and continuing in Δ_t_ increments as long as _time t_ < _Τ(duration)_, using the _leapfrog scheme_ described below.
- Animates the results to _standard drawing_ using StdDraw. (The StdLib jar will be provided)
- Output the final state of your planets.
### Input Format
The input format for the planets is a text file that contains the information for a particular universe (in SI units).
- The first value is an integer _n_ which represents the number of particles. The second value is a real number _radius_ which represents the radius of the universe; it is used to determine the scaling of the drawing window (which displays particles with _x_- and _y_-coordinates between −*radius* and +_radius_).
- Next, there are _n_ lines (one for each particle), with each line containing 6 values. The first two values are the _x_- and _y_-coordinates of the initial position; the next pair of values are the _x_- and _y_-components of the initial velocity; the fifth value is the mass; the last value is a String that is the name of an image file used to display the particle.
- As an example, *planets.txt* contains real data from part of our Solar System.
  ![[Pasted image 20230821182602.png]]
## Approach
### Simulating the universe: the physics
We review the equations governing the motion of the particles, according to Newton's laws of motion and gravitation. Don't worry if your physics is a bit rusty; all of the necessary formulas are included below.  The position (_px, py_) and velocity (_vx, vy_) of each particle is known (initial values are in the text file). In order to model the dynamics of the system, we must find the **net force** exerted on each particle.
- **Pairwise force.** _Newton's law of universal gravitation_ asserts that the strength of the gravitational force between **two particles** is given by the product of their masses divided by the square of the distance between them, scaled by the gravitational constant _G_ (6.67 × 10−11 N·m2·kg−2). The pull of one particle towards another acts on the line between them. Since we are using Cartesian coordinates to represent the position of a particle, it is convenient to break up the force into its _x_- and _y_-components (_Fx, Fy_) as illustrated below.
  ![[Pasted image 20230821182636.png]]
- **Net force.** The _principle of superposition_ says that the net force acting on a particle in the _x_- or _y_-direction is **the sum of the pairwise forces** acting on the particle in that direction.
- **Acceleration.** _Newton's second law of motion_ postulates that the accelerations in the _x_- and _y_-directions are given by: **_ax = Fx / m, ay = Fy / m_.**
- **Simulating the universe: the numerics.**  We use the _leapfrog finite difference approximation scheme_ to numerically integrate the above equations: this is the basis for most astrophysical simulations of gravitational systems. In the leapfrog scheme, we discretize time, and update the time variable _t_ in increments of the _time quantum_ Δ_t_ (measured in seconds). We maintain the position (_px_, _py_) and velocity (_vx_, _vy_) of each particle at each time step. The steps below illustrate how to evolve the positions and velocities of the particles.

## Getting Started
1. **Step A (calculate the forces).**  For each particle (planet), calculate the net force (_Fx, Fy_) at the current time _t_ acting on that particle using Newton's law of gravitation and the principle of superposition. Note that force is a vector (i.e., it has direction). In particular, Δ*x* and Δ*y* are signed (positive or negative). In the diagram above, when you compute the force the sun exerts on the earth, the sun is pulling the earth up (Δ*y* positive) and to the right (Δ*x* positive).
2. **Step B (update the velocities and positions).**  For each particle:
    1. Calculate its acceleration (_ax, ay_) at time _t_ using the net force computed in Step A and Newton's second law of motion: _ax = Fx / m, ay = Fy / m_.
    2. Calculate its new velocity (_vx, vy_) at the next time step by using the acceleration computed in (i) and the velocity from the old time step: Assuming the acceleration remains constant in this interval, the new velocity is (_vx_ + Δ*t* _ax_, _vy_ + Δ*t* _ay_).
    3. Calculate its new position (_px, py_) at time _t_ + Δt by using the velocity computed in (ii) and its old position at time _t_: Assuming the velocity remains constant in this interval, the new position is (_px_+ Δ*t* _vx_, _py_ + Δ*t* _vy_).
3. **Step C (draw the universe).**  Draw each particle, using the position computed in Step B.

Do not interleave steps A and B; otherwise, you will be computing the forces at time _t_ using the positions of some of the particles at time _t_ and others at time _t_ + Δ*t*. The simulation is more accurate when Δ*t* is very small, but this comes at the price of more computation.

## Creating an animation
Draw each particle at its current position to standard drawing, and repeat this process at each time step until the designated stopping time. By displaying this sequence of snapshots (or frames) in rapid succession, you will create the illusion of movement. After each time step, draw the background image star.jpg; redraw all the particles in their new positions; and control the animation speed (about 40 frames per second looks good). You will call several methods from the [StdDraw](http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) library.

For a finishing touch, play the theme to _2001: A Space Odyssey_ using the [StdAudio](http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdAudio.html) library and the audio file 2001.wav. It's a one-liner using the method StdAudio.play().

## Getting started
Before you begin coding, do the following:
- Make a plan for each of your classes!
- Get familiar with the standard libraries. To use the standard libraries, you need to have [stdlib.jar](http://introcs.cs.princeton.edu/java/stdlib/stdlib.jar) available. The standard libraries include [StdDraw](http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) (for drawing results to standard drawing), and [StdAudio](http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdAudio.html) (for sending sound to standard audio). The [Java cheatsheet](http://introcs.cs.princeton.edu/java/11cheatsheet/#stdlib) has a compact summary of these APIs.
- Download the project starter from GitHub Classroom
- Make sure *stdlib*, *Javadoc*, and *JUnit* are all installed and imported correctly
- If you need more help check out the PrincetonResources.pdf  It includes lots of intermediate data values and helpful hints for debugging.

## **Compiling and executing your program**
To compile your program from the _command line_, type the following in your embedded terminal:
```
javac NBody.java
```

To execute your program from the _command line_, redirecting the file `planets.txt` to standard input, type:
```
java NBody 157788000.0 25000.0 < planets.txt
```

After the animation stops, your program must output the final state of the universe in the same format as the input.

## **Testing Output**
Here are the results for a few sample inputs.
```highlight
java NBody 0.0 25000.0 < planets.txt           ## zero steps
5
2.50e+11
 1.4960e+11  0.0000e+00  0.0000e+00  2.9800e+04  5.9740e+24    earth.gif
 2.2790e+11  0.0000e+00  0.0000e+00  2.4100e+04  6.4190e+23     mars.gif
 5.7900e+10  0.0000e+00  0.0000e+00  4.7900e+04  3.3020e+23  mercury.gif
 0.0000e+00  0.0000e+00  0.0000e+00  0.0000e+00  1.9890e+30      sun.gif
 1.0820e+11  0.0000e+00  0.0000e+00  3.5000e+04  4.8690e+24    venus.gif
```

```highlight
java NBody 25000.0 25000.0 < planets.txt       ## one step
5
2.50e+11
 1.4960e+11  7.4500e+08 -1.4820e+02  2.9800e+04  5.9740e+24    earth.gif
 2.2790e+11  6.0250e+08 -6.3860e+01  2.4100e+04  6.4190e+23     mars.gif
 5.7875e+10  1.1975e+09 -9.8933e+02  4.7900e+04  3.3020e+23  mercury.gif
 3.3087e+01  0.0000e+00  1.3235e-03  0.0000e+00  1.9890e+30      sun.gif
 1.0819e+11  8.7500e+08 -2.8329e+02  3.5000e+04  4.8690e+24    venus.gif
```

```highlight
java NBody 50000.0 25000.0 < planets.txt       ## two steps
5
2.50e+11
 1.4959e+11  1.4900e+09 -2.9640e+02  2.9799e+04  5.9740e+24    earth.gif
 2.2790e+11  1.2050e+09 -1.2772e+02  2.4100e+04  6.4190e+23     mars.gif
 5.7826e+10  2.3945e+09 -1.9789e+03  4.7880e+04  3.3020e+23  mercury.gif
 9.9262e+01  2.8198e-01  2.6470e-03  1.1279e-05  1.9890e+30      sun.gif
 1.0818e+11  1.7499e+09 -5.6660e+02  3.4998e+04  4.8690e+24    venus.gif
```

```highlight
java NBody 60000.0 25000.0 < planets.txt       ## three steps
5
2.50e+11
 1.4958e+11  2.2349e+09 -4.4460e+02  2.9798e+04  5.9740e+24    earth.gif
 2.2789e+11  1.8075e+09 -1.9158e+02  2.4099e+04  6.4190e+23     mars.gif
 5.7752e+10  3.5905e+09 -2.9682e+03  4.7839e+04  3.3020e+23  mercury.gif
 1.9852e+02  1.1280e+00  3.9705e-03  3.3841e-05  1.9890e+30      sun.gif
 1.0816e+11  2.6248e+09 -8.4989e+02  3.4993e+04  4.8690e+24    venus.gif
```

```highlight
java NBody 31557600.0 25000.0 < planets.txt    ## one year
5
2.50e+11
 1.4959e+11 -1.6531e+09  3.2949e+02  2.9798e+04  5.9740e+24    earth.gif
-2.2153e+11 -4.9263e+10  5.1805e+03 -2.3640e+04  6.4190e+23     mars.gif
 3.4771e+10  4.5752e+10 -3.8269e+04  2.9415e+04  3.3020e+23  mercury.gif
 5.9426e+05  6.2357e+06 -5.8569e-02  1.6285e-01  1.9890e+30      sun.gif
-7.3731e+10 -7.9391e+10  2.5433e+04 -2.3973e+04  4.8690e+24    venus.gif
```

```highlight
# this test should take only a few seconds
# 4.294E9 is bigger than the largest int
java-introcs NBody 4.294E9 2.147E9 < 3body.txt
3
1.25e+11
 2.1470e+12 -7.8082e-03  5.0000e+02 -3.6368e-12  5.9740e+24    earth.gif
 1.2882e+14 -1.5100e+17  3.0000e+04 -3.5165e+07  1.9890e+30      sun.gif
-1.2882e+14  1.5100e+17 -3.0000e+04  3.5165e+07  1.9890e+30      sun.gif
```

## JUnit Testing
JUnit testing is a framework that allows you to *unit test* small segments of your code. JUnit is one of if not the most popular testing framework because it is open-source, provides annotations, provides test runners, provides assertions, and automates test running. JUnit also uses flags just like Javadoc so you'll see similar syntax like *@Test*

These links should help you learn how to use JUnit.
- [User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [API](https://junit.org/junit5/docs/current/api/)
- [GitHub](https://github.com/junit-team/junit5/)

Tutorials
- [SimpleLearn](https://www.simplilearn.com/tutorials/java-tutorial/what-is-junit)
- [TutorialsPoint](https://www.tutorialspoint.com/junit/junit_test_framework.htm)
- [Headspin](https://www.headspin.io/blog/junit-a-complete-guide)
## Deliverables
- 2 classes, *Planet.java* and *NBody.java*, as described above
- A class, *NBodyTest.java,* to implement at least 5 JUnit Tests
- A Javadoc generated API in an .HTML file

#### Sources
_Copyright © 1999–2010,_ [_Robert Sedgewick_](http://www.cs.princeton.edu/~rs/) _and_ [_Kevin Wayne_](http://www.cs.princeton.edu/~wayne)_._
https://www.cs.princeton.edu/courses/archive/fall23/cos126/assignments/

