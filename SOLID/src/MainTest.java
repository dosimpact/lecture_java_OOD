

public class MainTest {

	public static void main(String[] args) {

		// SRP
		
//		Book b1 = new Book("doyung",2000,10000,"1234");
//		Book b2 = new Book("dosdos",2010,17000,"1412412");
//		System.out.println(b1);
//		System.out.println(b2);
//		b1.load();
//		b1.show();
		
		
//		List<Book> books  =new ArrayList<>();
//		books.add(b1);
//		books.add(b2);
//		BookManager manager = new BookManager(books);
//		manager.load();
//		manager.show();
		
		BookManager manager = new BookManager();
		manager.setLoader(new BookDataLoader());
		manager.setViewer(new BookDataViewer());
		manager.load();
		manager.show();
		
		// OCP
		System.out.println("version1 OCP - violation");
		Door door = new PushDoor();
		if( door instanceof AutomaticDoor) {
			((AutomaticDoor)door).pressOpen();
		} else if ( door instanceof KnobDoor) {
			((KnobDoor)door).pressOpen();
		} else if ( door instanceof PushDoor) {
			((PushDoor)door).pressOpen();
		} else if ( door instanceof SlidingDoor) {
			((SlidingDoor)door).slideOpen();
		}
		
		Door[] doors = {new PushDoor(),new AutomaticDoor(),new KnobDoor(), new SlidingDoor()};
		for(Door d:doors) {
			d.open();
		}
	}

}
