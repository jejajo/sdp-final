# SDP-final
SPD project created by Elzhanov Asanali, Alibek Matayev, Valentin Zakharov

The Train System Manager is designed to revolutionize the management of trains and passengers, aiming to streamline operations and enhance user experience. The primary purpose is to create a robust software system capable of efficiently handling various aspects of train operations, including  passenger management, ticketing, and overall system organization.

In software development, the use of design patterns is crucial for creating scalable, maintainable, and flexible systems. They serve as proven solutions to recurring design problems, enabling developers to craft software that's easier to understand, maintain, and extend. In the Train System Manager, incorporating design patterns is pivotal to achieving these goals by ensuring a structured and organized codebase that promotes reusability and scalability.

1. Singleton. In developing the Train System Manager, I strategically applied the Singleton pattern to ensure a singular control system within the program. By implementing the Singleton design pattern, I guaranteed that only one instance of the control system exists throughout the entire application's lifecycle.
2. Factory. In crafting the Train System Manager, I implemented the Factory pattern to streamline the creation process of various train types, ranging from high-speed trains to simpler models. The Factory pattern proved instrumental in providing a structured and flexible approach to instantiate different train instances while adhering to a unified creation interface.
3. Adapter. In developing the Train System Manager, I used the Adapter pattern to make my TSM printable and print information about itself.
4. Strategy. In orchestrating the Train System Manager's dynamic movement capabilities, I harnessed the power of the Strategy pattern to facilitate the alteration of train movement strategies, consequently influencing the average speed of the trains.
5. Decorator. When developing Train System Manager to serve passengers with disabilities, I implemented the Decorator pattern to easily find and provide price reductions for train travel.
6. Observer. Implementing the Observer pattern within the Train System Manager enabled efficient communication and timely notifications to all train passengers when the train comes to a stop, ensuring a prompt and organized disembarkation process.

The main objectives of the Train System Manager project include:
1. Efficient Train Management: Implementing design patterns like the Factory Method or Builder for creating different types of trains, allowing for easy expansion and modification of train types in the system.
2. Passenger Handling: Utilizing patterns like the Iterator or Observer for managing passenger lists efficiently and notifying relevant components about changes in passenger status or bookings.
3. Scheduling and Routing: Implementing patterns such as Strategy or State for flexible scheduling and routing algorithms, enabling the system to adapt to varying conditions and optimize train routes dynamically.
4. Ticketing System: Applying patterns like the Decorator or Command for a flexible and extensible ticketing system, accommodating different ticket types and modifications while ensuring a seamless user experience.
5. Scalability and Maintenance: Using design patterns like the Singleton or Adapter to ensure system scalability, maintainability, and interoperability with external systems or future enhancements.

Interface and functions:
1. Get Info about station
2. Budget
3. Send the train
4. Stop the train
5. Add new train
6. Check into the passenger to the train
7. Get Info about train
8. Quit
