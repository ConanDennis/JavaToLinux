import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaToLinux {

    public static void main(String[] args) {
        Process process = null;
        String[] cmds = {"/bin/bash", "-c", "cat "};

        String filePath = "/Users/kingwufeng/workspace/LinuxChannel/data/";
        File file = new File(filePath);
        String[] fileNames = file.list();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入sort命令的具体执行方式(格式如\"-i\")");
        String sortDetail = sc.nextLine();
        System.out.println("请输入grep命令的具体执行方式及匹配内容(格式如\"-h abc\")");
        String grepDetail = sc.nextLine();
        System.out.println("请输入cut命令的具体执行方式及位数(格式如\"-b 3\")");
        String cutDetail = sc.nextLine();
        System.out.println("请输入wc命令的具体执行方式(格式如\"-c\")");
        String wcDetail = sc.nextLine();


        try {
            process = Runtime.getRuntime().exec(cmds);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));



            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }

    }

    private static String catSortExec(String fileName , String sortDetail) {

        return "cat " + fileName + " | " + "sort " + sortDetail;

    }

    private static String catGrepExec(String fileName , String grepDetail) {

        return "cat " + fileName + " | " + "grep " + grepDetail;
    }

    private static String catCutExec(String fileName , String cutDetail) {
        return "cat " + fileName + " | " + "cut " + cutDetail;
    }

    private static String catWcExec(String fileName , String wcDetail) {
        return "cat " + fileName + " | " + "cut " + wcDetail;
    }

}
