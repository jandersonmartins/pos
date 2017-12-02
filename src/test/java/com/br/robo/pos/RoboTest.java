package com.br.robo.pos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoboTest {
	private Robo robo;

	@Before
	public void setup() {
		this.robo = new Robo();
	}

	@Test
	public void deveTerPosicaoInicialZero() {
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getY(), 0);
		assertEquals(robo.getPosition(), 1);
	}

	@Test
	public void deveAndarParaTrasAPartirDaPosicaoInicial() {
		robo.moveY(true);
		assertEquals(robo.getY(), 1);
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getPosition(), 1);
	}

	@Test
	public void naoDeveAndarMaisQueOlimiteParaBaixo() {
		// Executa mais que o limite
		for (int i = 0; i < 5; i++) {
			robo.moveY(true);
		}

		assertEquals(robo.getY(), 3);
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getPosition(), 1);
	}

	@Test
	public void naoDeveAndarParaBaixoQuandoForZero() {
		robo.moveY(false);
		assertEquals(robo.getY(), 0);
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getPosition(), 1);
	}

	@Test
	public void deveAndarParaBaixoQuandoForMaiorQueZero() {
		// anda duas uma pra baixo
		robo.moveY(true);
		robo.moveY(true);

		// anda pra cima
		robo.moveY(false);

		assertEquals(robo.getY(), 1);
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getPosition(), 1);
	}

	@Test
	public void deveAndarParaADireita() {
		robo.moveX(true);
		assertEquals(robo.getX(), 1);
	}

	@Test
	public void naoDeveAndarMaisQueOLimiteParaADireita() {
		for (int i = 0; i < 5; i++) {
			robo.moveX(true);
		}

		assertEquals(robo.getX(), 3);
	}

	@Test
	public void deveAndarParaAEsquerda() {
		robo.moveX(true);
		robo.moveX(true);
		robo.moveX(false);
		assertEquals(robo.getX(), 1);
	}

	@Test
	public void naoDeveAndarMaisQueOLimiteParaAEsquerda() {
		for (int i = 0; i < 5; i++) {
			robo.moveX(false);
		}

		assertEquals(robo.getX(), 0);
	}
}
