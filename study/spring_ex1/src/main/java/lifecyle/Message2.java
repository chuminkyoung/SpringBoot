package lifecyle;

public class Message2 {
	private String name;
	
	public void send() {
		System.out.printf("%s에게 메세지 전달%n", name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void init() {
		System.out.println("초기화 시에 호출!!");
	}
	
	public void close() {
		System.out.println("소멸전에 호출!!");
	}
}
