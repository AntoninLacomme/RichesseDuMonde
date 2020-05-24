package client.controllers;

import client.Client;
import game.Case;
import game.Plateau;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ControllerMainPlateau {
	
	public GraphicsContext ctxBckg;
	public GraphicsContext ctxFont;
	
	public int lastPositionX = -1;
	public int lastPositionY = -1;

	@FXML
	Canvas canbckg;
	@FXML
	Canvas canfont;
	
	@FXML
	public void mouseMovePlateau (MouseEvent e) {
		if (lastPositionX >= 0 && lastPositionY >= 0) {
			int rayon = 5;
			this.ctxFont.clearRect(lastPositionX - rayon -1, lastPositionY - rayon -1, rayon*2 +2, rayon*2 +2);
			this.ctxFont.setFill(Color.BLUE);
			this.ctxFont.fillOval(e.getX() - rayon, e.getY() - rayon, rayon*2, rayon*2);
		}
		lastPositionX = (int) e.getX();
		lastPositionY = (int) e.getY();
	}
	
	@FXML
	public void mouseClickPlateau (MouseEvent e) {
		
	}
	
	public void initialize () {
		Client.getGame().setControllerPlateau(this);
		
		this.ctxBckg = canbckg.getGraphicsContext2D();
		this.ctxFont = canfont.getGraphicsContext2D();
		
		this.ctxFont.setFill(Color.TRANSPARENT);
		this.ctxFont.fillRect(0, 0, canfont.getWidth(), canfont.getHeight());
		
		this.ctxBckg.clearRect(0, 0, canbckg.getWidth(), canbckg.getHeight());
		
		this.drawEmptyPlateau(this.ctxBckg);
	}
	
	private void drawEmptyPlateau (GraphicsContext ctx) {
		int wc = (int) canbckg.getWidth() / 11;
		int hc = (int) canbckg.getHeight() / 11;
		ctx.save();
		ctx.setLineWidth(10);
		ctx.setStroke(Color.BLACK);
		/*
		for (int i=0; i<11; i++) {
			ctx.strokeRect(i * wc, 0, wc, hc);
			ctx.strokeRect(i * wc, hc, wc, hc);
			
			ctx.strokeRect(i * wc, 9 * hc, wc, hc);
			ctx.strokeRect(i * wc, 10 * hc, wc, hc);
		}
		
		for (int i=2; i<9; i++) {
			ctx.strokeRect(0, i * hc, wc, hc);
			ctx.strokeRect(1 * wc, i * hc, wc, hc);
			
			ctx.strokeRect(9 * wc, i * hc, wc, hc);
			ctx.strokeRect(10 * wc, i * hc, wc, hc);
		}*/
		
		ctx.restore();
	}
	
	public void drawPlateau (Plateau p) {
		int index = 0;
		GraphicsContext ctx = canbckg.getGraphicsContext2D();
		int wc = (int) canbckg.getWidth() / 11;
		int hc = (int) canbckg.getHeight() / 9;
		
		for (Case c : p.getAllCases()) {
			c.drawCasesJavaFX(ctx, index, wc, hc);
			index++;
		}
	}
	

	public void helloworld () {
		System.out.println("Hello world");
	}
}
