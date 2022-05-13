package menu;

import directory_management.ManageDirectory;
import exception_handling.ExceptionHandling;
import file_handling.FileHandling;
import java.util.Scanner;

public class MenuHandling {
    public static final int FIRST_CHOICE = 1;
    public static final int SECOND_CHOICE = 2;
    public static final int THIRD_CHOICE = 3;
    public static final int FOURTH_CHOICE = 4;
    public static final int FIFTH_CHOICE = 5;
    public static final int SIXTH_CHOICE = 6;
    public static final int SEVENTH_CHOICE = 7;
    public static final int EXIT_CHOICE = 8;
    Scanner sc = new Scanner(System.in);
    FormMenu formMenu = new FormMenu();
    ManageDirectory manageDirectory = new ManageDirectory();
    FileHandling fileHandling = new FileHandling();
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    public MenuHandling() throws Exception {
    }

    public void showMainMenu() throws Exception {
        int choice;
        formMenu.showMenu();
        do {
            choice = exceptionHandling.checkInputOfInteger("Nhập Lựa Chọn: ");
            switch (choice){
                case FIRST_CHOICE:
//                            writeAndReadFile.writeList("C:\\Users\\hongh\\IdeaProjects\\quan_ly_danh_ba\\src\\data\\directory.csv", managePerson.list);
                    if (manageDirectory.getList().size() != 0){
                        manageDirectory.printAll();
                    } else {
                        System.out.println("Danh sách trống!!!");
                    }
                    break;
                case SECOND_CHOICE:
                    manageDirectory.add();
                    break;
                case THIRD_CHOICE:
                    System.out.print("Nhập SĐT cần sửa: ");
                    String phoneNumber = sc.nextLine();
                    manageDirectory.edit(phoneNumber);
                    break;
                case FOURTH_CHOICE:
                    System.out.print("Nhập tên người cần xóa: ");
                    String nameDelete = sc.nextLine();
                    manageDirectory.remove(nameDelete);
                    break;
                case FIFTH_CHOICE:
                    System.out.print("Nhập tên người cần xem: ");
                    String name = sc.nextLine();
                    manageDirectory.findByName(name);
                    break;
                case SIXTH_CHOICE:
                    fileHandling.readFile(manageDirectory.getList());
                    break;
                case SEVENTH_CHOICE:
                    fileHandling.writeFile(manageDirectory.getList());
                    System.out.println("Đã ghi xong.");
                    break;
                case EXIT_CHOICE:
                    System.exit(0);
                default:
                    System.out.println("Yêu cầu nhập lại 0 > 8: ");
            }
        } while (true);

    }

    }
