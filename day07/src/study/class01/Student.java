package study.class01;

public class Student {
// �Ӽ� �Ǵ� �ʵ� ���� : ���� ����
	private String sEntryNumber;
	private String sName;
	private String sAddress;
	
// �Լ�(��� �޼ҵ�) ���� : ��κ� public
	// ������ ����
	// �⺻(default) ������
	public Student() {
		
	}
// getter/setter �޼ҵ� ����
//	public String getEntryNumber() {
//		return this.sEntryNumber;
//	}
//	
//	public void setEntryNumber(String sEntryNumber) {
//		this.sEntryNumber = sEntryNumber;
//	}

	public String getsEntryNumber() {
		return sEntryNumber;
	}

	public void setsEntryNumber(String sEntryNumber) {
		this.sEntryNumber = sEntryNumber;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	// �������̵� �޼ҵ� ����
	
	// ����� ���� �޼ҵ� ����
	// ���� �޼ҵ�(Ŭ���� �޼ҵ�)
	// ���� �޼ҵ�(�ν��Ͻ� �޼ҵ�, ��ü �޼ҵ�)
}
