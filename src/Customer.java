import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* 객체 직렬화를 위한 클래스 설계 
 *  1.객체 직렬화 클래스를 설계하기 위해서 java.io의 Externalizable 인터페이스를 구현 상속 받고 2개의 추상메서드를
 *  오버라이딩을 함.
 * */

public class Customer implements Externalizable{
    int id;
    String name;
    int age;
    double height;//키
    
    public Customer() {}
    
    public Customer(int id,String name,int age,double height) {
       this.id=id; this.name=name; this.age=age; this.height=height;	
    }
    
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		/* 문제) 각각에 자바의 어떤 문법이 적용되었는지 기록해보자.  
		 */
		out.writeObject(new Integer(id)); // 1.오토박싱(자바 기본타입이 래퍼 참조타입으로 자동형 변환)+업캐스
		//팅
		out.writeObject(name); // 2.업캐스팅
		out.writeObject(new Integer(age)); // 3.오토박싱과 업캐스팅
		out.writeObject(new Double(height)); // 4.오토박싱과 업캐스팅 
	}//객체 단위로 기록

	@Override
	public void readExternal(ObjectInput in) 
			throws IOException, ClassNotFoundException {
		id=(Integer)in.readObject();//명시적인 다운캐스팅+오토언박싱(래퍼 참조형이 기본타입으로 자동형변환)
		name=(String)in.readObject();//다운캐스팅
		age=(Integer)in.readObject();//다운캐스팅+오토언박싱
		height=(Double)in.readObject();// 다운캐스팅과 오토언박싱
	}//객체 단위로 읽어오기

	@Override
	public String toString() {
		return "id="+id+",name="+name+",age="+age+",height="+height;
	}	
}
