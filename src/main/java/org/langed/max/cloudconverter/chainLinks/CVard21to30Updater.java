package org.langed.max.cloudconverter.chainLinks;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 08.02.18.
 */
public class CVard21to30Updater {

    public static final String OLD_VERSION = "VERSION:2.1";
    public static final String NEW_VERSION = "VERSION:3.0";

    private String outFolderName;
    public CVard21to30Updater(String outFolderName) {
        this.outFolderName = outFolderName;
    }

    public void process(String[] in) {
//        System.out.print("Updating " + in.getName());
//
//        File outFile = new File(outFolderName + in.getName());
//
//        try (BufferedReader vCardStrings = new BufferedReader( new FileReader(in));
//             BufferedWriter out = new BufferedWriter(new FileWriter(outFile))
//
//        ) {
//
//
//            /*
//                Задачи:
//                    1. Обновить версию
//                    2. Добавить, если нет, поле FN и вставить ему значение.
//             */
//
//
//
//            String line;
//            StringBuilder buffer = new StringBuilder();
//            boolean fnExists = false;
//            String fn = null;
//            while ((line = vCardStrings.readLine()) != null) {
//                if(line.equals(OLD_VERSION)) {
//                    buffer.append(NEW_VERSION).append("\n");
//                }
//                else if (line.startsWith("N:")) {
//
//                    Pattern pattern =
//                            Pattern.compile("N:([^;]*);.*");
//
//                    Matcher matcher =
//                            pattern.matcher(line);
//
//                    if (matcher.matches()) fn = matcher.group(1);
//
//                    buffer.append(line).append("\n");
//                }
//                else if (line.startsWith("FN:")) {                  // флаг вставляем
//                    fnExists = true;
//                    buffer.append(line).append("\n");
//                }
//                else if (line.startsWith("END:") && !fnExists ) {   // если поле "FN" так и не появилось — генерируем и вставляем.
//
//                    buffer.append("FN:").append(fn).append("\n");
//                    buffer.append(line).append("\n");
//                }
//                else buffer.append(line).append("\n");              // в остальных случаях пропускаем строку как есть
//
//            }
//
//            out.write(buffer.toString());
//
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        System.out.println ("\t\t DONE!");
    }

}
