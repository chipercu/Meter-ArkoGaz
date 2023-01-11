package ru.fuzzy.meter.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.controlsfx.control.GridCell;
import org.kordamp.bootstrapfx.BootstrapFX;
import ru.fuzzy.meter.HelloApplication;
import ru.fuzzy.meter.model.Meter;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MeterList {

    private List<Meter> meterList = new ArrayList<>();
    private final Type itemsListType = new TypeToken<List<Meter>>() {}.getType();

    private static MeterList instance;

    public MeterList() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Meter.json"));
            //System.out.println(br.readLine());
            final String s = br.readLine();
            //final Object o = new Gson().fromJson(s, this.itemsListType);
            //System.out.println(s);
            //System.out.println(o);
            this.meterList = new Gson().fromJson(s,this.itemsListType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static MeterList getInstances() {
        if (instance == null) {
            instance = new MeterList();
            instance.meterList.toString();
//            final List<Meter> meters = Collections.singletonList(gson.fromJson(br, Meter.class));
//            if (!meters.isEmpty()){
//                instance.meterList = meters;
//            }


        }
        return instance;
    }

    public List<Meter> getMeterList() {
        return meterList;
    }

    public void addMeter(Meter meter) {
        meterList.add(meter);
        saveToJson();
    }


    public void saveToJson() {
        Gson gson = new Gson();
     try {

            final String s;
            try (FileWriter fileWriter = new FileWriter("Meter.json")) {
                s = gson.toJson(getMeterList());
                fileWriter.write(s);
                fileWriter.flush();
            }
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
