# Treino Track

Treino Track is a Java-based application designed to manage workouts and exercises. It provides a platform for both administrators and users to interact with workout plans and exercise routines.

## Features

- **Admin Module**: Allows administrators to create, edit, and delete users, workouts, and exercises. Admins can customize workout plans by configuring exercises, sets, repetitions, and intervals.
- **User Module**: Allows users to access their personalized workout plans.

## Project Structure

The project is organized into the following packages:

- `treinotrack`: Contains the main application entry point.
- `UIconsole`: Handles the console-based user interface.
- `facades`: Provides simplified interfaces for the service layer.
- `service`: Contains the business logic.
- `data`: Manages data persistence and retrieval.
- `models`: Defines the data models used in the application.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- IntelliJ IDEA or any other Java IDE

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Nertonm/treino-track.git
    ```
2. Open the project in your IDE.
3. Build the project to resolve dependencies.

### Running the Application

1. Navigate to the `src` directory.
2. Run the `Main.java` file to start the application.

### Usage

Upon starting the application, you will be prompted to enter your role (admin or user). Depending on your role, you will be directed to the appropriate module:

- **Admin**: Manage users, workouts, and exercises.
- **User**: View and follow your workout plans.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact

For any inquiries or issues, please contact.


This README provides an overview of the Treino Track project, including its features, structure, and instructions for getting started.
## UML
![uml diagram](uml.png)
