package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao dao = null;
	
	public MemberServiceImpl() throws ClassNotFoundException, IOException, FileNotFoundException {
		dao = new MemberDaoImpl();
	}

	@Override
	public boolean addMember(String name, String phone) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) {
			if (member.getPhone().equals(phone)) return false;
		}
		
		Member member = new Member(name, phone, 0, Member.COMMON);
		
		return dao.addMember(member);
	}
	
	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}
	
	@Override
	public boolean plusAmount(String phone, int price) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) if (member.getPhone().equals(phone)) {
			price += member.getAmount();
			member.setAmount(price);
			
			if      (member.getAmount() > 1000000) member.setGrade(Member.DIAMOND);
			else if (member.getAmount() > 100000)  member.setGrade(Member.GOLD);
			
			dao.saveFile();
			
			return true;
		}
		
		return false;

	}
	
	@Override
	public boolean reInform(String reName, String rePhone, String name, String phone) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) {
			if (member.getName().equals(name) && member.getPhone().equals(phone)) {
				
				member.setName(reName);
				member.setPhone(rePhone);
			
				dao.saveFile();
				
				return true;
			}
		}
			
		return false;
	}
	
	@Override
	public boolean removeMember(String name, String phone, char choice) throws IOException {
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) {
			if (member.getName().equals(name) && member.getPhone().equals(phone)) {
				
				memberList.remove(memberList.indexOf(member));
				
				dao.saveFile();
				
				return true;
			}
		}
		
		return false;
	}
}
