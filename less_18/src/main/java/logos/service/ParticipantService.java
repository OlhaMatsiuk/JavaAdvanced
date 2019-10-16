package logos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.dao.ParticipantRepository;
import logos.domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;
	

	public List<Participant> findAllParticipants() {
		return participantRepository.findAllParticipants();
	}

	public Participant findOne(int id) {
		return participantRepository.findOne(id);
	}

	public void save(Participant participant) {
		participantRepository.save(participant);
	}

	public void delete(int id) {
		participantRepository.delete(id);
	}
}
