# Sorting Algorithms

A comprehensive Java application that demonstrates various sorting algorithms through an interactive GUI. This educational tool allows users to explore and visualize different sorting techniques including Bubble Sort, Quick Sort, Merge Sort, Insertion Sort, and Selection Sort.

## Features

This application implements the following sorting algorithms:

### Sorting Algorithms
- **Bubble Sort**: A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
- **Quick Sort**: An efficient divide-and-conquer sorting algorithm that works by selecting a 'pivot' element and partitioning the array around the pivot.
- **Merge Sort**: A divide-and-conquer algorithm that divides the input array into two halves, recursively sorts them, and then merges the sorted halves.
- **Insertion Sort**: A simple sorting algorithm that builds the final sorted array one item at a time, similar to how people sort playing cards.
- **Selection Sort**: A simple comparison-based algorithm that divides the input list into a sorted and an unsorted region, and repeatedly selects the smallest element from the unsorted region and moves it to the sorted region.

## Project Structure

The project follows the Model-View-Controller (MVC) architecture pattern:

- **Model**: Contains the data structures and algorithms implementation.
  - Various algorithm-specific models for implementing the sorting logic.

- **View**: Contains the GUI components.
  - `MainView.java`: The main application window with buttons for each sorting algorithm.
  - `VentanaBubbleSort.java`: View for Bubble Sort visualization.
  - `VentanaQS.java`: View for Quick Sort visualization.
  - `VentanaMerge.java`: View for Merge Sort visualization.
  - `InsertionMenu.java`: View for Insertion Sort visualization.
  - `SelectionMenu.java`: View for Selection Sort visualization.

- **Controller**: Contains the logic that connects the models and views.
  - `MainController.java`: Manages navigation between main views.
  - `BubbleSortController.java`: Controller for Bubble Sort.
  - `ControladorQS.java`: Controller for Quick Sort.
  - `MergeController.java`: Controller for Merge Sort.
  - `InsertionMenuController.java`: Controller for Insertion Sort.
  - `SelectionMenuController.java`: Controller for Selection Sort.

- **Utilities**: Contains data files used for testing and demonstrating the algorithms.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Java Swing (included in JDK)

## How to Run

1. Clone or download this repository.
2. Open the project in your preferred Java IDE (Eclipse, IntelliJ IDEA, etc.).
3. Build the project.
4. Run the `Main.java` file.

Alternatively, you can run the compiled JAR file (if available) using:

```
java -jar sorting_algorithms.jar
```

## Usage

1. Launch the application.
2. From the main menu, select one of the five sorting algorithms:
   - **Bubble Sort**
   - **Quick Sort**
   - **Merge Sort**
   - **Insertion Sort**
   - **Selection Sort**
3. Follow the on-screen instructions to interact with the selected algorithm visualization.
4. Use the "Volver al Menú Principal" (Return to Main Menu) button to go back to the main menu.

## Author

Daniel Velandia (Student ID: 20191020140)

## License

This project is for educational purposes. All rights reserved.
