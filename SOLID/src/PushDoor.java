
public class PushDoor extends Door{

	
	public void pressOpen() {
		System.out.println("PushDoor door open");
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		pressOpen();
	}	
}
