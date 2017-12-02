package com.br.robo.pos;

import java.util.Arrays;

public class Robo {
	private int[][] plano;

	private int limit = 4;
	private int x = 0;
	private int y = 0;

	public Robo() {
		this.plano = new int[this.limit][this.limit];
		this.setPosition();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPosition() {
		return plano[this.y][this.x];
	}
	
	public void clear() {
		for (int y = 0; y < this.plano.length; y++) {
			for (int x = 0; x < this.plano[y].length; x++) {
				this.plano[y][x] = 0;
			}
		}
	}
	
	private void setPosition() {
		this.clear();
		this.plano[this.y][this.x] = 1;
	}

	public int moveY() {
		this.y++;
		this.setPosition();
		return this.y;
	}

	@Override
	public String toString() {
		return "X: " + x + " Y: " + y;
	}
}
