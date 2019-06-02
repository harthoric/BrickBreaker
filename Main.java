package com.harthoric.brickbreaker;

public class Main extends Application {

  public static Board board;
	private KeyHandler keyHandler;

  public static void main(String args[]) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    board = new Board();
		keyHandler = new KeyHandler();

		primaryStage.setResizable(false);
		primaryStage.setTitle("BrickBreak!");
		primaryStage.setOnCloseRequest(e -> System.exit(0));
		primaryStage.setScene(board.getScene());
		primaryStage.show();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				keyHandler.checkKeys();
				board.update();
			}
		};

		timer.start();
  }

}
