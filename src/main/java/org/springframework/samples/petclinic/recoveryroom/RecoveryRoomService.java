package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.samples.petclinic.pet.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository roomRepository;
	

	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
    public List<RecoveryRoom> getAll(){
        return roomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return roomRepository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return roomRepository.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return roomRepository.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return roomRepository.save(p);       
    }

    
}
