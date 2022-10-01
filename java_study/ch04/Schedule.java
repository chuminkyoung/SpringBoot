package ch04;

public class Schedule {
	private int year;
	private int month;
	private int day;
	
	
	// 멤버변수의 접근 범위 private(클래스 내부)
	// -> 별도의 메서드를 통해서 값을 지정(외부에서 접근 가능 범위)
	
	// setter / getter
	// set + 멤버변수명(...)
	// get + 멤버변수명(...)
	
	
	
	public void showDate() {
		System.out.println(year + "-" + month + "-" + day);
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}
}
