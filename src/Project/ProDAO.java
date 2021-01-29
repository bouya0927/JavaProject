package Project;

import java.sql.*;

public class ProDAO {

	Connection conn = null;

	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;

	ResultSet rs = null;
	ResultSet rs1 = null;

	public void connect() {

		conn = DBPro.DBConnect();

	}

	public void conClose() {

		try {
			conn.close();
		} catch (SQLException se) {

			se.printStackTrace();
		}
	}
	// ������ ���̽� ���� / ����

	// ȸ������
	// �α���
	public int userNumber() {

		String sql = "SELECT COUNT(*) FROM GAME ";
		int userNum = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userNum = rs.getInt(1);
			}
		} catch (SQLException se) {

			se.printStackTrace();
		}
		return userNum;

	}

	// ������
	public void userProfile(ProDTO user) {
		String sql = "INSERT INTO GAME VALUES(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserAge());
			pstmt.setString(5, user.getUserEmail());
			pstmt.setString(6, user.getUserAccount());
			pstmt.setInt(7, user.getUserBalance());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("���ԿϷ�");
			} else {
				System.out.println("���Խ���!");
			}
		} catch (SQLException se) {

			se.printStackTrace();
		}

	}

	// ������� �Ա�
	public void deposit(ProDTO user) {

		String sql = "UPDATE GAME SET USER_BALANCE = USER_BALANCE + ? WHERE USER_ACCOUNT = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, user.getUserBalance());
			pstmt.setString(2, user.getUserAccount());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("������� ��õ�Ϸ�");
			} else {
				System.out.println("��������! ���¸� �ٽ� Ȯ�����ּ���.");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return;
	}

	public String checkProfile(String userId) {
		String sql = "SELECT*FROM PRODTO";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.print("���̵� : " + rs.getString(1));
				System.out.println("�̸� : " + rs.getString(2));
				System.out.println("���� : " + rs.getString(3));
				System.out.println("�̸��� : " + rs.getString(4));

			}

		} catch (SQLException se) {

			se.printStackTrace();
		}

		return null;
	}

	// �α��� Ȯ��
	public boolean userProfile(String userId, String userPw) {

		String sql = "SELECT USER_ID FROM GAME WHERE USER_ID=?";

		boolean userProfile = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				userProfile = true;
				System.out.println(userId + " �� �ȳ��ϼ���.");

			} else {
				System.out.println("���������� ��ġ ���� �ʽ��ϴ�.");
				System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");
			}
		} catch (SQLException se) {

			se.printStackTrace();
		}

		return userProfile;
	}

// ���� �˻�
	public String gameSearch(String searchGam) {

		String sql = "SELECT * FROM SALE WHERE G_GENRE = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchGam);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("�����ڵ� :" + rs.getString(1));
				System.out.println("");
				System.out.println("�����帣 :" + rs.getString(2));
				System.out.println("");
				System.out.println("�� ��  �� :" + rs.getString(3));
				System.out.println("");
				System.out.println("���ӵ�� :" + rs.getString(4));
				System.out.println("");
				System.out.println("��       �� :" + rs.getString(5));
				System.out.println("");
			}

		} catch (SQLException se) {

			se.printStackTrace();

		}
		return sql;

	}

// ����������(ȸ������ ��ȸ)
	public void userImformation(String userId, String userPw) {
		String sql = "SELECT *FROM GAME WHERE USER_ID =? AND USER_PW = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println("�� �� �� : " + rs.getString(1));
				System.out.println("��      �� : " + rs.getString(3));
				System.out.println("��      �� : " + rs.getString(4));
				System.out.println("E-MAIL: " + rs.getString(5));
				System.out.println("���¹�ȣ : " + rs.getString(6));
				System.out.println("�����ܾ�: " + rs.getString(7));
			}

		} catch (SQLException se) {

			se.printStackTrace();
		}

	}

	// ȸ����������
	public void userProEX(ProDTO user) {
		String sql = "UPDATE GAME SET USER_NAME = ?, USER_AGE = ? , " + "USER_EMAIL = ? , USER_ACCOUNT = ? "
				+ "WHERE USER_ID = ? AND USER_PW = ? ";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserAge());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserAccount());
			pstmt.setString(5, user.getUserId());
			pstmt.setString(6, user.getUserPw());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("�����Ϸ�");
			} else {
				System.out.println("��������");
			}
		} catch (SQLException se) {

			se.printStackTrace();
		}

	}
//����

	public void purchase(String gameName, String userAccount) {

		String sql1 = "SELECT G_PRICE FROM SALE WHERE G_NAME = ?";
		String sql = "UPDATE GAME SET USER_BALANCE = USER_BALANCE - ? WHERE USER_ACCOUNT = ?";

		// ���� ȸ�����̰� 19�̸��̸� 19+ ������ �����.->����

		try {
			// ���� ������ �˾ƺ��� SQL
			pstmt1 = conn.prepareStatement(sql1);

			pstmt1.setString(1, gameName);
			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				int gamePrice = rs1.getInt(1);

				// ���¿��� ���� ������ �� update
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gamePrice);
				pstmt.setString(2, userAccount);

				int result = pstmt.executeUpdate();
				

				if (result > 0) {

					System.out.println("�ŷ��� �Ϸ�Ǿ����ϴ�.");

				} else {
					System.out.println("�ܾ��� �����ϰų� ���¹��带 Ȯ�����ֽʽÿ�.");
				}

			}
		} catch (SQLException se) {

			se.printStackTrace();
		}
		
	}

}
