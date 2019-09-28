import logos.domain.Magazine;
import logos.service.MagazineService;
import logos.service.impl.MagazineServiceImpl;

public class app {
	
	public static void main(String[] args) {
		MagazineService us =  MagazineServiceImpl.getMagazineService();
		us.create(new Magazine("olha","matsiuk",5,6 ));
	}

}
