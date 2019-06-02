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

}
