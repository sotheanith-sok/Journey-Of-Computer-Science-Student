package Cards;
import Model.Card;
import Model.Player;
public class Card35 extends Card {
	
	public Card35() {
		super("Learning Linux", "src/Images/cardm35.png",
				new String[] { "Computer Lab" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 3);
		if (p.isHuman() == true) {
			this.dialogChipOption(true, true, true, p);
			return " and 3 Quality Points";
		} else {
			int i = (int) Math.random() * 3;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip and 3 Quality Points  ";
			} else if (i == 1) {
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip and 3 Quality Points";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip and 3 Quality Points ";
			}
		}
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 3);
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity() >= 3) &&(p.getCraft()>=2)&& location.contains(p.getLocation());
	}
	
}
