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
    
  }

}
