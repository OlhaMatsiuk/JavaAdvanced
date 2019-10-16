package logos.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import logos.domain.Level;
import logos.domain.Participant;

@Repository
public class ParticipantRepository {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Olha");
		participant1.setEmail("olya@gmail.com");
		participant1.setLevel(Level.L5);
		participant1.setPrimarySkill("Java");
		
		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Bohdan");
		participant2.setEmail("bohdan@gmail.com");
		participant2.setLevel(Level.L3);
		participant2.setPrimarySkill("Python");
		
		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Vika");
		participant3.setEmail("vika@gmail.com");
		participant3.setLevel(Level.L2);
		participant3.setPrimarySkill("C++");
		
		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Dima");
		participant4.setEmail("dima@gmail.com");
		participant4.setLevel(Level.L1);
		participant4.setPrimarySkill("C#");
		
		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);
		
	}

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(part -> part.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant partToUpdate = null;

		if (participant.getId() != null) {
			partToUpdate = findOne(participant.getId());
			int partIndex = participants.indexOf(partToUpdate);
			
			partToUpdate.setName(participant.getName());
			partToUpdate.setEmail(participant.getEmail());
			partToUpdate.setLevel(participant.getLevel());
			partToUpdate.setPrimarySkill(participant.getPrimarySkill());
			
			participants.set(partIndex, partToUpdate);
		} else {
			// save
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
	
	
}
