package com.sony.assignment.unification;

import com.sony.assignment.model.Byteland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseHandler {

    private static final String SEPARATOR = " ";

    public void handle() {
        List<Byteland> cases = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            final int caseCount = getCaseCount(reader);

            for (int i = 0; i < caseCount; i++) {
                cases.add(getBytelandInfo(reader));
            }
        } catch (IOException e) {
            System.out.println("Please enter correct format!");
        }

        for (Byteland byteland : cases) {
            Scheduler scheduler = new Scheduler(byteland);
            String stepCount = scheduler.calculateStepCount();
            System.out.println(String.format("Step count: %s", stepCount));
        }
    }

    private int getCaseCount(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private Byteland getBytelandInfo(BufferedReader reader) throws IOException {
        int cityCount = Integer.parseInt(reader.readLine());

        String roads = reader.readLine();
        int[] roadMap = Arrays.stream(roads.split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();

        return new Byteland(cityCount, roadMap);
    }

}
