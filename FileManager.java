package KiemtraTH;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "MONHOC.DAT";

    public static void saveToFile(List<MonHoc> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(data);
            System.out.println("Dữ liệu đã được lưu vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu vào file.");
        }
    }

    public static List<MonHoc> readFromFile() {
        List<MonHoc> data = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            data = (List<MonHoc>) ois.readObject();
            System.out.println("Dữ liệu đã được đọc từ file.");
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại. Tạo mới dữ liệu.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file.");
        }
        return data;
    }
}

