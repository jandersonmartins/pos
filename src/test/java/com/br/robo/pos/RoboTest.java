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
		robo.moveY();
		assertEquals(robo.getY(), 1);
		assertEquals(robo.getX(), 0);
		assertEquals(robo.getPosition(), 1);
	}
}
