import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void mkDirMyProject(String namePath, boolean dirOrFile) {
        // если false то проверяем и создаем директорию, при true работаем с файлом
        if (dirOrFile) {
            File myFile = new File(namePath);
            if (myFile.isFile()) {
                stringBuilder.append("Файл " + namePath + " существует").append(System.lineSeparator());
            } else {
                try {
                    if (myFile.createNewFile()) {
                        stringBuilder.append("Файл " + namePath + " был создан").append(System.lineSeparator());
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            File dir = new File(namePath);
            if (dir.isDirectory()) {
                stringBuilder.append("Каталог " + namePath + " существует").append(System.lineSeparator());
            } else {
                if (dir.mkdir()) {
                    stringBuilder.append("Каталог " + namePath + " создан").append(System.lineSeparator());
                }
            }
        }


    }

    public static void writeFile(String pathFile, StringBuilder str) {
        //Запишем в файл текст
        try (FileWriter writer = new FileWriter(pathFile, false)) {
            writer.write(str.toString());
            writer.flush();
            System.out.println("Файл "+pathFile+" перезаписан.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void main(String[] args) {

        File dir = new File("F://Games");
        if (dir.isDirectory()) {
            // Создаем последовательно директории scr, res, savegames, temp
            mkDirMyProject(dir.getPath() + "//scr", false);
            // Создаем  директории  в каталоге scr, main и test
            mkDirMyProject(dir.getPath() + "//scr//test", false);
            mkDirMyProject(dir.getPath() + "//scr//main", false);
            // Создаем в каталоге main два файла Main.java  и Utils.java
            mkDirMyProject(dir.getPath() + "//scr//main//Main.java", true);
            mkDirMyProject(dir.getPath() + "//scr//main//Utils.java", true);
            mkDirMyProject(dir.getPath() + "//res", false);
            // Создаем  директории  в каталоге res, drawable и vectors и icons
            mkDirMyProject(dir.getPath() + "//res//drawable", false);
            mkDirMyProject(dir.getPath() + "//res//vectors", false);
            mkDirMyProject(dir.getPath() + "//res//icons", false);
            mkDirMyProject(dir.getPath() + "//savegames", false);
            mkDirMyProject(dir.getPath() + "//temp", false);
            // Создаем в каталоге temp  файл temp.txt
            mkDirMyProject(dir.getPath() + "//temp//temp.txt", true);
            // записываем в файл информацию о работе
            writeFile(dir.getPath() + "//temp//temp.txt", stringBuilder);

        }

    }

}

