package com.arsha.fundamentals.io;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IODemo1 {

    public static void main(String[] args) {

        // Get desktop path
        FileSystemView view = FileSystemView.getFileSystemView();
        String configFolderPath = view.getHomeDirectory().getAbsolutePath() + File.separator + "Configs";
        String configFilePath = configFolderPath + File.separator + "DatabaseConfigs.txt";

        try {
            createConfigFile(configFolderPath, configFilePath);
            String result1 = getValueFromConfigMap(Paths.get(configFilePath), "test");
            String result2 = getValueFromConfigMap(Paths.get(configFilePath), "database.user");
            String result3 = getValueFromConfigMap_NIO_Version(Paths.get(configFilePath), "discount");
            String result4 = getValueFromConfigMap_NIO_Version(Paths.get(configFilePath), "test");
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean createFolder(String path) {
        File configFolder = new File(path);
        return configFolder.mkdirs();
    }

    private static boolean createFile(String path) throws IOException {
        File file = new File(path);
        return file.createNewFile();
    }

    private static void writeFile(String path, String content) throws IOException {
        try (var bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(content);
        }
    }

    private static List<String> getAllLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        try (var bw = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bw.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void createConfigFile(String directoryPath, String configFilePath) throws IOException {

        String config =
                """
                        discount=0.1
                        database.user=admin
                        database.password=qwerty
                        """;

        if (!Files.exists(Paths.get(directoryPath))) {

            if (!createFolder(directoryPath)) {
                throw new IOException(directoryPath + " could not be created");
            }

            if (!createFile(configFilePath)) {
                throw new IOException(configFilePath + " could not be created");
            }

            writeFile(configFilePath, config);
        }
    }

    public static String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
        List<String> lines = getAllLines(configMapFilePath.toString());
        for (String line : lines) {
            if (line.contains(keyName)) {
                return line.split( "=")[1];
            }
        }
        return "Not found";
    }

    public static String getValueFromConfigMap_NIO_Version(Path configMapFilePath, String keyName) throws IOException {
        Map<String, String> collection = Files.lines(configMapFilePath)
                .collect(Collectors.toMap(line -> line.split("=")[0], s -> s.split("=")[1]));
        return collection.get(keyName);
    }
}
