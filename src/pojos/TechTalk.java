package pojos;

import java.sql.Date;


public class TechTalk {
	
	


	int techTalkId;
	Date techTalkDate;
	String title;
	String description;
	String speaker;
	public TechTalk(int techTalkId, Date techTalkDate, String title,
			String description, String speaker) {
		super();
		this.techTalkId = techTalkId;
		this.techTalkDate = techTalkDate;
		this.title = title;
		this.description = description;
		this.speaker = speaker;
		
	}
	
	
	public int getTechTalkId() {
		return techTalkId;
	}
	
	
	public void setTechTalkId(int techTalkId) {
		this.techTalkId = techTalkId;
	}
	
	
	public Date getTechTalkDate() {
		return techTalkDate;
	}
	
	
	public void setTechTalkDate(Date techTalkDate) {
		this.techTalkDate = techTalkDate;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getSpeaker() {
		return speaker;
	}
	
	
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "TechTalk [techTalkId=" + techTalkId + ", techTalkDate="
				+ techTalkDate + ", title=" + title + ", description="
				+ description + ", speaker=" + speaker +  "]";
	}

}
