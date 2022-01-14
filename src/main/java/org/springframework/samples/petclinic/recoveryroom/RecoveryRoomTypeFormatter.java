package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	private final RecoveryRoomService roomService;

	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public String print(RecoveryRoomType roomType, Locale locale) {
		return roomType.getName();
	}

	@Override
	public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
		RecoveryRoomType roomType = this.roomService.getRecoveryRoomType(text);
			if (roomType != null) {
				return roomType;
			}
		throw new ParseException("type not found: " + text, 0);
	}
}
