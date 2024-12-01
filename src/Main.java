import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

                if(option == 99){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }


        }catch (Exception e){

        }

    }
}