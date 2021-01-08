package bhat.bhat.util;

import bhat.bhat.Bhat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

public class Function {

    public static void makeFile(File f) {
        if (!f.exists() || !f.isFile()) {
            try {
                f.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void loadString(Bhat agora, HashMap<UUID,String> hash, String jsonname){
        makeFile(new File(agora.getDataFolder(), jsonname+".json"));
        new File(agora.getDataFolder(), jsonname+".json").mkdir();

        JSONParser parser = new JSONParser();
        try {
            if(new FileReader(new File(agora.getDataFolder(), jsonname+".json")).ready()) {
                Object obj = parser.parse(new FileReader(new File(agora.getDataFolder(), jsonname+".json")));
                JSONObject jsonObject = (JSONObject) obj;
                jsonObject.forEach((key, value) ->
                        hash.put( UUID.fromString(key+""), String.valueOf(value))
                );
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void save(Bhat agora, HashMap<?,?> hash, String jsonname) {
        JSONObject data = new JSONObject();
        hash.forEach((key, value) -> {
            data.put(key, "" + value);

        });
        try {
            BufferedWriter UniOutput = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(new File(agora.getDataFolder(), jsonname + ".json").getPath()),
                            "UTF8"
                    )
            );
            UniOutput.write(data.toJSONString());

            UniOutput.flush();
            UniOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
