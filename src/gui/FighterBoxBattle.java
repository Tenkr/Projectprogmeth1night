package gui;

import entity.base.Fighter;
import gui.base.FighterBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.Updatable;
import sharedObject.RenderableHolder;

public class FighterBoxBattle extends FighterBox implements Updatable {

	public FighterBoxBattle(Fighter fighter, int symbol) {
		super(fighter, symbol);
		setWidth(150);
		setHeight(100);
		setImage();
		draw();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub


		gc.setFill(Color.DARKKHAKI);
		gc.fillRect(0, 0, 150, 100);
		gc.drawImage(image, 5, 5, 50, 50);
		gc.setFont(Font.font("Palatino Linotype", FontWeight.SEMI_BOLD, 20));
		gc.strokeText(fighter.getName(), 80, 40);
		gc.setFill(Color.ORANGERED);
		gc.fillRect(25, 70, 100, 15);
		gc.strokeRect(0, 0, 150, 100);;
	}

	@Override
	public void setImage() {
		image = RenderableHolder.getHeadImage(symbol);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		draw();
		gc.setFill(Color.BLACK);
		gc.fillRect(25 + (fighter.getHitPoint() / fighter.getMaxHitPoint()) * 100, 70,
				100 - (fighter.getHitPoint() / fighter.getMaxHitPoint()) * 100, 15);
		gc.strokeRect(0, 0, 150, 100);

	}

}
