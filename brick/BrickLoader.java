package com.harthoric.brickbreaker.brick;

public class BrickLoader {

  // Amount of hits each brick requires to break
  private int grid[][] = new int[][] { { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 3, 2, 1, 1, 1, 1, 1, 1, 2, 3 },
			{ 3, 3, 3, 2, 1, 1, 2, 3, 3, 3 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 4, 5, 6, 6, 4, 4, 6, 6, 5, 4 } };

  // Stores each brick's rectangle
  private Group brickGroup;
  // Maps the Brick object against its rectangle counterpart
  private Map<Brick, Rectangle> bricks;

}
