package com.greedy.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;

public class MemberService {

	private MemberDAO memberDAO = new MemberDAO();
	
	public boolean createNewMember(MemberDTO member) {

		Connection con = getConnection();
		
		int result = memberDAO.insertNewMember(con, member);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}

	public List<MemberDTO> selectAllMember() {
		
		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectMemberList(con);
		
		close(con);
		
		
		return memberList;
	}
	
	public MemberDTO selectMemberById(String id) {
		
		Connection con = getConnection();
		
		MemberDTO result = memberDAO.selectIdMember(con, id);
		
		close(con);
		
		return result;
	}

	public List<MemberDTO> selectMemberByGender(String gender) {
		
		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectMemberGenList(con, gender);
		
		close(con);
		
		return memberList;
	}

	public MemberDTO updatePwdById(String memberId, String password) {

		Connection con = getConnection();
		
		MemberDTO result = memberDAO.updatePwd(con, memberId, password);
		
		close(con);
		
		return result;
	}

	public MemberDTO updateEmailById(String memberId, String email) {

		Connection con = getConnection();
		
		MemberDTO result = memberDAO.updateEmail(con, memberId, email);
		
		close(con);
		
		return result;
	}

	public MemberDTO updatePhoneById(String memberId, String phone) {

		Connection con = getConnection();
		
		MemberDTO result = memberDAO.updatePhone(con, memberId, phone);
		
		close(con);
		
		return result;
	}

	public MemberDTO updateAddressById(String memberId, String address) {

		Connection con = getConnection();
		
		MemberDTO result = memberDAO.updateAddress(con, memberId, address);
		
		close(con);
		
		return result;
	}

	public MemberDTO deleteMemberById(String memberId) {

		Connection con = getConnection();
		
		MemberDTO result = memberDAO.deleteMemberInfo(con, memberId);
		
		close(con);
		
		return result;
	}

}
