package com.harthoric.brickbreaker.board;

public class Board {

  public static final int WIDTH = 600, HEIGHT = 400;
	public static final Color colours[] = new Color[] { Color.DARKGRAY, Color.DIMGRAY, Color.GRAY, Color.WHITE, Color.DARKRED,
			Color.DARKGOLDENROD };
	public static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

	private Canvas canvas;
	private StackPane root;
	private Scene scene;

	private BrickLoader brickLoader;
	private static Player player;
	private static Ball ball;

	Text lifeCounter;
	Rectangle leftBorder, rightBorder;

  public Board() {
    canvas = new Canvas(WIDTH, HEIGHT);
		canvas.setFocusTraversable(true);
		root = new StackPane();
		root.setStyle("-fx-background-color: black");
		player = new Player(0, HEIGHT / 2 - 20, 5);
		ball = new Ball(1.005f, new Vector2D(-2.0f * 1.22f, 2.35f * 1.22f), new Vector2D(0, HEIGHT / 2 - 50), new Circle(5, Color.DARKRED));
		brickLoader = new BrickLoader(5, 10, 40, 40, false);
		setupBorders();
		setupScore();
		addRootChild(canvas, brickLoader.getBrickGroup(), ball.ball, player.player, lifeCounter, leftBorder, rightBorder);
		scene = new Scene(root);
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
		scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
  }

  private void setupBorders() {
		lifeCounter = new Text(String.valueOf(player.getLives()) + " 💕");
		leftBorder = new Rectangle(40, HEIGHT-30, Color.DARKGOLDENROD);
		leftBorder.setTranslateX(-WIDTH/2);
		leftBorder.setStroke(Color.WHITE);
		rightBorder = new Rectangle(40, HEIGHT-30, Color.DARKGOLDENROD);
		rightBorder.setTranslateX(WIDTH/2);
		rightBorder.setStroke(Color.WHITE);
	}

	private void setupScore() {
		lifeCounter.setStroke(Color.WHITE);
		lifeCounter.setStrokeWidth(1);
		lifeCounter.setFill(colours[player.getLives()]);
		lifeCounter.setScaleX(2.5);
		lifeCounter.setScaleY(2.5);
		lifeCounter.setTranslateX(-WIDTH / 2 + 60);
		lifeCounter.setTranslateY(-HEIGHT / 2 + 30);
	}

}
