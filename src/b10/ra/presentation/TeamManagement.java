package b10.ra.presentation;

import b10.ra.business.TeamBusiness;
import b10.ra.entity.Team;

import java.util.Scanner;

public class TeamManagement {
    public static void main(String[] args) {
        TeamBusiness teamBusiness = TeamBusiness.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== QUẢN LÝ ĐỘI THI KÉO CO =====");
            System.out.println("1. Hiển thị danh sách toàn bộ đội thi");
            System.out.println("2. Thêm mới đội thi");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã đội thi");
            System.out.println("4. Xóa sinh viên theo mã đội");
            System.out.println("5. Tìm kiếm sinh viên theo mã đội");
            System.out.println("6. Tìm ứng viên vô địch dựa trên cân nặng trung bình");
            System.out.println("7. Sắp xếp danh sách đội thi giảm dần theo cân nặng trung bình");
            System.out.println("8. Thoát lựa chọn của bạn: ");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    teamBusiness.displayTeam();
                    break;
                case 2:
                    Team team = new Team();
                    team.inputData(scanner);
                    teamBusiness.add(team);
                    break;
                case 3:
                    System.out.println("Nhập id team mới: ");
                    teamBusiness.updateTeam(scanner.nextLine(), scanner);
                    break;
                case 4:
                    System.out.println("Nhập id team xóa: ");
                    teamBusiness.deleteTeam(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Nhập tên tìm kiếm: ");
                    teamBusiness.searchTeam(scanner.nextLine());
                    break;
                case 6:
                    teamBusiness.filter();
                    break;
                case 7:
                    teamBusiness.sortAverageWeight();
                    break;
                case 8:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }while (choice != 8);
    }
}
