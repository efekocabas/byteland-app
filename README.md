###Byteland Unification
####Problem

Byteland is a strange country, with many cities, but with a poorly developed road network (in fact, there is exactly one route from each city to any other city, possibly leading through other cities). Until recently, the cities of Byteland were independently governed by proud Mayors, who chose not to integrate too tightly with their neighbours. However, recent opinion polls among Bytelandian computer programmers have shown a number of disturbing trends, including a sudden drop in pizza consumption. Since this had never before happened in Byteland and seemed quite inexplicable, the Mayors sought guidance of the High Council of Wise Men of Byteland. After a long period of deliberation, the Council ruled that the situation was very serious indeed: the economy was in for a long­term depression! Moreover, they claimed that tighter integration was the only way for the Bytelandian cities to survive. Whether they like it or not, the Mayors must now find a way to unite their cities as quickly as possible. However, this is not as easy as it sounds, as there are a number of important constraints which need to be fulfilled:

* Initially, each city is an independent State. The process of integration is divided into steps.
* At each step, due to the limited number of diplomatic envoys available, a State can only be involved in a unification process with at most one other state. At each step two States can unite to form a new State, but only if there exists a road directly connecting some two cities of the uniting States.
* The unification process is considered to be complete when all the cities belong to the same, global State.

The Mayors have asked you to arrange a schedule for the diplomatic talks, so that unification can be completed in as few steps as possible. Can you handle this delicate task?

####Solution
The problem was solved with choosing the city with least number of neighbours. After choosing the city, neighbour with least neighbour count is also chosen. Session continues until there is no available city. After choosing all attendants, cities are merged. New session starts afterwards. This operation ends when there is only one city left.

####How to build
Project is developed by using Maven. Simple command to make executable Jar file:
* maven clean package

####How to run
You can run the application from project-directory/target location:
* java -jar byteland-app-1.0-SNAPSHOT.jar

####Example
Welcome to Byteland Unification App!
Please enter number of test cases:
1
Please enter number of cities:
4
Please enter road map between cities separated by spaces:
0 1 2
Step count: 2