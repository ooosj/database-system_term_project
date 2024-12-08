import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.56.2:4567/club", "osj", "qwe123");
            Statement stmt = con.createStatement();

            while(true) {
                System.out.println("\n=== MySQL Database Program ===");
                System.out.println("1. 동아리 정보 검색  2. 동아리 정보 추가");
                System.out.println("3. 동아리 정보 삭제  4. 동아리 정보 삭제");
                System.out.println("5. 학생 정보 검색  6. 학생 정보 추가");
                System.out.println("7. 학생 정보 삭제  8. 학생 정보 삭제");
                System.out.println("9. 학생 정보 검색  10. 학생 정보 추가");
                System.out.println("11. 학생 정보 삭제  12. 학생 정보 삭제");


                System.out.println("99. 종료");
                System.out.print("선택하세요: ");

                int option = scanner.nextInt();

                if (option == 1) {
                    System.out.println("\n--- 동아리 정보 검색 ---");
                    System.out.println("1. 동아리명으로 검색하기");
                    System.out.println("2. 전체 동아리 검색하기");
                    System.out.print("선택하세요: ");
                    int searchOption = scanner.nextInt();

                    if (searchOption == 1) {
                        System.out.print("검색할 동아리명을 입력하세요: ");
                        scanner.nextLine(); // 버퍼 비우기
                        String clubName = scanner.nextLine();
                        String query = "SELECT * FROM 동아리 WHERE 이름 = '" + clubName + "'";
                        ResultSet rs = stmt.executeQuery(query);

                        System.out.println("\n[검색 결과]");
                        boolean found = false;
                        while (rs.next()) {
                            found = true;
                            System.out.println("동아리 ID: " + rs.getInt("동아리id"));
                            System.out.println("동아리 이름: " + rs.getString("동아리명"));
                            System.out.println("동아리 소개: " + rs.getString("소개"));
                            System.out.println("동아리 인원수: " + rs.getInt("동아리_인원수"));
                            System.out.println("------------------------");
                        }

                        if (!found) {
                            System.out.println("해당 동아리가 존재하지 않습니다.");
                        }
                    }
                    else if (searchOption == 2) {
                        String query = "SELECT * FROM 동아리";
                        ResultSet rs = stmt.executeQuery(query);

                        System.out.println("\n[전체 동아리 목록]");
                        while (rs.next()) {
                            System.out.println("동아리 ID: " + rs.getInt("동아리id"));
                            System.out.println("동아리 이름: " + rs.getString("동아리명"));
                            System.out.println("동아리 소개: " + rs.getString("소개"));
                            System.out.println("동아리 인원수: " + rs.getInt("동아리_인원수"));
                            System.out.println("------------------------");
                        }
                    }
                    else {
                        System.out.println("잘못된 선택입니다.");
                    }
                }

                else if (option == 2) {
                    System.out.println("\n--- 동아리 정보 추가 ---");
                    scanner.nextLine();

                    System.out.print("동아리명을 입력하세요: ");
                    String clubName = scanner.nextLine();

                    System.out.print("소개를 입력하세요: ");
                    String description = scanner.nextLine();

                    System.out.print("인원수를 입력하세요: ");
                    int memberCount = scanner.nextInt();

                    String insertQuery = "INSERT INTO 동아리 (동아리명, 소개, 동아리_인원수) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(insertQuery);

                    pstmt.setString(1, clubName);
                    pstmt.setString(2, description);
                    pstmt.setInt(3, memberCount);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("동아리 정보가 성공적으로 추가되었습니다!");
                    } else {
                        System.out.println("동아리 정보 추가에 실패했습니다.");
                    }
                }

                else if (option == 99){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }


        }catch (Exception e){

        }

    }
}