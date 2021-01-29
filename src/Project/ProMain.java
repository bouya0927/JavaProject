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
			System.out.println("  \t\t\t\t 1.�α���             \t\t\t\t\t\t  2.ȸ������");
			System.out.println("  \t\t\t\t 3.����������       \t\t\t\t\t\t  4.���Ӱ˻�");
			System.out.println("  \t\t\t\t 5.���ӱ���          \t\t\t\t\t\t  6.�����������");
			System.out.println("  \t\t\t\t 7.������������    \t\t\t\t\t\t  8.�α׾ƿ�");
			System.out.println("");

			System.out.print(" \t\t\t\t �޴����� �� �� �� ��   ");

			menu = sc.nextInt();
			server.connect();
			switch (menu) {

			case 1:
				System.out.println("[ �� �� �� ] ");
				System.out.println("���̵� �� ��й�ȣ�� �Է����ּ���.");
				System.out.println("");
				System.out.print("�� �� �� : ");
				String userId = sc.next();
			
				System.out.print("��й�ȣ  : ");
				String userPw = sc.next();
				
				boolean userPro = server.userProfile(userId, userPw);

				break;

			case 2:
				int userNumber = server.userNumber() + 1;

				System.out.println("[ ȸ �� �� ��  ]");

				System.out.print("�� �� �� : ");
				userId = sc.next();

				System.out.print("��й�ȣ : ");
				userPw = sc.next();

				System.out.print("��  �� : ");
				String userName = sc.next();

				System.out.print("��   �� : ");
				String userAge = sc.next();

				System.out.print("E-Mail : ");
				String userEmail = sc.next();

				System.out.print("�̿밡���� ���� :");
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
				System.out.println("[ �� �� �� �� �� ]");
				System.out.println("");
				System.out.print("�� �� �� : ");
				userId = sc.next();		
				System.out.print("��й�ȣ:");
				userPw = sc.next();
				
				server.userImformation(userId,userPw);
				
				break;
			case 4:
				System.out.println("[ �� �� �� �� ]");
				System.out.println("===============================");
				System.out.println(" �׼� | �ε�  | ����  | �ùķ��̼� | ���̽� ");
				System.out.println("===============================");
				System.out.println("");
				System.out.print("�帣�� �˻� ���ּ��� �������� ");
				
				String searchGam = sc.next();
				
				server.gameSearch(searchGam);
				
				break;
			
			case 5:
				System.out.println("\t\t\t[���Ӹ� ]");
				System.out.println("\t\t  ��������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  �� @ AMONG US  @ HADES  @ UBORT  @ ���嵥�帮����2	                 ��");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  �� @ CITIES:SKYLINES @ SKUL  @ XCOM2 @ ��������                                   ��");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  �� @ F1��2021 @ STARDEW VALLEY @ �ϵ��� ���ǵ�  @ ����                                      ��");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  �� @ FIFA 21 @ THE SIMS4 @ �� ũ���2 @ �ﱹ��14 @ ���������꿥���̾�        ��");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  �� @ GTA��@ TOTALWAR  @ �帮��Ʈ    @ �Ƽ�Ʈ�ڸ��� @ ��������                         ��");
				System.out.println("\t\t  ��                                                              ��");
				System.out.println("\t\t  ��������������������������������������������������������������������������������������������������������������������������������");

				System.out.print("���� ����ϴ� ���� ��������");
				String gameName = sc.next();
				
				System.out.print("���¹�ȣ�� �Է����ּ���. ��������");
				userAccount = sc.next();
				
				server.purchase(gameName,userAccount);
				
				break;
			
			case 6:
				System.out.println("[ �� �� �� ��  �� �� ]");
				System.out.println("");
				System.out.print("���¹�ȣ�� �Է����ּ���. : ");
				userAccount = sc.next();
				System.out.println("");
				System.out.print("�Ա��Ͻ� �ݾ� : ");
				int userBalance = sc.nextInt();
				
				user.setUserAccount(userAccount);
				user.setUserBalance(userBalance);
				
				server.deposit(user);
				
				break;
			
			case 7:
				System.out.println("[ ȸ �� �� �� �� �� ]");
				System.out.println("");
				
				System.out.print("ȸ�� ���̵� :");
				userId = sc.next();
				user.setUserId(userId);
				
				System.out.print("��й�ȣ �Է� : ");
				userPw = sc.next();
				user.setUserPw(userPw);
				
				System.out.println("");
				System.out.println("�����Ͻ� ������ �Է��� �ּ���.");
				System.out.println("");
				
				System.out.print("��     �� :" );
				userName = sc.next();
				user.setUserName(userName);
				
				System.out.print("��     �� :");
				userAge = sc.next();
				user.setUserAge(userAge);
				
				System.out.print("�̸��� :");
				userEmail = sc.next();
				user.setUserEmail(userEmail);
				
				System.out.print("���¹�ȣ :");
				userAccount = sc.next();
				user.setUserAccount(userAccount);
				
				server.userProEX(user);
				break;
			
			case 8 :
				run = false;
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				break;
				
			default:

				System.out.println("�Է��� �߸�����ϴ�. �ٽ� Ȯ�����ּ���.");

				break;

			}

		}

	}

}
