package jfx.GameStructure;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JFXGameStructure extends Application {

    final double GAME_WIDTH = 800, GAME_HEIGHT = 600;

    /**
     * Start Game Application
     * @param gameStage creates stage to place a scene on for
     *                  game rendering.
     */
    public void start(Stage gameStage) {
        gameStage.setTitle("[GAME TITLE]");
        gameStage.setWidth(GAME_WIDTH);
        gameStage.setHeight(GAME_HEIGHT);

        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot);
        gameStage.setScene(gameScene);

        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        gameRoot.getChildren().add(canvas);

        gameStage.show();

        runGame(canvas);
    }

    /**
     * Starts the Game Loop
     * Calculates elapsed time to be used for updates 'tick'
     */
    public void runGame(Canvas gameCanvas) {

        final long startNanoTime = System.nanoTime();
        GraphicsContext graphCon = gameCanvas.getGraphicsContext2D();

        //RUN GAME LOOP
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double tick = (currentNanoTime - startNanoTime) / 1000000000.0;

                updateGame(tick);
                renderGame(graphCon);
            }
        }.start();
    }

    /**
     * Update sprites, game events, environment.
     * @param tick used for movement updates in sprites.
     */
    public void updateGame(double tick) {

    }

    /**
     * Render Sprites, Environment, and other Image Data
     * @param graphCon GraphicsContext for rendering game images, backgrounds
     *                 and other game drawing.
     * Default - Black Rectangle "Working"
     */
    public void renderGame(GraphicsContext graphCon) {
        graphCon.setFill(Color.BLACK);
        graphCon.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);

        //[DO DRAWING HERE]
    }

    public static void main(String[] args) {
        launch(args);
    }
}
