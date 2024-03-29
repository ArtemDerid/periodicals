package ua.lviv.lgs.periodicals.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.periodicals.domain.Periodical;

public class PeriodicalsDTOHelper {
	
	public static Periodical createEntity(MultipartFile file, String name,
			String description, double price) throws IOException {
		Periodical periodical = new Periodical();
		periodical.setName(name);
		periodical.setDescription(description);
		periodical.setPrice(price);
		periodical.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return periodical;	
		
	}

}
