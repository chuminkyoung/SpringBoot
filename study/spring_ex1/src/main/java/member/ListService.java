package member;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ListService {
	
	@Autowired
	private MemberDao memberDao;
	
	// @Autowired
	// private @Nullable DateTimeFormatter formatter;
	
	@Autowired
	private Optional<DateTimeFormatter> opt;
	
	
	public void listing() {
		Map<String, MemberDto> members = memberDao.getMembers();
		for (Map.Entry<String, MemberDto> entry:members.entrySet()) {
			
			MemberDto member = entry.getValue();
			System.out.println(member);
			if (opt.isPresent()) {
				System.out.println(opt.get().format(member.getRegDt()));
			}
			
			
			/**
			if(formatter != null) {				
				System.out.println(formatter.format(member.getRegDt()));
			}
			*/
			
		}
	}
	
	/**
	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> opt) {
		if(opt.isPresent()) {
			formatter = opt.get();
		}
	}
	*/
	
	/**
	@Autowired(required=false)
	public void setDateTimeFormatter(DateTimeFormatter formatter) {
		System.out.println("호출되나요?");
		this.formatter = formatter;
		
	}
	*/
}
