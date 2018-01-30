import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaToLinux {

    public static void main(String[] args) {
        Process process = null;
        String[] cmds = {"/bin/bash", "-c", "cat LinuxChannel.iml"};
        //Scanner sc = null;
        try {
            process = Runtime.getRuntime().exec(cmds);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer sb = new StringBuffer();

            String fileName = " LinuxChannel.iml";
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
}
