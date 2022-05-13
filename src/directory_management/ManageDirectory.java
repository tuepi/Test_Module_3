package directory_management;

import file_handling.FileHandling;
import validate_handling.DetailValidate;
import validate_handling.ValidateAll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDirectory {
    Scanner sc = new Scanner(System.in);
    FileHandling fileHandling = new FileHandling();
    ValidateAll validateAll = new ValidateAll();
    private List<Directory> list = new ArrayList<>();

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String PHONE_NUMBER_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";

    public ManageDirectory() throws Exception {
        fileHandling.readFile(list);
    }

    public List<Directory> getList() {
        return list;
    }

    public void setList(List<Directory> list) {
        this.list = list;
    }

    public Directory creatDirectory(){
        System.out.println("Nhập thông tin: ");
        System.out.print("Nhập Họ tên: ");
        String name = sc.nextLine();
        boolean checkPhoneNumber = false;
        String phoneNumber = null;
        while (!checkPhoneNumber) {
            System.out.print("Nhập Số Điện Thoại: ");
            phoneNumber = sc.nextLine();
            checkPhoneNumber = validateAll.validate(new DetailValidate(PHONE_NUMBER_REGEX, "Không Đúng Định Dạng"), phoneNumber);
        }
        System.out.print("Nhập Nhóm: ");
        String group = sc.nextLine();
        System.out.print("Nhập Giới tính: ");
        String gender = sc.nextLine();
        System.out.print("Nhập Địa chỉ: ");
        String address = sc.nextLine();
        boolean checkEmail = false;
        String email = null;
        while (!checkEmail) {
            System.out.print("Nhập Email: ");
            email = sc.nextLine();
            checkEmail = validateAll.validate(new DetailValidate(EMAIL_REGEX, "Nhập chưa đúng định dạng!"), email);
        }
        System.out.print("Nhập Ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        return new Directory(name, phoneNumber, group, gender, address, email, dateOfBirth);
    }

    public void add() throws IOException {
        Directory directory = creatDirectory();
        list.add(directory);
        fileHandling.writeFile(list);
        System.out.println("ĐÃ THÊM THÀNH CÔNG!!!");
    }

    public int findIndexByPhoneNumber(String phoneNumber){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phoneNumber)){
                return i;
            }
        }
        return -1;
    }

    public void findByPhoneNumber(String phoneNumber){
        System.out.println("Nhập số điện thoại cần tìm: ");
        int count = 0;
        for (Directory d : list) {
            if (d.getPhoneNumber().equals(phoneNumber)){
                count++;
                System.out.println(d);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy số điện thoại vừa nhập!!!");
        }
    }

    public void findDirectoryByPhoneNumber(String phoneNumber){
        if (findIndexByPhoneNumber(phoneNumber) != -1) {
            System.out.println("Thông tin người cần tìm là:");
            System.out.println(list.get(findIndexByPhoneNumber(phoneNumber)));
        } else {
            System.out.println("Không tồn tại SĐT: " + phoneNumber);
        }
    }

    public void findByName(String name){
        int count = 0;
        for (Directory d : list) {
            if (d.getName().contains(name)){
                count++;
                System.out.println(d);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy!!!");
        }
    }

    public void edit(String phoneNumber) {
        if (findIndexByPhoneNumber(phoneNumber) != -1){
            System.out.println("Cần sửa thành: ");
            Directory directory = creatDirectory();
            list.set(findIndexByPhoneNumber(phoneNumber), directory);
            System.out.println("ĐÃ SỬA THÀNH CÔNG");
        } else {
            System.out.println("Không tồn tại SĐT: " + phoneNumber);
        }
    }

    public void remove(String phoneNumber) {
        if (findIndexByPhoneNumber(phoneNumber) != -1){
            list.remove(findIndexByPhoneNumber(phoneNumber));
            System.out.println("ĐÃ XÓA THÀNH CÔNG!!!");
        } else {
            System.out.println("Không tồn tại SĐT: " + phoneNumber);
        }
    }

    public void printAll() {
        for (Directory directory : list) {
            System.out.println(directory);
        }
    }

}
