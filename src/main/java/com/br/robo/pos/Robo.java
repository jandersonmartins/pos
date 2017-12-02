package com.br.robo.pos;

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

	public int moveY(boolean down) {
		if (down && this.canDown()) {
			this.y++;
			this.setPosition();
		} else {
			// move pra cima
			if (this.canUp()) {
				this.y--;
				this.setPosition();
			}
		}

		return this.y;
	}

	public int moveX(boolean right) {
		if (right && this.canRight()) {
			this.x++;
			this.setPosition();
		} else {
			if(this.canLeft()) {
				this.x--;
				this.setPosition();
			}
		}
		return this.x;
	}

	private boolean canUp() {
		return (this.y > 0);
	}

	private boolean canRight() {
		return this.x + 1 < this.limit;
	}

	private boolean canLeft() {
		return (this.x > 0);
	}

	private boolean canDown() {
		return (this.y + 1) < this.limit;
	}
}
