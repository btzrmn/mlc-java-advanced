package class04.exercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String folder = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File file = new File(folder);

        long count = dfs(file);
        System.out.println("Folder size: " + count);
    }

    private static long dfs(File file) {
        if (!file.isDirectory()) {
            return file.length();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                return dfs(f);
            }
            return 0l;
        }
    }
}
