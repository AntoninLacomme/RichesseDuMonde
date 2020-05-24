package client.controllers;

import client.Client;
import game.Case;
import game.Plateau;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
	Pane paneShowMenu;
	
	@FXML
	Button idButtonTest;
	
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
	public void mouseClickPlateau (MouseEvent ev) {
		
	}
	
	@FXML
	public void showMenuMouseExit (MouseEvent ev) {
		paneShowMenu.setVisible(false);
	}
	@FXML
	public void eventPaneMenuMouseEnter (MouseEvent e) {
		paneShowMenu.setVisible(true);
	}
	@FXML
	public void eventShowMenuCliqued (MouseEvent e) {
		if (e.getButton().equals(MouseButton.SECONDARY)) {
			paneShowMenu.setVisible(false);
		}
	}
	
	
	@FXML
	public void eventMainKeyPressed (KeyEvent e) {
		if (e.getCode().getCode() == 27) {
			paneShowMenu.setVisible(false);
		}
	}
	
	public void initialize () {
		paneShowMenu.setVisible(false);
		Client.getGame().setControllerPlateau(this);
		
		this.ctxBckg = canbckg.getGraphicsContext2D();
		this.ctxFont = canfont.getGraphicsContext2D();
		
		this.ctxFont.setFill(Color.TRANSPARENT);
		this.ctxFont.fillRect(0, 0, canfont.getWidth(), canfont.getHeight());
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

}
