package Model;

/**
 * This is an effect class which perform effect of the card on a player.
 *
 */
public class Effect {
	public static void changePlayer(Card c, Player p) {
		// Good to go
		if (checkPrerequisites(c, p) == true && checkLocation(c, p) == true) {
			p.setQualityPoints(p.getQualityPoints() + 4);
			p.setSkillChips(p.getSkillChips() + 1);
		}
		// Wrong Prerequisites
		else if (checkPrerequisites(c, p) == true) {
			p.setQualityPoints(p.getQualityPoints() - 2);
		}
		// Wrong Prerequisites and room
		else {
			p.setQualityPoints(p.getQualityPoints() - 2);
			switch (c.getEffectIndex()) {
			// Effect 1: change Learning
			case 1:
				p.setLearning(p.getLearning() + c.getEffectModifier());
				break;
			// Effect 2: change Craft
			case 2:
				p.setCraft(p.getCraft() + c.getEffectModifier());
				break;
			// Effect 3: change Integrity
			case 3:
				p.setIntegrity(p.getIntegrity() + c.getEffectModifier());
				break;
			// Effect 4: change SkillChips
			case 4:
				p.setSkillChips(p.getSkillChips() + c.getEffectModifier());
				break;
			// Effect 5: change QualityPoint
			case 5:
				p.setQualityPoints(p.getQualityPoints() + c.getEffectModifier());
			default:
				break;
			}
		}

	}

	private static boolean checkPrerequisites(Card c, Player p) {
		if (c.getRequiredCraft() == p.getCraft() && c.getRequiredIntegrity() == p.getIntegrity()
				&& c.getRequiredLearning() == p.getLearning())
			return true;
		else
			return false;
	}

	private static boolean checkLocation(Card c, Player p) {
		String[] playableLocation = c.getLocation().split(",");
		for (int i = 0; i < playableLocation.length; i++) {
			if (playableLocation[i] == p.getLocation())
				return true;
		}
		return false;
	}

}
