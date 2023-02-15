package com.greedy.member.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.greedy.member.controller.MemberController;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		
		MemberController memberController = new MemberController();
		
		do {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 성별로 회원 조회");
			System.out.println("5. 암호 수정");
			System.out.println("6. 이메일 변경");
			System.out.println("7. 전화번호 변경");
			System.out.println("8. 주소 변경");
			System.out.println("9. 회원 탈퇴");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : memberController.registNewMember(inputMember()); break;
				case 2 : memberController.selectAllMembers(); break;
				case 3 : memberController.searchMemberById(inputMemberId()); break;
				case 4 : memberController.searchMemberByGender(inputGender()); break;
				case 5 : memberController.modifyPassword(inputMemberId(), inputPassword()); break;
				case 6 : memberController.modifyEmail(inputMemberId(), inputEmail()); break;
				case 7 : memberController.modifyPhone(inputMemberId(), inputPhone()); break;
				case 8 : memberController.modifyAddress(inputMemberId(), inputAddress()); break;
				case 9 : memberController.deleteMember(inputMemberId()); break;
				case 0 : return;
				default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");
				
			}
			
		}while(true);
		
	}
	
	public static Map<String, String> inputMemberId() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 아이디 : ");
		String id = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("id", id);
		
		return parameter;
	}
	
	public Map<String, String> inputMember() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("등록할 회원의 아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("등록할 회원의 비밀번호를 입력해주세요 : ");
		String pwd = sc.nextLine();
		System.out.print("등록할 회원의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("등록할 회원의 성별을 입력해주세요 : ");
		String gender = sc.nextLine();
		System.out.print("등록할 회원의 이메일을 입력해주세요 : ");
		String email = sc.nextLine();
		System.out.print("등록할 회원의 전화번호를 입력해주세요 : ");
		String phone = sc.nextLine();
		System.out.print("등록할 회원의 주소를 입력해주세요 : ");
		String address = sc.nextLine();
		System.out.print("등록할 회원의 나이를 입력해주세요 : ");
		String age = sc.nextLine();
		
		/* 회원에 대한 모든 정보를 문자열로만 입력하고, 입력한 정보를 HashMap에 반환해서 리턴 */
		Map<String, String> map = new HashMap<>();
		
		/* 여기서는 사용자의 입력을 받아 맵에 넣는 것을 하면 됩니다. */
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("name", name);
		map.put("gender", gender);
		map.put("email", email);
		map.put("phone", phone);
		map.put("address", address);
		map.put("age", age);
		
		
		return map;
	}
	
	public static Map<String, String> inputGender() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 성별 입력(남:M/여:F) : ");
		String gender = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("gender", gender);
		
		return parameter;
	}
	
	public static Map<String, String> inputPassword() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 비밀번호 입력 : ");
		String pwd = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("pwd", pwd);
		 
		return parameter;
		
	}
	
	public static Map<String, String> inputEmail() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 이메일 입력 : ");
		String email = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("email", email);
		 
		return parameter;
	}
	
	public static Map<String, String> inputPhone() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 전화번호 입력 : ");
		String phone = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("phone", phone);
		 
		return parameter;
	}
	
	public static Map<String, String> inputAddress() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 주소 입력 : ");
		String address = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("address", address);
		 
		return parameter;
	}
	
}





















