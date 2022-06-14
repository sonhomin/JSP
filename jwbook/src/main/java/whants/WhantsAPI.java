package whants;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import whants.Contents;
import whants.ContentsDAO;

public class WhantsAPI {
	ContentsDAO dao;
	public WhantsAPI() {
		 dao = new ContentsDAO();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNews(Contents contents) {
		try {
			dao.addContents(contents);
		} catch (Exception e) {
			e.printStackTrace();
			return "contents API: 등록 실패!!";
		}
		return "contents API: 등록됨!!";
	}
}
