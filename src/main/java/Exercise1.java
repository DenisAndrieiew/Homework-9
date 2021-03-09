import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Exercise1 {

    public static void Validator1(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fileIO = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fileIO);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (validate(line)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Validator2(String filePath) {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buf = new char[256];
            int c;
            while ((c = fileReader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                builder.append(buf);

            }
            String[] lines = getLines(builder.toString());
            for (String line : lines) {
                if (validate(line)) {
                    System.out.println(line);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private static boolean validate(String phone) {
        if (phone == null || phone.length() == 0) {
            return false;
        }
        return isFormatOne(phone) || isFormatTwo(phone);
    }

    private static boolean isFormatOne(String phone) {
        final int[] NUMBER_POSITIONS = {1, 2, 3, 6, 7, 8, 10, 11, 12, 13};
        char[] line = phone.toCharArray();
        if (line[0] != '(' || line[4] != ')' || line[5] != ' ' || line[9] != '-') {
            return false;
        }
        for (int i = 0; i < NUMBER_POSITIONS.length; i++) {
            if (line[NUMBER_POSITIONS[i]] < 48 || line[NUMBER_POSITIONS[i]] > 57) {
                return false;
            }

        }
        return true;
    }

    private static boolean isFormatTwo(String phone) {
        final int[] NUMBER_POSITIONS = {0, 1, 2, 4, 5, 6, 8, 9, 10, 11};

        char[] line = phone.toCharArray();
        if (line[3] != '-' || line[7] != '-') {
            return false;
        }
        for (int i = 0; i < NUMBER_POSITIONS.length; i++) {
            if (line[NUMBER_POSITIONS[i]] < 48 || line[NUMBER_POSITIONS[i]] > 57) {
                return false;
            }

        }
        return true;
    }

    private static String[] getLines(String text) {
        List<String> list = new Stack<String>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= text.length() - 1; i++) {
            while (text.charAt(i) != '\r' && i < text.length() - 1) {
                builder.append(text.charAt(i));
                i++;
            }
            if (builder.length() != 0) {
                list.add(builder.toString());
            }
            builder.setLength(0);
            i++;
        }
        String[] lines = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lines[i] = list.get(i);
        }
        return lines;
    }

}
