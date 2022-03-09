import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
        draw();
        primaryStage.show();
    }

    public void draw()
    {
        gc.setFill(Color.DARKGRAY);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        gc.setFill(Color.BLUE);
        for (int i = 0; i < array.getLen(); i++)
        {
            gc.fillRect( i * canvas.getWidth() / array.getLen(), 10, canvas.getWidth() / array.getLen(), (array.getArray()[i] / (double)array.getLen()) * canvas.getHeight() * 0.75);
        }

        System.out.println(array.toString());
    }
}