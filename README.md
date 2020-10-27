## BearMaps

#### Demo: https://bearmaps1.herokuapp.com/

An interactive map web app with functions of rastering, labeling, auto-completion and navigation. Implement Heap, Trie, K-D Tree and A\* search from scratch in Java to learn object-oriented programming. The frontend is developed with jQuery.

- [x] Test with JUnit
- [x] Built by Maven
- [x] Deployed on Heroku

### Usage

`mvn install` Build the whole project

`mvn test` Run unit tests

Note that the process of building artifact is skipped for deployment efficiency. Comment out line 82 and 90–92 in `pom.xml` to enable it; then `mvn install` will generate an executable JAR, which can run locally.

### Acknowledgements

Adapted from a project (mainly proj2c) in UC Berkeley CS 61B Data Structures, Spring 2019, taught by Josh Hug.

My solutions for other projects, labs and homework in this course can be found at https://github.com/ybhan/CS61B-sp19.
