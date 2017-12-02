package com.br.robo.pos;

import java.io.IOException;

public class Robo {
	private int[][] plano;

	private int limit = 4;
	private int x = 0;
	private int y = 0;

	private Logger logger;

	public Robo(Logger logger) {
		this.logger = logger;
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

	public int moveY(boolean down) {
		return this.incrementY(down, 1);
	}

	public int moveY(boolean down, int qtd) {
		if (qtd >= this.limit) {
			return this.y;
		}

		return this.incrementY(down, qtd);
	}

	public int moveX(boolean right) {
		return this.incrementX(right, 1);
	}

	public int moveX(boolean right, int qtd) {
		if (qtd >= this.limit) {
			return this.x;
		}

		return this.incrementX(right, qtd);
	}

	private int incrementX(boolean right, int qtd) {
		if (right && this.canRight()) {
			this.x += qtd;
			this.setPosition();
		} else {
			if (this.canLeft()) {
				this.x -= qtd;
				this.setPosition();
			}
		}
		return this.x;
	}

	private int incrementY(boolean down, int qtd) {
		if (down && this.canDown()) {
			this.y += qtd;
			this.setPosition();
		} else {
			// move pra cima
			if (this.canUp()) {
				this.y -= qtd;
				this.setPosition();
			}
		}

		return this.y;
	}

	private void setPosition() {
		this.clear();
		this.plano[this.y][this.x] = 1;

		try {
			this.logger.write(this.getLogMsg());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getLogMsg() {
		return "Posicao atual: \n Y -> " + this.y + " \n X -> " + this.x + "\n";
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
