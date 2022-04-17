@COPYRIGHT 2022 Bubatu Claudiu-Mihai
Tel: 0746025009
Email: claudiububatu@yahoo.com
-------------------------------------------------------------------------------

HR APP - Backend

-------------------------------------------------------------------------------

  The project was realised in Java programming language.

  The content of the project is:
- classes: Main, Director, Employee, Manager, SalaryHistory, Team, Firm
- abstract class: Actions
- interfaces: Visitable, Visitor

  They have been written in an OOP manner, using the Visitor design pattern
and other characteristics of this paradigm of programming. This way, I succeded
to build a platform that can simulate an HR situation in real life.

  The flow of the program is made in the main function and it describes through
several examples the benefits of this project. It keeps the evidence over a
firm which contains multiple teams. Each team is built by employees and managers
and there are some tests that include all of what I mentioned above.
  
  The manager class inherits the employee class, so they share the getters, 
the setters and the other methods. These 2 classes are taking part of a team.

  As I mentioned before, I implemented a design pattern that is requiring a
visitor. In this case, the visitor is the director which can inspect all
the employees of the firm (including the managers) and he has for that 2
methods (the Director class implements the Visitor interface) that shows
the number of vacation days for each member.

  Beside that, he has the power to promote employees, to relegate managers,
to view the income history of a worker (manager or, simply, an employee) or
to give vacation. All these abilities consist of methods that are inherited
from an abstract class called Actions. 
   
  This project can be improved, adding to it another functionalities and
making his readability better with the help of some design patterns. I
consider it as being a starting point to a much bigger platform which
could be useful in any firm to keep the evidence of the workers inside it.