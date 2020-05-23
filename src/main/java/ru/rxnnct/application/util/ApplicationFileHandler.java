package ru.rxnnct.application.util;

import com.google.gson.Gson;
import ru.rxnnct.application.GameStateForSaves;
import ru.rxnnct.application.characters.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationFileHandler {
    private static ApplicationFileHandler ourInstance = new ApplicationFileHandler();

    private final String SAVE_SCORE_PATH = "saves" + File.separator + "score.sav";
    private final String SAVE_GAME_PATH = "saves" + File.separator + "save.sav";
    private List<String> scoreList = new ArrayList<>();
    private Gson gson = new Gson();

    //constructors
    private ApplicationFileHandler() {
    }
    //instance
    public static ApplicationFileHandler getInstance() {
        return ourInstance;
    }

    //accessors
    public List<String> getScoreList() {
        return scoreList;
    }

    //methods
    public void saveScore() throws IOException {
        loadScore();
        scoreList.add(Player.getInstance().getScore() + " - points (" + new SimpleDateFormat("dd.MM.yyyy hh:mm").format(new Date()) + ")");
        if (scoreList.size() > 10) scoreList.remove(0);
        String json = gson.toJson(scoreList);
        writeFileWithEncryption(SAVE_SCORE_PATH, json);
    }

    public void loadScore() throws IOException {
        String fromFile = readFileWithDecryption(SAVE_SCORE_PATH);
        scoreList = gson.fromJson(fromFile, scoreList.getClass());
    }
    
    public void saveGame() throws IOException {
        GameStateForSaves gameState = new GameStateForSaves();
        String json = gson.toJson(gameState);
        writeFileWithEncryption(SAVE_GAME_PATH, json);
    }

    public void loadGame() throws IOException {
        String fromFile = readFileWithDecryption(SAVE_GAME_PATH);
        GameStateForSaves gameState = new GameStateForSaves();
        gameState = gson.fromJson(fromFile, gameState.getClass());
        //
        //...
        //
    }

    private void writeFileWithEncryption(String filePath, String json) throws IOException {
        byte[] toFile = Encoder.getInstance().encrypt(json);
        Path path = Paths.get(filePath);
        Files.write(path, toFile);
    }

    private String readFileWithDecryption(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        File file = new File(String.valueOf(path));
        byte[] toFile = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(toFile);
        fileInputStream.close();
        String fromFile = Encoder.getInstance().decrypt(toFile);
        return fromFile;
    }
}
