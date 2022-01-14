package org.springframework.samples.petclinic.recoveryroom;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	private final RecoveryRoomService roomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService roomService) {
		this.roomService = roomService;
	}
	
	@ModelAttribute("types")
	public Collection<RecoveryRoomType> populateRecoveryRoomTypes() {
		return roomService.getAllRecoveryRoomTypes();
	}
	
	@GetMapping(value="/recoveryroom/create")
	public String initCreationForm(Map<String,Object> model) {
		
		RecoveryRoom room = new RecoveryRoom();
		model.put("recoveryRoom", room);
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
		
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", room);
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}
		else {
			roomService.save(room);
			return "welcome";
	}

	}
    
}
