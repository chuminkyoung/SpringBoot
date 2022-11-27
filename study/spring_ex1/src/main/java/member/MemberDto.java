package member;

import java.time.LocalDateTime;

public class MemberDto {
	// 회원가입 - 아이디, 비번 등등
	private String memId; 			// 아이디
	private String memPw; 			// 비밀번호
	private String memNm; 			// 회원명
	private LocalDateTime regDt; 	// 회원 가입일
	
	public MemberDto() {}
	
	public MemberDto(String memId, String memPw, String memNm, LocalDateTime regDt) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.regDt = regDt;
	}

	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getMemPw() {
		return memPw;
	}
	
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	public String getMemNm() {
		return memNm;
	}
	
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	
	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	
	// 나중에 데이터에 어떤게 있는지 확인하기 위해
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", regDt=" + regDt + "]";
	}
	
	
}
