
public class AutomaticDoor extends Door{

	
	public void pressOpen() {
		System.out.println("Automatic door open");
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		pressOpen();
	}	
}
