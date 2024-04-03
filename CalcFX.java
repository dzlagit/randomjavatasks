import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application { // Application class is the entry point for JavaFX applications

    private TextField display; // Display for the calculator

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) { // The start method is called when the application is launched
        primaryStage.setTitle("Calculator"); // Set the stage title

        GridPane gridPane = new GridPane(); // Create a GridPane
        gridPane.setPadding(new Insets(10)); // Set padding around the grid pane
        gridPane.setHgap(5); // Set horizontal gap between cells
        gridPane.setVgap(5); // Set vertical gap between cells
        gridPane.setStyle("-fx-background-color: blue;"); // Set background color of the grid pane

        display = new TextField(); // Create a TextField for the display
        display.setEditable(false); // Make the display read-only
        display.setPrefColumnCount(10); // Set the preferred column count
        display.setStyle("-fx-font-size: 14pt; -fx-background-color: white;"); // Set font size and background color
        gridPane.add(display, 0, 0, 4, 1); // Add the display to the grid pane

        String[] buttonLabels = { // Labels for the buttons
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C" // Clear button
        };

        int col = 0; // Column index
        int row = 1; // Row index
        for (String label : buttonLabels) { // Create buttons for each label
            Button button = new Button(label); // Create a button with the label
            button.setFont(Font.font("Arial", 14)); // Set font
            button.setStyle("-fx-font-weight: bold;"); // Set font weight
            button.setOnAction(event -> buttonClicked(label)); // Set action for the button
            setColorByLabel(button, label); // Set color based on the label
            gridPane.add(button, col, row); // Add the button to the grid pane
            col++; // Increment the column index
            if (col == 4) { // If the column index reaches 4
                col = 0; // Reset the column index
                row++; // Increment the row index
            }
        }

        ColumnConstraints colConstraints = new ColumnConstraints(); // Create column constraints
        colConstraints.setPercentWidth(25); // Set column width to 25%
        gridPane.getColumnConstraints().addAll(colConstraints, colConstraints, colConstraints, colConstraints); // Add column constraints

        RowConstraints rowConstraints = new RowConstraints(); // Create row constraints
        rowConstraints.setPercentHeight(100.0 / (row + 1)); // +1 for the display row
        for (int i = 0; i <= row; i++) { // Add row constraints
            gridPane.getRowConstraints().add(rowConstraints); // ^ 
        }

        Scene scene = new Scene(gridPane); // Create a scene with the grid pane
        primaryStage.setScene(scene); // Set the scene
        primaryStage.show(); // Display the stage
    }

    private void setColorByLabel(Button button, String label) { // Set color based on the label
        switch (label) { // Set color based on the label
            case "0": // 
                button.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
                break;
            case "1":
                button.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold;");
                break;
            case "2":
                button.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-weight: bold;");
                break;
            case "3":
                button.setStyle("-fx-background-color: orange; -fx-text-fill: black; -fx-font-weight: bold;");
                break;
            case "4":
                button.setStyle("-fx-background-color: purple; -fx-text-fill: white; -fx-font-weight: bold;");
                break;
            case "5":
                button.setStyle("-fx-background-color: pink; -fx-text-fill: black; -fx-font-weight: bold;");
                break;
            case "6":
                button.setStyle("-fx-background-color: cyan; -fx-text-fill: black; -fx-font-weight: bold;");
                break;
            case "7":
                button.setStyle("-fx-background-color: magenta; -fx-text-fill: white; -fx-font-weight: bold;");
                break;
            case "8":
                button.setStyle("-fx-background-color: brown; -fx-text-fill: white; -fx-font-weight: bold;");
                break;
            case "9":
                button.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-font-weight: bold;");
                break;
            default:
                button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;");
        }
    }

    private void buttonClicked(String label) { // Handle button click
        switch (label) { 
            case "=":
                calculate(); // Calculate the result if = is clicked
                break;
            case "C":
                display.setText(""); // Clear the display
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                display.setText(display.getText() + " " + label + " "); // Add space around the operator
                break;
            default:
                display.setText(display.getText() + label); // Append the label to the display
        }
    }

    private void calculate() { // Calculate the result of the expression in the display
        String expression = display.getText(); // Get the expression from the display
        try { // Try to evaluate the expression
            double result = evaluateExpression(expression); // Evaluate the expression
            display.setText(Double.toString(result)); // Display the result
        } catch (NumberFormatException e) { // Handle number format exception 
            display.setText("Error"); // Display error message
        }
    }

    private double evaluateExpression(String expression) { // Evaluate the expression
        String[] tokens = expression.split(" "); // Split the expression by space
        if (tokens.length != 3) { // If the length is not 3
            throw new IllegalArgumentException("Invalid expression"); // Throw an exception
        }
        double num1 = Double.parseDouble(tokens[0]); // Parse the first number
        double num2 = Double.parseDouble(tokens[2]); // Parse the second number
        switch (tokens[1]) { // Switch on the operator
            case "+": // If the operator is +
                return num1 + num2; // Return the sum
            case "-": 
                return num1 - num2; 
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero"); // Throw an exception if dividing by zero
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator"); // Throw an exception for invalid operator
        }
    }

    public static void main(String[] args) { // Main method
        launch(args); // Launch the application
    }
}
