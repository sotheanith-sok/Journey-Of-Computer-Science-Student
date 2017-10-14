
import Controller.GameController;
import Model.GameModel;
import View.GameView;



public class main {

	public static void main(String[] args) {
		
		GameModel model= new GameModel("Lucy");
		GameView view = new GameView(model);
		GameController controller=new GameController(model, view);
		view.setVisible(true);
	
	}

}
