package Project;

import java.util.Scanner;

public class ProMain {

	public static void main(String[] args) {

		ProDTO user = new ProDTO();

		ProDAO server = new ProDAO();

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		int menu = 0;

		System.out.println(" \r\n" + 
				"        ::::::::           :::          :::   :::       ::::::::::      :::       :::       ::::::::       :::::::::       :::        ::::::::: \r\n" + 
				"      :+:    :+:        :+: :+:       :+:+: :+:+:      :+:             :+:       :+:      :+:    :+:      :+:    :+:      :+:        :+:    :+: \r\n" + 
				"     +:+              +:+   +:+     +:+ +:+:+ +:+     +:+             +:+       +:+      +:+    +:+      +:+    +:+      +:+        +:+    +:+  \r\n" + 
				"    :#:             +#++:++#++:    +#+  +:+  +#+     +#++:++#        +#+  +:+  +#+      +#+    +:+      +#++:++#:       +#+        +#+    +:+   \r\n" + 
				"   +#+   +#+#      +#+     +#+    +#+       +#+     +#+             +#+ +#+#+ +#+      +#+    +#+      +#+    +#+      +#+        +#+    +#+    \r\n" + 
				"  #+#    #+#      #+#     #+#    #+#       #+#     #+#              #+#+# #+#+#       #+#    #+#      #+#    #+#      #+#        #+#    #+#     \r\n" + 
				" ########       ###     ###    ###       ###     ##########        ###   ###         ########       ###    ###      ########## #########       \r\n" + 
				"");
		System.out.println("=========================================================================================================================================");

		

		while (run) {

			System.out.println("\t\t\t\t\t=========================================");
			System.out.println(" \r\n" +
					"\t\t\t\t\t  ##     ## ######## ##    ## ##     ## \r\n" + 
					"\t\t\t\t\t  ###   ### ##       ###   ## ##     ## \r\n" + 
					"\t\t\t\t\t  #### #### ##       ####  ## ##     ## \r\n" + 
					"\t\t\t\t\t  ## ### ## ######   ## ## ## ##     ## \r\n" + 
					"\t\t\t\t\t  ##     ## ##       ##  #### ##     ## \r\n" + 
					"\t\t\t\t\t  ##     ## ##       ##   ### ##     ## \r\n" + 
					"\t\t\t\t\t  ##     ## ######## ##    ##  #######  ");
			System.out.println("\t\t\t\t\t=========================================");
			System.out.println("");
			System.out.println("  \t\t\t\t 1.로그인             \t\t\t\t\t\t  2.회원가입");
			System.out.println("  \t\t\t\t 3.마이페이지       \t\t\t\t\t\t  4.게임검색");
			System.out.println("  \t\t\t\t 5.게임구매          \t\t\t\t\t\t  6.가상계좌충전");
			System.out.println("  \t\t\t\t 7.개인정보수정    \t\t\t\t\t\t  8.로그아웃");
			System.out.println("");

			System.out.print(" \t\t\t\t 메뉴선택 ▶ ▶ ▶ ▶   ");

			menu = sc.nextInt();
			server.connect();
			switch (menu) {

			case 1:
				System.out.println("[ 로 그 인 ] ");
				System.out.println("아이디 와 비밀번호를 입력해주세요.");
				System.out.println("");
				System.out.print("아 이 디 : ");
				String userId = sc.next();
			
				System.out.print("비밀번호  : ");
				String userPw = sc.next();
				
				boolean userPro = server.userProfile(userId, userPw);

				break;

			case 2:
				int userNumber = server.userNumber() + 1;

				System.out.println("[ 회 원 가 입  ]");

				System.out.print("아 이 디 : ");
				userId = sc.next();

				System.out.print("비밀번호 : ");
				userPw = sc.next();

				System.out.print("이  름 : ");
				String userName = sc.next();

				System.out.print("나   이 : ");
				String userAge = sc.next();

				System.out.print("E-Mail : ");
				String userEmail = sc.next();

				System.out.print("이용가능한 계좌 :");
				String userAccount = sc.next();

				user.setUserId(userId);
				user.setUserPw(userPw);
				user.setUserName(userName);
				user.setUserAge(userAge);
				user.setUserEmail(userEmail);
				user.setUserAccount(userAccount);

				server.userProfile(user);

				break;
				
			case 3:
				System.out.println("[ 마 이 페 이 지 ]");
				System.out.println("");
				System.out.print("아 이 디 : ");
				userId = sc.next();		
				System.out.print("비밀번호:");
				userPw = sc.next();
				
				server.userImformation(userId,userPw);
				
				break;
			case 4:
				System.out.println("[ 게 임 검 색 ]");
				System.out.println("===============================");
				System.out.println(" 액션 | 인디  | 전략  | 시뮬레이션 | 레이싱 ");
				System.out.println("===============================");
				System.out.println("");
				System.out.print("장르를 검색 해주세요 ▶▶▶▶ ");
				
				String searchGam = sc.next();
				
				server.gameSearch(searchGam);
				
				break;
			
			case 5:
				System.out.println("\t\t\t[게임명 ]");
				System.out.println("\t\t  ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┃ @ AMONG US  @ HADES  @ UBORT  @ 레드데드리뎀션2	                 ┃");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┃ @ CITIES:SKYLINES @ SKUL  @ XCOM2 @ 몬스터헌터                                   ┃");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┃ @ F1®2021 @ STARDEW VALLEY @ 니드포 스피드  @ 문명Ⅵ                                      ┃");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┃ @ FIFA 21 @ THE SIMS4 @ 더 크루™2 @ 삼국지14 @ 에이지오브엠파이어        ┃");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┃ @ GTAⅤ@ TOTALWAR  @ 드리프트    @ 아세트코르사 @ 폴가이즈                         ┃");
				System.out.println("\t\t  ┃                                                              ┃");
				System.out.println("\t\t  ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

				System.out.print("구매 희망하는 게임 ▶▶▶▶");
				String gameName = sc.next();
				
				System.out.print("계좌번호를 입력해주세요. ▶▶▶▶");
				userAccount = sc.next();
				
				server.purchase(gameName,userAccount);
				
				break;
			
			case 6:
				System.out.println("[ 가 상 계 좌  충 전 ]");
				System.out.println("");
				System.out.print("계좌번호를 입력해주세요. : ");
				userAccount = sc.next();
				System.out.println("");
				System.out.print("입금하실 금액 : ");
				int userBalance = sc.nextInt();
				
				user.setUserAccount(userAccount);
				user.setUserBalance(userBalance);
				
				server.deposit(user);
				
				break;
			
			case 7:
				System.out.println("[ 회 원 정 보 수 정 ]");
				System.out.println("");
				
				System.out.print("회원 아이디 :");
				userId = sc.next();
				user.setUserId(userId);
				
				System.out.print("비밀번호 입력 : ");
				userPw = sc.next();
				user.setUserPw(userPw);
				
				System.out.println("");
				System.out.println("수정하실 정보를 입력해 주세요.");
				System.out.println("");
				
				System.out.print("이     름 :" );
				userName = sc.next();
				user.setUserName(userName);
				
				System.out.print("나     이 :");
				userAge = sc.next();
				user.setUserAge(userAge);
				
				System.out.print("이메일 :");
				userEmail = sc.next();
				user.setUserEmail(userEmail);
				
				System.out.print("계좌번호 :");
				userAccount = sc.next();
				user.setUserAccount(userAccount);
				
				server.userProEX(user);
				break;
			
			case 8 :
				run = false;
				System.out.println("로그아웃 되었습니다.");
				break;
				
			default:

				System.out.println("입력이 잘못됬습니다. 다시 확인해주세요.");

				break;

			}

		}

	}

}
