package entity;

import entity.base.Fighter;
import entity.base.StatsIncreasable;
import logic.GameConstant;
import logic.Sprites;

public class KingFighter extends Fighter implements StatsIncreasable{

	private double dodgeChance; // percent to dodge

	private final int MIN_DODGECHANCE = 25;
	private final int MAX_EXTRA_DODGECHANCE = 10;

	private double bonusDefense;
	private double bonusHitPoint;

	private final int MAX_BONUS_DEFENSE = 20;
	private final int MIN_BONUS_HIT_POINT = 20;
	private final int MAX_EXTRA_BONUS_HIT_POINT = 30;

	private double bonusAttack; // bonusAttack is percent attack increased

	private final int MIN_BONUS_ATTACK = 25;
	private final int MAX_EXTRA_BONUS_ATTACK = 15;

	private final int EXTRA_MOVE = 1;

	public KingFighter(String type, int team) {
		super(type, team);
		setName(GameConstant.KING_NAME);
		setBonusStats();
	}

	protected void setSpecialAbility() {
		setTotalMoves(getTotalMoves() + EXTRA_MOVE);
		setDodgeChance();
	}

	public int getSymbol() {
		if (team == GameConstant.TEAM_1) {
			return Sprites.P1_KING;
		} else if (team == GameConstant.TEAM_2) {
			return Sprites.P2_KING;
		}
		return 0;
	}

	public void setBonusStats() {
		setBonusAttack();
		setAttack(attack + attack * bonusAttack / 100);

		setBonusDefense();
		setBonusHitPoint();
		setDefense(defense + defense * bonusDefense / 100);
		setMaxHitPoint(maxHitPoint + maxHitPoint * bonusHitPoint / 100);
		setHitPoint(maxHitPoint);
	}

	private void setBonusAttack() {
		bonusAttack = MIN_BONUS_ATTACK + Math.random() * MAX_EXTRA_BONUS_ATTACK; // attack is increased by between 10,40
																					// percent
	}

	private void setBonusDefense() {
		bonusDefense = Math.random() * MAX_BONUS_DEFENSE;
	}

	private void setBonusHitPoint() {
		bonusHitPoint = MIN_BONUS_HIT_POINT + Math.random() * MAX_EXTRA_BONUS_HIT_POINT;
	}

	public double getDodgeChance() {
		return dodgeChance;
	}

	private void setDodgeChance() {
		dodgeChance = MIN_DODGECHANCE + Math.random() * MAX_EXTRA_DODGECHANCE; // dodge chance is between 25,35 percent
	}

}