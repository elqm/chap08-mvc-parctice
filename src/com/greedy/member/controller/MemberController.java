package com.greedy.member.controller;

import java.util.List;
import java.util.Map;

import com.greedy.member.model.dto.MemberDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.views.MemberResultView;

public class MemberController {
	
	/* MemberResultView 클래스에 작성한 display 메소드로 출력할 것
	 * display 메소드로 출력할 필요 없는 내용은 간단히 콘솔에 직접 출력
	 * dml 수행 결과는 MemberResultView의 displayDmlResult()를 이용할 것
	 * */
	
	private MemberResultView memberResultView = new MemberResultView();
	private MemberService memberService = new MemberService();
	
	/* 신규 회원 등록용 메소드 */
	public void registNewMember(Map<String, String> parameter) {
		
		/* Map으로 전달 된 데이터를 꺼내 MemberDTO에 담아 Service로 전달 */
		

		String id = parameter.get("id");
		String pwd = parameter.get("pwd");
		String name = parameter.get("name");
		String gender = parameter.get("gender");
		String email = parameter.get("email");
		String phone = parameter.get("phone");
		String address = parameter.get("address");
		int age = Integer.parseInt(parameter.get("age"));
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddress(address);
		member.setAge(age);
		
		System.out.println(member);
		
		if(memberService.createNewMember(member)) {
			memberResultView.displayDmlResult("insertSuccess");
		} else {
			memberResultView.displayDmlResult("insertFailed");
		}
	}
	
	/* 모든 회원 정보 조회용 메소드(List로 조회할 것) */
	public void selectAllMembers() {
		
		List<MemberDTO> memberList = memberService.selectAllMember();
		
		if(memberList != null) {
			memberResultView.display(memberList);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}
		
	}
	
	/* 아이디를 이용한 회원 정보 검색(MemberDTO로 한 명 회원 정보 조회) */
	public void searchMemberById(Map<String, String> parameter) {
		
		String id = parameter.get("id");
		
		MemberDTO selectedMem = memberService.selectMemberById(id);
		
		if(selectedMem != null) {
			memberResultView.display(selectedMem);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}
		
	}
	
	/* 성별을 이용한 회원 정보 검색 (List로 조회할 것)*/
	public void searchMemberByGender(Map<String, String> parameter) {
		
		String gender = parameter.get("gender");
		
		List<MemberDTO> memberList = memberService.selectMemberByGender(gender);
		
		if(memberList != null) {
			memberResultView.display(memberList);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}
	}
	
	/* 입력받은 아이디와 일치하는 회원의 비밀번호 변경 */
	public void modifyPassword(Map<String, String> memberId, Map<String, String> memberPwd) {
		
		String id = memberId.get("id");
		String pwd = memberPwd.get("pwd");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setPwd(pwd);
//		
//		System.out.println(member);
		
		if(memberService.updatePwdById(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 이메일 변경 */
	public void modifyEmail(Map<String, String> memberId, Map<String, String> memberemail) {
				
		String id = memberId.get("id");
		String email = memberemail.get("email");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setEmail(email);
		
		if(memberService.updateEmailById(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 전화번호 변경 */
	public void modifyPhone(Map<String, String> memberId, Map<String, String> memberphone) {
		
		String id = memberId.get("id");
		String phone = memberphone.get("phone");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setPhone(phone);
		
		if(memberService.updatePhoneById(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 주소 변경 */
	public void modifyAddress(Map<String, String> memberId, Map<String, String> memberaddress) {
		
		String id = memberId.get("id");
		String address = memberaddress.get("address");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		member.setAddress(address);
		
		if(memberService.updateAddressById(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}
	
	/* 회원 정보 삭제용 메소드 */
	public void deleteMember(Map<String, String> memberId) {

		String id = memberId.get("id");
		
		MemberDTO member = new MemberDTO();
		
		member.setId(id);
		
		if(memberService.deleteMemberById(member)) {
			memberResultView.displayDmlResult("deleteSuccess");
		} else {
			memberResultView.displayDmlResult("deleteFailed");
		}
		
	}

}
