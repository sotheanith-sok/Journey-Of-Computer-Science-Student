package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card03 extends Card {

	
	
	public Card03()
	{
		//super();
		super.setName("03");
		super.setCName("Research Compilers");
		super.setCLocation("Play in the Library");
		super.setEffect("gain 1 Learning Chip");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Library") )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setLearning(player.getLearning() + 1);
		setEffect("gained 1 Learning Chip");
	
	}



}
