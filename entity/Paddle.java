package com.harthoric.brickbreaker.entity;

public class Paddle extends Vector2D {

  public Rectangle player;

	public Paddle(int x, int y, Rectangle player) {
		super(x, y);
		this.player = player;
	}

	public void moveUp(int moveBy) {
		super.setY(super.getY() + moveBy);
	}

	public void moveDown(int moveBy) {
		super.setY(super.getY() - moveBy);
	}

	public void moveLeft(int moveBy) {
		super.setX(super.getX() + moveBy);
		player.setTranslateX(-getX());

	}

	public void moveRight(int moveBy) {
		super.setX(super.getX() - moveBy);
		player.setTranslateX(-getX());
	}

}
