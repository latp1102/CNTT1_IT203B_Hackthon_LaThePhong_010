package b10.presentation;

import b10.business.UserBusiness;
import b10.entity.User;

import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserBusiness userBusiness = UserBusiness.getInstance();
        int choice;
        do {
            System.out.println("menu");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Lọc ADMIN");
            System.out.println("7. Sắp xếp giảm dần");
            System.out.println("8. Thoát chương trình");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    userBusiness.displayUser();
                    break;
                case 2:
                    User user = new User();
                    user.inputData(sc);
                    userBusiness.add(user);
                    break;
                case 3:
                    System.out.println("Nhâp id: ");
                    userBusiness.update(sc.nextLine(), sc);
                    break;
                case 4:
                    System.out.println("Nhấp id: ");
                    userBusiness.delete(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Nhập tên: ");
                    userBusiness.search(sc.nextLine());
                    break;
                case 6:
                    userBusiness.filterAdmin();
                    break;
                case 7:
                    userBusiness.sortGiam();
                    break;
                case 8:
                    System.out.println("Thoát chường trình");
                    break;
                default:
                    System.out.println("Lựa chọn ko hợp lệ");
            }
        }while (choice != 8);
    }
}
