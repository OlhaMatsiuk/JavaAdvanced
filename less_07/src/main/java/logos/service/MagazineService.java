package logos.service;

import java.util.Map;

import logos.domain.Magazine;
import logos.shared.AbstractCRUD;

public interface MagazineService extends AbstractCRUD<Magazine>{
	public Map<Integer, Magazine> readAllMap();
}
