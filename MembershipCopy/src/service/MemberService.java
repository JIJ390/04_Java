package service;

import java.io.IOException;
import java.util.List;

import dto.Member;

public interface MemberService {

	boolean addMember(String name, String phone) throws IOException;

	List<Member> getMemberList();
	
	boolean plusAmount(String phone, int price) throws IOException;

	boolean reInform(String reName, String rePhone, String name, String phone) throws IOException;

	boolean removeMember(String name, String phone, char choice) throws IOException;


}
