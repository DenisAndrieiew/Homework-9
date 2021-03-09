import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String FILE_PATH1 = "D:\\Users\\Eretar\\IdeaProjects\\Homework-9\\src\\main\\java\\Testing\\file.txt";
        final String FILE_PATH2 = "D:\\Users\\Eretar\\IdeaProjects\\Homework-9\\src\\main\\java\\Testing\\file2.txt";
        final String PATH_TO_JSON = "D:\\Users\\Eretar\\IdeaProjects\\Homework-9\\src\\main\\java\\Testing\\user.json";
        final String FILE_PATH3 = "D:\\Users\\Eretar\\IdeaProjects\\Homework-9\\src\\main\\java\\Testing\\words.txt";
        {
            System.out.println("***************\ntesting validator, type 1 (through FileInputStream" +
                    "& scanner):");

            Exercise1.Validator1(FILE_PATH1);
            System.out.println("finishing testing validator type 1\n***************");
        }
        {
            System.out.println("testing validator type2 (through FileReader & own parsing method):");
            Exercise1.Validator2(FILE_PATH1);
            System.out.println("finishing testing validator type 2\n***************");
        }
        {
            System.out.println("testing exercise 2");
            System.out.println("reading users from file...");
            List<User> users = Exercise2.getUsersFromFile(FILE_PATH2);
            System.out.println("reading ok");
            System.out.println("writing to JSON file");
            Exercise2.writeToJSON(PATH_TO_JSON, users);
            System.out.println("writing is OK");
            System.out.println("trying deserialised person from JSON");
            users = Exercise2.getUsersFromJSONFile(PATH_TO_JSON);
            for (User us : users) {
                System.out.println(us);
            }
            System.out.println("finishing testing exercise 2\n***************");
        }
        {
            System.out.println("testing exercise 3");
            Exercise3.wordCounter(FILE_PATH3);
            System.out.println("testing complete!\n***************");
        }
    }
}
