package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDaoImpl implements MemberDao{

	private List<Member> memberList = null;
	
	private final String FILE_PATH = "\\io_test\\MEMBER_COPY\\Member.dat";
	
	private ObjectInputStream  ois = null;
	private ObjectOutputStream oos = null;
	
	public MemberDaoImpl() throws IOException, ClassNotFoundException, FileNotFoundException{
		File f = new File(FILE_PATH);
		
		if (f.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				memberList = (ArrayList<Member>)ois.readObject();
			} finally {
				if (ois != null) ois.close();
			}
		} else {
			memberList = new ArrayList<Member>();
		}
	}
	
	@Override
	public List<Member> getMemberList() {
		return memberList;
	}

	@Override
	public boolean addMember(Member member) throws IOException {
		memberList.add(member);
		saveFile();
		return true;
	}

	@Override
	public void saveFile() throws IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);
		} finally {
			if (oos != null) oos.close();
		}
	}


}
