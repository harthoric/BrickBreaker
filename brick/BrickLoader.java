package com.harthoric.brickbreaker.brick;

public class BrickLoader {

  // Amount of hits each brick requires to break
	private final int D_GRID[][] = new int[][] { { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 3, 2, 1, 1, 1, 1, 1, 1, 2, 3 },
		{ 3, 3, 3, 2, 1, 1, 2, 3, 3, 3 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 4, 5, 6, 6, 4, 4, 6, 6, 5, 4 } };

		// Stores each brick's rectangle
		private Group brickGroup;
		// Maps the Brick object against its rectangle counterpart
		private Map<Brick, Rectangle> bricks;

		private final int ROWS, COLS,
		WIDTH, HEIGHT;

		public BrickLoader(final int ROWS, final int COLS, final int WIDTH, final int HEIGHT) {
			this.ROWS = ROWS;
			this.COLS = COLS;
			this.WIDTH = WIDTH;
			this.HEIGHT = HEIGHT;
			bricks = new HashMap<>();
			brickGroup = new Group();
			random = new Random();
			loadBricks();
			addBricks();
			brickGroup.setTranslateX((Board.WIDTH-COLS*WIDTH)/2);
			brickGroup.setTranslateY((Board.HEIGHT-ROWS*HEIGHT)/2);
			brickGroup.setManaged(false);
		}

		private Random random;

		private int[][] randomGrid() {
			int[][] grid = new int[ROWS][COLS];
			for (int i = 0; i < ROWS; i++)
				for (int j = 0; j < COLS; j++)
					grid[i][j] = random.nextInt(Board.colours.length-1) + 1;

			return grid;
		}

		private void loadBricks() {
			int[][] GRID = ROWS != 5 || COLS != 10 ? randomGrid() : D_GRID;
			for (int i = 0; i < COLS; i++)
				for (int j = 0; j < ROWS; j++) {
					Rectangle rect = new Rectangle(WIDTH, HEIGHT, Board.colours[GRID[j][i] - 1]);
					rect.setTranslateX(i * WIDTH);
					rect.setTranslateY(j * HEIGHT);
					rect.setStroke(Color.BLACK);
					bricks.put(
							new Brick(GRID[j][i],
									new com.harthoric.archon.pong.rewrite.util.Vector2D((float) (rect.getTranslateX() - (0.5*COLS*WIDTH)), (float) (rect.getTranslateY() - (0.5*ROWS*HEIGHT))),
									new com.harthoric.archon.pong.rewrite.util.Vector2D((float) (rect.getTranslateX() - (0.5*(COLS-1)*WIDTH)), (float) (rect.getTranslateY() - (0.5*(ROWS-1)*HEIGHT)))),
							rect);
				}
		}

		private void addBricks() {
			for (Rectangle brick : bricks.values())
				brickGroup.getChildren().add(brick);
		}

		public Group getBrickGroup() {
			return brickGroup;
		}

}
