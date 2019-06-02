package com.harthoric.brickbreaker.util;

public class KeyHandler {

  public void checkKeys() {
		if (isPressed(KeyCode.A) && Board.getPlayer().getX() < Board.WIDTH / 2 - 40)
			Board.getPlayer().moveLeft(5);
		else if (isPressed(KeyCode.D) && Board.getPlayer().getX() > -Board.WIDTH / 2 + 40)
			Board.getPlayer().moveRight(5);
	}


	private boolean isPressed(KeyCode key) {
		return Board.keys.getOrDefault(key, false);
	}

}
