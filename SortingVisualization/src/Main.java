import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application
{
    /*
    Visualization Of Many Sorting Algorithms
    By: Sam Lu
    */

    private SortArray array;

    private Group group;
    private Canvas canvas;
    private Scene scene;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Visualization Of Many Sorting Algorithms");
        array = new SortArray(1000);
        group = new Group();
        canvas = new Canvas(1920, 1080); // Standard Resolution
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        group.getChildren().add(canvas);
        scene.setFill(Color.DARKGRAY);
        primaryStage.setScene(scene);



        ArrayList <Button> buttons = new ArrayList<>();
        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setLayoutX(100);
        shuffleButton.setLayoutY(800);
        shuffleButton.setPrefSize(100, 100);
        shuffleButton.setOpacity(0);

        buttons.add(shuffleButton);

        EventHandler<ActionEvent> buttonEvent = event ->
        {
            Button button = ((Button) event.getSource());
        };

        new AnimationTimer()
        {
            public void handle(long currentTime)
            {
                buttonEvent(buttons,buttonEvent);
            }
        }.start();

        draw();
        primaryStage.show();
    }

    public void draw()
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        for (int i = 0; i < array.getLen(); i++)
        {
            // gc.setStroke(Color.BLACK);
            gc.setFill(Color.WHITE);
            // gc.strokeRect( i * canvas.getWidth() / array.getLen(), 10, canvas.getWidth() / array.getLen(), (array.getArray()[i] / (double)array.getLen()) * canvas.getHeight() * 0.75);
            gc.fillRect( i * canvas.getWidth() / array.getLen(), 0, canvas.getWidth() / array.getLen(), (array.getArray()[i] / (double)array.getLen()) * canvas.getHeight() * 0.75);

        }
        gc.fillRect(100,800,100,100);
        System.out.println(array.toString());
    }

    public void buttonEvent(ArrayList<Button> buttons, EventHandler<ActionEvent> buttonEvent)
    {
        for (Button button : buttons)
        {
            button.setOnMouseReleased(mouseEvent ->
            {
                if (mouseEvent.getButton() == MouseButton.PRIMARY)
                {
                    if (button.getText().equals("Face"))
                    {
                        array = new SortArray(array.getLen());
                        System.out.println("Button Works");
                    }
                }
                draw();
            });
            button.setOnAction(buttonEvent);
        }
    }
}