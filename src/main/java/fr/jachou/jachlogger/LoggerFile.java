package fr.jachou.jachlogger;

import java.io.*;

public class LoggerFile {

    String newLine = System.getProperty("line.separator");
    private String name;
    private String path;
    private File file;
    private FileWriter Filewriter;
    private BufferedWriter writer;

    public LoggerFile(String FileName, String location) throws IOException {
        path = location;
        name = FileName + ".txt";
        file = new File(path, name);

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public String getFileName() {
        return name;
    }

    public String getLocation() {
        return path;
    }

    public File getFile() {
        return file;
    }

    public void write(String text) throws IOException {
        Filewriter = new FileWriter(file, true);
        writer = new BufferedWriter(Filewriter);
        writer.write(text);
        writer.newLine();
        writer.close();
    }

    public String getLogs() throws IOException {
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(isr);

        String line = buffer.readLine();
        StringBuilder builder = new StringBuilder();

        while(line != null){
            builder.append(line).append("\n");
            line = buffer.readLine();
        }

        String str = builder.toString();
        return str;
    }
}
