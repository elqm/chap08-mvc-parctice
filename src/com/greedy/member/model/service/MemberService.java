package com.greedy.member.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;
import static com.greedy.common.Template.getSqlSession;

public class MemberService {

	private MemberDAO memberDAO = new MemberDAO();
	
	public boolean createNewMember(MemberDTO member) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.insertNewMember(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public List<MemberDTO> selectAllMember() {
		
		SqlSession sqlSession = getSqlSession();
		
		List<MemberDTO> memberList = memberDAO.selectMemberList(sqlSession);
		
		sqlSession.close();
		
		
		return memberList;
	}
	
	public MemberDTO selectMemberById(String id) {
		
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO result = memberDAO.selectIdMember(sqlSession, id);
		
		sqlSession.close();
		
		return result;
	}

	public List<MemberDTO> selectMemberByGender(String gender) {
		
		SqlSession sqlSession = getSqlSession();
		
		List<MemberDTO> memberList = memberDAO.selectMemberGenList(sqlSession, gender);
		
		sqlSession.close();
		
		return memberList;
	}

	public boolean updatePwdById(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.updatePwd(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public boolean updateEmailById(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.updateEmail(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public boolean updatePhoneById(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.updatePhone(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public boolean updateAddressById(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.updateAddress(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public boolean deleteMemberById(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.deleteMemberInfo(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

}
