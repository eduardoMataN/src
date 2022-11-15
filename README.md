# __Search for Room Scheduling__
## __Programming Assignment #2__
### Due: Monday, Novemeber 14th, 2022 at 11:59pm
---
___By: Brianna Tovar, Eduardo E. Mata, and Alejandra Maciel___
<br>

The goal for this assignment is to create an algorithm that assigns courses to classrooms while finding the best possible schedule as quickly as it can using multiple search techniques. 

To achieve this, M courses have to be scheduled throughout N rooms in L buildings. A room pertaining to a building and having a maximum capacity. And a course having an enrollment number, 10 available time slots (weighted), a preferred building, and a value for being scheduled. 

The team used Simulated Annealing and a Genetic Algorithm;search 1 and 2 respectively.

---
## __How To Run:__
1. Download all the files provided and store within the same forlder in your directory. 
2. Open the command line or terminal and access the directory where the files are. 
3. Use the following command to run the provided test case:

```
javac Main.java
java Main L_buildings N_rooms M_courses time_limit_secs alg_number ran_seed
```
*`L_buildings`* number of buildings.

*`N_rooms`* number of rooms.

*`M_courses`* number of courses being scheduled.

*`time_limit_secs`* time limit for algorithm.

*`alg_number`* 1 for Simulated Annealing and 2 for Generic Algorithm.

*`ran_seed`* random seed being used for generator.

---

> *Note*: Java JDK must be installed in the computer before running the code.