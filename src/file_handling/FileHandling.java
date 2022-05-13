package file_handling;

import directory_management.Directory;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileHandling {

    public void writeFile(List<Directory> list) throws IOException {
        FileWriter fw = new FileWriter("src\\data_file\\directory.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        String a = "Tên,Số Điện Thoại,Nhóm,Giới Tính,Địa Chỉ,Email,Ngày Sinh\n";
        for (Directory d : list) {
            a += d.getName() + ","
                    + d.getPhoneNumber() + ","
                    + d.getGroup() + ","
                    + d.getGender() + ","
                    + d.getAddress() + ","
                    + d.getEmail() + ","
                    + d.getDateOfBirth() + '\n';
        }
        bw.write(a);
        bw.close();
        fw.close();
    }

    public void readFile(List<Directory> list) throws Exception {
        FileReader fw = new FileReader("src\\data_file\\directory.csv");
        Scanner sc = new Scanner(fw);
        list.clear();

            while (sc.hasNext()) {
                if (sc.nextLine() != null){
                String s = sc.nextLine();
                System.out.println(s);
                String[] arr = s.split(",");
                Directory directory = new Directory(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);

                list.add(directory);
            }else {
                    throw new Exception();
                }
        }
    }

}
