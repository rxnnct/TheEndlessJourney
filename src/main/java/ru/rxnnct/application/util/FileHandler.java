package ru.rxnnct.application.util;

import com.google.gson.Gson;
import ru.rxnnct.application.characters.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileHandler {
    private static FileHandler ourInstance = new FileHandler();

    private final String SAVES_PATH = "saves" + File.separator + "score.sav";
//    private String fromFile;
//    private File file;
//    private SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public static FileHandler getInstance() {
        return ourInstance;
    }

    private FileHandler() {
    }

    public void saveScore() throws IOException {
        List<String> statsList = new ArrayList<>();
        statsList.add(Player.getInstance().getScore() + " - очков (" + new SimpleDateFormat("dd.MM.yyyy hh:mm").format(new Date()) + ")");
        if (statsList.size() > 10) statsList.remove(0);
        Path path = Paths.get(SAVES_PATH);
        String json = new Gson().toJson(statsList);
        byte[] toFile = Encoder.getInstance().encrypt(json);
        Files.write(path, toFile);
        System.out.println(path + " " + toFile);
    }

    public void loadScore() throws IOException {

    }


}
