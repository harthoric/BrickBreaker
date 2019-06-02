package com.harthoric.brickbreaker.entity;

public class Ball {

  // Amount the ball increases each time it hits a brick
	private final float ACCELERATION;
	private Vector2D velocity, position;

	public Circle ball;

	public Ball(final float ACCELERATION, Vector2D velocity, Vector2D position, Circle ball) {
		this.ACCELERATION = ACCELERATION;
		this.velocity = velocity;
		this.position = position;
		this.ball = ball;
	}

}
