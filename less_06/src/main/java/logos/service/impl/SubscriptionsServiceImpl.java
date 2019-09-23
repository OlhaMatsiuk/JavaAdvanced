package logos.service.impl;

import java.util.List;

import logos.dao.SubscriptionsDao;
import logos.dao.impl.SubscriptionsDaoImpl;
import logos.domain.Subscriptions;
import logos.service.SubscriptionsService;

public class SubscriptionsServiceImpl implements SubscriptionsService{
	
    private SubscriptionsDao subscriptionsDao;
    private SubscriptionsService subscriptionServiceImpl;
	
	private SubscriptionsServiceImpl() {
		subscriptionsDao = new SubscriptionsDaoImpl();
	}
	
	public SubscriptionsService getSubscriptionService() {
		if (subscriptionServiceImpl == null) {
			subscriptionServiceImpl = new SubscriptionsServiceImpl();
		}

		return subscriptionServiceImpl;
	}

	@Override
	public Subscriptions create(Subscriptions subscriptions) {
		return subscriptionsDao.create(subscriptions);
	}

	@Override
	public Subscriptions read(Integer id) {
		return subscriptionsDao.read(id);
	}

	@Override
	public Subscriptions update(Subscriptions subscriptions) {
		return subscriptionsDao.update(subscriptions);
	}

	@Override
	public void delete(Integer id) {
		subscriptionsDao.delete(id);
		
	}

	@Override
	public List<Subscriptions> readAll() {
		return subscriptionsDao.readAll();
	}

}
